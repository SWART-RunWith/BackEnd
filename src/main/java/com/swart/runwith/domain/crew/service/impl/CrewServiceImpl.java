package com.swart.runwith.domain.crew.service.impl;

import com.swart.runwith.domain.crew.entity.Crew;
import com.swart.runwith.domain.crew.entity.CrewUser;
import com.swart.runwith.domain.crew.mapper.CrewEntityMapper;
import com.swart.runwith.domain.crew.repository.CrewRepository;
import com.swart.runwith.domain.crew.repository.CrewUserRepository;
import com.swart.runwith.domain.crew.response.CrewRankReadServiceResponseDto;
import com.swart.runwith.domain.crew.response.CrewReadServiceResponseDto;
import com.swart.runwith.domain.crew.response.CrewUserReadServiceResponseDto;
import com.swart.runwith.domain.crew.service.CrewService;
import com.swart.runwith.domain.running_data.entity.RunningData;
import com.swart.runwith.domain.running_data.repository.RunningDataRepository;
import com.swart.runwith.domain.user.entity.UserInfo;
import com.swart.runwith.domain.user.exception.UserErrorCode;
import com.swart.runwith.domain.user.exception.UserException;
import com.swart.runwith.domain.user.repository.AuthRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CrewServiceImpl implements CrewService {

    private final AuthRepository authRepository;
    private final CrewUserRepository crewUserRepository;
    private final CrewRepository crewRepository;
    private final RunningDataRepository runningDataRepository;

    private final CrewEntityMapper crewEntityMapper;

    private UserInfo testUserInfo() {
        return authRepository.findById(1L)
            .orElseThrow(() -> new UserException(UserErrorCode.NOT_FOUND_AUTH)).getUserInfo();
    }

    @Override
    public List<CrewUserReadServiceResponseDto> getMyCrew() {
        return crewUserRepository.findByUserInfo(testUserInfo()).stream()
            .map(crewUser ->
                crewEntityMapper.toCrewUserReadServiceResponseDto(crewUser.getCrew()))
            .collect(Collectors.toList());
    }

    @Override
    public CrewReadServiceResponseDto getCrewInfo(final Long crewId) {
        Crew crew = getCrewById(crewId);
        int count = crewUserRepository.findByCrew(crew).size();

        return CrewReadServiceResponseDto.builder()
            .id(crewId)
            .name(crew.getName())
            .count(count)
            .location(crew.getLocation().getLocation())
            .ruleTitle(crew.getNoticeRule().getTitle().isEmpty()
                ? ""
                : crew.getNoticeRule().getTitle())
            .ruleContent(crew.getNoticeRule().getContent().isEmpty()
                ? ""
                : crew.getNoticeRule().getContent()
            )
            .build();
    }

    private Crew getCrewById(final Long crewId) {
        return crewRepository.findById(crewId)
            .orElseThrow(() -> new RuntimeException("크루 없음"));
    }

    @Override
    public List<CrewRankReadServiceResponseDto> getRank(final Long crewId) {
        Crew crew = getCrewById(crewId);
        List<UserInfo> userInfoList = crewUserRepository
            .findByCrew(crew)
            .stream()
            .map(CrewUser::getUserInfo)
            .toList();

        List<CrewRankReadServiceResponseDto> top3Users = userInfoList.stream()
            .map(userInfo -> {
                int totalDistance = getRunningDistanceForLastDay(userInfo);
                return new CrewRankReadServiceResponseDto(
                    userInfo.getId(),
                    userInfo.getName(),
                    totalDistance
                );
            })
            .sorted(Comparator.comparingDouble(CrewRankReadServiceResponseDto::distance)
                .reversed()) // 거리 기준 내림차순 정렬
            .limit(3) // 상위 3명 추출
            .collect(Collectors.toList());

        return top3Users;
    }

    // UserInfo와 연결된 RunningData의 하루 동안의 러닝 데이터를 합산하여 가져오기
    public int getRunningDistanceForLastDay(UserInfo userInfo) {
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay(); // 하루 시작 시점 (0시)
        LocalDateTime endOfDay = startOfDay.plusDays(1); // 하루 종료 시점 (다음 날 0시)

        // 하루 동안의 러닝 데이터를 모두 조회하고, 거리를 합산하여 반환
        return runningDataRepository
            .findByUserInfoAndModifiedAtBetween(userInfo, startOfDay, endOfDay) // 하루 동안의 데이터를 쿼리
            .stream()
            .mapToInt(RunningData::getDistance) // 거리 추출
            .sum(); // 합산
    }

}

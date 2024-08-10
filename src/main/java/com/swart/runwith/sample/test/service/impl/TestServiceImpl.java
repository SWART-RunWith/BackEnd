package com.swart.runwith.sample.test.service.impl;

import com.swart.runwith.sample.test.dto.service.request.TestCreateServiceRequestDto;
import com.swart.runwith.sample.test.dto.service.request.TestUpdateServiceRequestDto;
import com.swart.runwith.sample.test.dto.service.response.TestAllReadServiceResponseDto;
import com.swart.runwith.sample.test.dto.service.response.TestReadServiceResponseDto;
import com.swart.runwith.sample.test.entity.Test;
import com.swart.runwith.sample.test.mapper.TestEntityMapper;
import com.swart.runwith.sample.test.repository.TestRepository;
import com.swart.runwith.sample.test.service.TestService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    // repository
    private final TestRepository testRepository;

    // mapper
    private final TestEntityMapper testEntityMapper;

    /**
     * test 생성
     *
     * @param serviceRequestDto
     */
    @Override
    @Transactional
    public void createTest(final TestCreateServiceRequestDto serviceRequestDto) {
        Test test = testEntityMapper.toTest(serviceRequestDto);
        testRepository.save(test);
    }

    /**
     * test 단건 조회
     *
     * @param testId
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public TestReadServiceResponseDto readTest(final Long testId) {
        Test test = findById(testId);

        return testEntityMapper.toTestReadServiceResponseDto(test);
    }

    /**
     * test 전체 조회
     *
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public TestAllReadServiceResponseDto readAllTest() {
        // stream
        List<TestReadServiceResponseDto> responseDtoStreamList =
            testRepository
                .findAll()
                .stream()
                .map(testEntityMapper::toTestReadServiceResponseDto)
                .toList();

        // for
        List<TestReadServiceResponseDto> responseDtoIterList = new ArrayList<>();
        for (Test test : testRepository.findAll()) {
            responseDtoIterList.add(testEntityMapper.toTestReadServiceResponseDto(test));
        }

        return new TestAllReadServiceResponseDto(responseDtoStreamList);
    }

    /**
     * test 수정
     *
     * @param testId
     */
    @Override
    @Transactional
    public void updateTest(
        final Long testId,
        final TestUpdateServiceRequestDto serviceRequestDto
    ) {
        Test test = findById(testId);
        test.updateTest(serviceRequestDto);
    }

    @Override
    public void deleteTest(final Long testId) {
        Test test = findById(testId);
        testRepository.delete(test);
    }

    /**
     * id로 test 찾기 반복되는 경우 -> extract method
     *
     * @param testId
     * @return
     */
    private Test findById(final Long testId) {
        Test test = testRepository.findById(testId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않은 test 입니다."));
        return test;
    }
}

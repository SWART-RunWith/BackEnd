package com.swart.runwith.domain.running_data.entity;

import com.swart.runwith.domain.running_data.dto.service.request.RunningDataUpdateServiceRequestDto;
import com.swart.runwith.domain.running_shoes.dto.service.request.RunningShoesUpdateServiceRequestDto;
import com.swart.runwith.domain.running_shoes.entity.RunningShoes;

import com.swart.runwith.domain.user.entity.UserInfo;
import com.swart.runwith.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.FetchType;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mapstruct.control.MappingControl.Use;


@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RunningData extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    Integer distance = 0;
    @Column
    Integer time = 0;
    @Column
    Float averagePace = 0.0F;
    @Column
    String course_url;
    @JoinColumn(name = "user_info_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    UserInfo userInfo;
    
    @Builder
    public RunningData(
        final Integer distance,
        final Integer time,
        final Float averagePace,
        final String course_url,
        final UserInfo userInfo
    ) {
        this.distance = distance;
        this.time = time;
        this.averagePace = averagePace;
        this.course_url = course_url;
        this.userInfo = userInfo;
    }
    
    
    public void update(final RunningDataUpdateServiceRequestDto serviceRequestDto) {
        this.distance =
            serviceRequestDto.distance() != null ? serviceRequestDto.distance() : 0;
        this.time = serviceRequestDto.time() != null ? serviceRequestDto.time() : 0;
        this.averagePace = serviceRequestDto.averagePace() != null ? serviceRequestDto.averagePace() : 0.0F;
        this.course_url = serviceRequestDto.courseUrl() != null ? serviceRequestDto.courseUrl() : this.course_url;
    }
 //    다른 테이블이랑 연관 관계를 사용할 때는 OneToMany, ManyToMany 등 연관 관계 어노테이션 사용해야 함
//    여기서는 회원, 러닝화 등이 연관 관계 매핑
    @ManyToOne
    @JoinColumn(nullable = false)
    UserInfo userInfo; // 회원
    @ManyToOne
    @JoinColumn(name = "running_shoes")
    RunningShoes runningShoes; // 러닝화
    @Column
    Integer distance = 0; // 거리
    @Column
    Integer time = 0; // 시간
    @Column
    Float averagePace = 0.0f; // 평균 페이스
    @Column
    String courseUrl; // 코스
    
    @Builder
    public RunningData(
        final UserInfo userInfo,
        final RunningShoes runningShoes,
        final Integer distance,
        final Integer time,
        final Float averagePace,
        final String courseUrl
    ) {
        this.userInfo = userInfo;
        this.runningShoes = runningShoes;
        this.distance = distance;
        this.time = time;
        this.averagePace = averagePace;
        this.courseUrl = courseUrl;
    }
    
//    public void update(final RunningDataUpdateServiceRequestDto serviceRequestDto, RunningShoes runningShoes) {
//        this.runningShoes = runningShoes;
//        this.distance = serviceRequestDto.distance();
//        this.time = serviceRequestDto.time();
//        this.averagePace = serviceRequestDto.averagePace();
//        this.courseUrl = serviceRequestDto.courseUrl();
//    }
}

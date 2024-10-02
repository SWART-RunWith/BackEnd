package com.swart.runwith.domain.running_data.entity;

import com.swart.runwith.domain.running_data.dto.service.request.RunningDataUpdateServiceRequestDto;
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
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


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
        this.averagePace =
            serviceRequestDto.averagePace() != null ? serviceRequestDto.averagePace() : 0.0F;
        this.course_url =
            serviceRequestDto.courseUrl() != null ? serviceRequestDto.courseUrl() : this.course_url;
    }
}

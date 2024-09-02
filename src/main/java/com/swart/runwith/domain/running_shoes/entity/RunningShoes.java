package com.swart.runwith.domain.running_shoes.entity;

import com.swart.runwith.domain.running_shoes.dto.service.request.RunningShoesUpdateServiceRequestDto;
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
public class RunningShoes extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String nickname;
    @Column
    String brand;
    @Column
    String model;
    @Column
    int distance = 0;
    @JoinColumn(name = "user_info_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    UserInfo userInfo;

    @Builder
    public RunningShoes(
        final String nickname,
        final String brand,
        final String model,
        final UserInfo userInfo
    ) {
        this.nickname = nickname;
        this.brand = brand;
        this.model = model;
        this.userInfo = userInfo;
    }


    public void update(final RunningShoesUpdateServiceRequestDto serviceRequestDto) {
        this.nickname =
            serviceRequestDto.nickname() != null ? serviceRequestDto.nickname() : this.nickname;
        this.brand = serviceRequestDto.brand() != null ? serviceRequestDto.brand() : this.brand;
        this.model = serviceRequestDto.model() != null ? serviceRequestDto.model() : this.model;
    }
}

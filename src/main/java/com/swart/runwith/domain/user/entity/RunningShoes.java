package com.swart.runwith.domain.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RunningShoes {

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
    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    UserInfo userInfo;

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
}

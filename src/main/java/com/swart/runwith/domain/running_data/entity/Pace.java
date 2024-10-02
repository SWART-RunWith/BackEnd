package com.swart.runwith.domain.running_data.entity;

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

@Table
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Pace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column
    private int km;
    @Column
    private int second;
    @Column
    private int altitude;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private RunningData runningData;

    @Builder
    public Pace(
        final int km,
        final int second,
        final int altitude,
        final RunningData runningData
    ) {
        this.km = km;
        this.second = second;
        this.altitude = altitude;
        this.runningData = runningData;
    }
}

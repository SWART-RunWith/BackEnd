package com.swart.runwith.domain.user.entity;

import com.swart.runwith.enums.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String name;
    @Column
    String introduction;
    @Column
    String backgroundImageUrl;
    @Column
    String profileImageUrl;
    @Column(nullable = false)
    Gender gender;
    @Column
    float height;
    @Column
    float weight;

    @Builder

    public UserInfo(
        final String name,
        final String introduction,
        final String backgroundImageUrl,
        final String profileImageUrl,
        final Gender gender,
        final float height,
        final float weight
    ) {
        this.name = name;
        this.introduction = introduction;
        this.backgroundImageUrl = backgroundImageUrl;
        this.profileImageUrl = profileImageUrl;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }
}

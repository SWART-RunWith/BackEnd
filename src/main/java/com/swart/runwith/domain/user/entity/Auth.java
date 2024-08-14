package com.swart.runwith.domain.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = true)
    String email;
    @Column(nullable = false)
    String password;
    @OneToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    UserInfo userInfo;

    @Builder
    public Auth(
        final String email,
        final String password,
        final UserInfo userInfo
    ) {
        this.email = email;
        this.password = password;
        this.userInfo = userInfo;
    }
}

package com.swart.runwith.domain.blaclist.entity;

import com.swart.runwith.domain.crew.entity.CrewUser;
import com.swart.runwith.domain.user.entity.UserInfo;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Blacklist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private UserInfo userInfo;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private CrewUser crewUser;

    @Builder
    public Blacklist(
        final UserInfo userInfo,
        final CrewUser crewUser
    ) {
        this.userInfo = userInfo;
        this.crewUser = crewUser;
    }
}

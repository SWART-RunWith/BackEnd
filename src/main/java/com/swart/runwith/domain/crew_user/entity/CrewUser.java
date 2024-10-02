package com.swart.runwith.domain.crew_user.entity;

import com.swart.runwith.domain.crew.entity.Crew;
import com.swart.runwith.domain.user.entity.UserInfo;
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
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CrewUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private boolean permission = true;
    @Column
    private int role = 0;
    @JoinColumn(name = "user_info_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private UserInfo userInfo;
    @JoinColumn(name = "crew_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Crew crew;

    public CrewUser(
        final boolean permission,
        final int role,
        final UserInfo userInfo,
        final Crew crew
    ) {
        this.permission = permission;
        this.role = role;
        this.userInfo = userInfo;
        this.crew = crew;
    }
}

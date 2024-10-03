package com.swart.runwith.domain.notice.entity;

import com.swart.runwith.domain.crew.entity.CrewUser;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column
    protected String title;
    @Column
    protected String content;
    @Column
    protected String imageUrl;
    @JoinColumn(name = "crew_user_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    protected CrewUser crewUser;
}

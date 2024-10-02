package com.swart.runwith.domain.notice_rule.entity;

import com.swart.runwith.domain.crew_user.entity.CrewUser;
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
public class NoticeRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String imageUrl;
    @JoinColumn(name = "crew_user_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private CrewUser crewUser;

    @Builder
    public NoticeRule(
        final String title,
        final String content,
        final String imageUrl,
        final CrewUser crewUser
    ) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.crewUser = crewUser;
    }
}

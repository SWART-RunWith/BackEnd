package com.swart.runwith.domain.notice.entity;

import com.swart.runwith.domain.crew.entity.Crew;
import com.swart.runwith.domain.crew.entity.CrewUser;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
public class NoticeEvent extends Notice {

    @JoinColumn(name = "crew_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Crew crew;

    @Builder
    public NoticeEvent(
        final String title,
        final String content,
        final String imageUrl,
        final CrewUser crewUser,
        final Crew crew
    ) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.crewUser = crewUser;
        this.crew = crew;
    }
}

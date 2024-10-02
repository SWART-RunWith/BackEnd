package com.swart.runwith.domain.crew.entity;

import com.swart.runwith.domain.location.entity.Location;
import com.swart.runwith.domain.notice_event.entity.NoticeEvent;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Crew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String url;
    @Column
    private String content;
    @OneToOne(fetch = FetchType.LAZY)
    private Location location;
    @JoinColumn(name = "notice_event_id")
    @OneToOne(fetch = FetchType.LAZY)
    private NoticeEvent noticeEvent;

    @Builder
    public Crew(
        final String name,
        final String url,
        final String content,
        final Location location
    ) {
        this.name = name;
        this.url = url;
        this.content = content;
        this.location = location;
    }

    public void updateNoticeEvent(NoticeEvent noticeEvent) {
        this.noticeEvent = noticeEvent;
    }
}

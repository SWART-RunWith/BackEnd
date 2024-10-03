package com.swart.runwith.domain.crew.entity;

import com.swart.runwith.domain.location.entity.Location;
import com.swart.runwith.domain.notice.entity.NoticeEvent;
import com.swart.runwith.domain.notice.entity.NoticeRule;
import com.swart.runwith.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Crew extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String url;
    @Column
    private String content;
    @Column
    private Float latitude = 0.0F;
    @Column
    private Float longitude = 0.0F;
    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;
    @JoinColumn(name = "notice_rule_id")
    @OneToOne(fetch = FetchType.LAZY)
    private NoticeRule noticeRule;
    @JoinColumn(name = "notice_event_id")
    @OneToOne(fetch = FetchType.LAZY)
    private NoticeEvent noticeEvent;

    @Builder
    public Crew(
        final String name,
        final String url,
        final String content,
        final Float latitude,
        final Float longitude,
        final Location location,
        final NoticeRule noticeRule,
        final NoticeEvent noticeEvent
    ) {
        this.name = name;
        this.url = url;
        this.content = content;
        this.latitude = latitude;
        this.longitude = longitude;
        this.location = location;
        this.noticeRule = noticeRule;
        this.noticeEvent = noticeEvent;
    }

    public void updateNoticeEvent(NoticeEvent noticeEvent) {
        this.noticeEvent = noticeEvent;
    }
}

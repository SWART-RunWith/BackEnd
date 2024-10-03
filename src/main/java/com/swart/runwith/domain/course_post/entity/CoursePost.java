package com.swart.runwith.domain.course_post.entity;

import com.swart.runwith.domain.course_post.dto.service.request.CoursePostUpdateServiceRequestDto;
import com.swart.runwith.domain.location.entity.Location;
import com.swart.runwith.domain.running_data.entity.RunningData;
import com.swart.runwith.domain.user.entity.UserInfo;
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

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CoursePost extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String title;
    @Column
    String content;
    @Column
    Long likeCount = 0L;
    @OneToOne
    RunningData runningData;
    @ManyToOne
    Location location;
    @JoinColumn(name = "user_info_id")
    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    UserInfo userInfo;

    @Builder
    public CoursePost(
        final String title,
        final String content,
        final Long likeCount,
        final Location location,
        final RunningData runningData,
        final UserInfo userInfo
    ) {
        this.title = title;
        this.content = content;
        this.likeCount = likeCount;
        this.location = location;
        this.runningData = runningData;
        this.userInfo = userInfo;
    }

    public void update(final CoursePostUpdateServiceRequestDto serviceRequestDto) {
        this.title = serviceRequestDto.title();
        this.content = serviceRequestDto.content();
        // 러닝 데이터
    }
}

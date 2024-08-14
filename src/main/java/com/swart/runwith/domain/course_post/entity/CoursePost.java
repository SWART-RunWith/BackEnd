package com.swart.runwith.domain.course_post.entity;

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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CoursePost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String title;
    @Column
    String content;
    @Column
    Long likeCount = 0L;
    // 러닝 데이터 & 코스 추가
    // @OneToOne
    // RunningData runningData;
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
        final UserInfo userInfo
    ) {
        this.title = title;
        this.content = content;
        this.userInfo = userInfo;
    }
}

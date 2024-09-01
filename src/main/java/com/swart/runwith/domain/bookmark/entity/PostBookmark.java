package com.swart.runwith.domain.bookmark.entity;

import com.swart.runwith.domain.course_post.entity.CoursePost;
import com.swart.runwith.domain.user.entity.UserInfo;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table
@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class PostBookmark extends Bookmark {
    
    @JoinColumn(name = "course_post_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    CoursePost coursePost;

    @Builder
    public PostBookmark(
        final UserInfo userInfo,
//        final Folder folder,
        final String title,
        final CoursePost coursePost
    ) {
        this.userInfo = userInfo;
//        this.folder = folder;
        this.title = title;
        this.coursePost = coursePost;
    }
}

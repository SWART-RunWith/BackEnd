package com.swart.runwith.domain.bookmark.repository;

import com.swart.runwith.domain.bookmark.entity.PostBookmark;
import com.swart.runwith.domain.course_post.entity.CoursePost;
import com.swart.runwith.domain.user.entity.UserInfo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostBookmarkRepository extends JpaRepository<PostBookmark, Long> {

    Optional<PostBookmark> findByUserInfoAndCoursePost(
        UserInfo userInfo,
        CoursePost coursePost
    );

}

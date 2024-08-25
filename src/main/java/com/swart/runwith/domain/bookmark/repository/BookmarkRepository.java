package com.swart.runwith.domain.bookmark.repository;

import com.swart.runwith.domain.bookmark.entity.Bookmark;
import com.swart.runwith.domain.course_post.entity.CoursePost;
import com.swart.runwith.domain.user.entity.UserInfo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    Optional<Bookmark> findByUserInfoAndCoursePost(
        UserInfo userInfo,
        CoursePost coursePost
    );

}

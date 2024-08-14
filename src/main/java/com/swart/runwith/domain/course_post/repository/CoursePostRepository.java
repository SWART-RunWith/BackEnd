package com.swart.runwith.domain.course_post.repository;

import com.swart.runwith.domain.course_post.entity.CoursePost;
import com.swart.runwith.domain.user.entity.UserInfo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursePostRepository extends JpaRepository<CoursePost, Long> {

    List<CoursePost> findByUserInfo(UserInfo userInfo);
}

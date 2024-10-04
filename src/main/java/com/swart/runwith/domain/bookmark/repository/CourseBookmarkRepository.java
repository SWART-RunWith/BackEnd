package com.swart.runwith.domain.bookmark.repository;

import com.swart.runwith.domain.bookmark.entity.CourseBookmark;
import com.swart.runwith.domain.folder.entity.Folder;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseBookmarkRepository extends JpaRepository<CourseBookmark, Long> {

    List<CourseBookmark> findByFolder(Folder folder);
}

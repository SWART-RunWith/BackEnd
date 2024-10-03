package com.swart.runwith.domain.folder.repository;

import com.swart.runwith.domain.folder.entity.Folder;
import com.swart.runwith.domain.user.entity.UserInfo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {

    List<Folder> findByUserInfo(UserInfo userInfo);
}

package com.swart.runwith.domain.crew.repository;

import com.swart.runwith.domain.crew.entity.Crew;
import com.swart.runwith.domain.crew.entity.CrewUser;
import com.swart.runwith.domain.user.entity.UserInfo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrewUserRepository extends JpaRepository<CrewUser, Long> {

    List<CrewUser> findByUserInfo(UserInfo userInfo);

    List<CrewUser> findByCrew(Crew crew);
}

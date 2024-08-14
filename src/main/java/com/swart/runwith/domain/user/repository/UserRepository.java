package com.swart.runwith.domain.user.repository;

import com.swart.runwith.domain.user.entity.UserInfo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo, Long> {

    Optional<UserInfo> findByPhone(String phone);
}

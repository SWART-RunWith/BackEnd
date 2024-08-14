package com.swart.runwith.domain.user.repository;

import com.swart.runwith.domain.user.entity.Auth;
import com.swart.runwith.domain.user.entity.UserInfo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Auth, Long> {

    Optional<Auth> findByEmail(String email);

    Optional<Auth> findByUserInfo(UserInfo userInfo);
}

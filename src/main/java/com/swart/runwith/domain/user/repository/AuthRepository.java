package com.swart.runwith.domain.user.repository;

import com.swart.runwith.domain.user.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Auth, Long> {

}

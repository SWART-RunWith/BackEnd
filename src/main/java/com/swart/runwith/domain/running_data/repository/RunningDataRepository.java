package com.swart.runwith.domain.running_data.repository;

import com.swart.runwith.domain.running_data.entity.RunningData;
import com.swart.runwith.domain.user.entity.UserInfo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RunningDataRepository extends JpaRepository<RunningData, Long> {

    Optional<RunningData> findByUserInfo(UserInfo userInfo);
}

package com.swart.runwith.sample.test.repository;

import com.swart.runwith.sample.test.entity.Test;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {

    Optional<Test> findByField(String field);
}

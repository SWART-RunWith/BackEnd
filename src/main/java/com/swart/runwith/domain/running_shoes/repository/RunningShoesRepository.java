package com.swart.runwith.domain.running_shoes.repository;

import com.swart.runwith.domain.running_shoes.entity.RunningShoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunningShoesRepository extends JpaRepository<RunningShoes, Long> {

}

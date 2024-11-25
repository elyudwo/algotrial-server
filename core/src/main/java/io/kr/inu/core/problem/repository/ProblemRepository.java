package io.kr.inu.core.problem.repository;

import io.kr.inu.core.problem.domain.ProblemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<ProblemEntity, Long> {
}

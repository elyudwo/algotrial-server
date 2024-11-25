package io.kr.inu.core.problem.repository;

import io.kr.inu.core.problem.domain.TestCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCaseRepository extends JpaRepository<TestCaseEntity, Long> {
}

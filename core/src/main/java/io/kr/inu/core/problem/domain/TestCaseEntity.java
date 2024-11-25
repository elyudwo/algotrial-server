package io.kr.inu.core.problem.domain;

import io.kr.inu.core.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestCaseEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String problem;

    private String answer;

    @ManyToOne
    @JoinColumn(name = "problem_id")
    private ProblemEntity problemEntity;

    @Builder
    public TestCaseEntity(String problem, String answer) {
        this.problem = problem;
        this.answer = answer;
    }
}

package io.kr.inu.core.problem.domain;

import io.kr.inu.core.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class ProblemEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "problem_id")
    private Long id;

    @Column(nullable = false, name = "time_complexity")
    private double timeComplexity;

    @Column(nullable = false, name = "space_complexity")
    private double spaceComplexity;

    private String title;

    private String content;

    @Setter
    @OneToMany(mappedBy = "problemEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TestCaseEntity> testCases;

    @Builder
    public ProblemEntity(double timeComplexity, double spaceComplexity, String title, String content, List<TestCaseEntity> testCases) {
        this.timeComplexity = timeComplexity;
        this.spaceComplexity = spaceComplexity;
        this.title = title;
        this.content = content;
        this.testCases = testCases;
    }

}

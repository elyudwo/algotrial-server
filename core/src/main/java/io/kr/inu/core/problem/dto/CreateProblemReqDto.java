package io.kr.inu.core.problem.dto;

import io.kr.inu.core.problem.domain.ProblemEntity;
import io.kr.inu.core.problem.domain.TestCaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class CreateProblemReqDto {

    public double timeComplexity;
    public double spaceComplexity;
    public String title;
    public String content;
    public List<TestCaseDto> testCases;

    @Builder
    public CreateProblemReqDto(double timeComplexity, double spaceComplexity, String title, String content, List<TestCaseDto> testCases) {
        this.timeComplexity = timeComplexity;
        this.spaceComplexity = spaceComplexity;
        this.title = title;
        this.content = content;
        this.testCases = testCases;
    }

    public ProblemEntity toProblemEntity(List<TestCaseEntity> testCaseEntity) {
        return ProblemEntity.builder()
                .timeComplexity(timeComplexity)
                .spaceComplexity(spaceComplexity)
                .title(title)
                .content(content)
                .testCases(testCaseEntity)
                .build();
    }

    public List<TestCaseEntity> toTestCaseEntity() {
        List<TestCaseEntity> testCaseEntities = new ArrayList<>();

        for(TestCaseDto dto : testCases) {
            testCaseEntities.add(TestCaseEntity.builder()
                    .answer(dto.answer)
                    .problem(dto.problem)
                    .build());
        }

        return testCaseEntities;
    }
}

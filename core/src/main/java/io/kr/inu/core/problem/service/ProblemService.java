package io.kr.inu.core.problem.service;

import io.kr.inu.core.problem.domain.ProblemEntity;
import io.kr.inu.core.problem.domain.TestCaseEntity;
import io.kr.inu.core.problem.dto.CreateProblemReqDto;
import io.kr.inu.core.problem.repository.ProblemRepository;
import io.kr.inu.infra.s3.InputOutputS3Repository;
import io.kr.inu.infra.s3.MultipartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProblemService {

    private final ProblemRepository problemRepository;
    private final InputOutputS3Repository inputOutputS3Repository;

    @Transactional
    public void createProblem(CreateProblemReqDto createProblemReqDto,
                              MultipartFile input, MultipartFile output) {
        List<TestCaseEntity> testCaseEntity = createProblemReqDto.toTestCaseEntity();
        ProblemEntity problemEntity = createProblemReqDto.toProblemEntity(testCaseEntity);
        ProblemEntity problem = problemRepository.save(problemEntity);
        createTestCaseFile(problem.getId(), input, output);
    }

    public void createTestCaseFile(Long problemId, MultipartFile input, MultipartFile output) {
        try {
            MultipartDto inputDto = new MultipartDto(input.getOriginalFilename(), input.getSize(),
                    input.getContentType(), input.getInputStream());
            MultipartDto outputDto = new MultipartDto(output.getOriginalFilename(), output.getSize(),
                    output.getContentType(), output.getInputStream());

            String inputName = "inputData:" + problemId;
            String outputName = "outputData:" + problemId;
            inputOutputS3Repository.insertTestCases(inputName, inputDto);
            inputOutputS3Repository.insertTestCases(outputName, outputDto);
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed upload Test Data");
        }
    }
}

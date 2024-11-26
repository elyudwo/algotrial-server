package io.kr.inu.webclient.api.problem;

import io.kr.inu.core.problem.dto.CreateProblemReqDto;
import io.kr.inu.core.problem.dto.TestCaseDto;
import io.kr.inu.core.problem.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/problem")
public class ProblemController {

    private final ProblemService problemService;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Void> createProblem(@RequestPart(name = "input") MultipartFile input,
                                              @RequestPart(name = "output") MultipartFile output,
                                              @RequestPart(name = "problem") CreateProblemReqDto createProblemReqDto
    ) {
        problemService.createProblem(createProblemReqDto, input, output);
        return ResponseEntity.ok().build();
    }
}

package io.kr.inu.webclient.api.problem;

import io.kr.inu.core.problem.dto.CreateProblemReqDto;
import io.kr.inu.core.problem.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/problem")
public class ProblemController {

    private final ProblemService problemService;

    @PostMapping
    public ResponseEntity<Void> createProblem(@RequestBody CreateProblemReqDto createProblemReqDto) {
        problemService.createProblem(createProblemReqDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/testcase")
    public ResponseEntity<Void> createTestCase(@RequestPart(name = "input") MultipartFile input,
                                               @RequestPart(name = "output") MultipartFile output) {
        problemService.createTestCaseFile(input, output);
        return ResponseEntity.ok().build();
    }
}

package io.kr.inu.core.problem.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class TestCaseDto implements Serializable {

    public String problem;
    public String answer;
}

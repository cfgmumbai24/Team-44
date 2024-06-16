package com.vopa.service;

import java.util.List;

import com.vopa.payload.TestDto;

public interface TestService {
	public TestDto createTest(TestDto testDto,Integer teacherId,Integer studentId);
	public TestDto getTestById(Integer testId);
	public List<TestDto> getAllTests();
}

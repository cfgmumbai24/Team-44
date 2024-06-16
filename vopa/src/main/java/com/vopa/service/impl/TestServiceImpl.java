package com.vopa.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vopa.entities.Student;
import com.vopa.entities.Teacher;
import com.vopa.entities.Test;
import com.vopa.payload.TestDto;
import com.vopa.repository.TestRepository;
import com.vopa.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestRepository testRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public TestDto createTest(TestDto testDto,Integer teacherId,Integer studentId) {
		Test test = dtoToTest(testDto);
		//test.setTimestamp(new Date());
		Teacher teacher=new Teacher();
		teacher.setId(teacherId);
		Student student=new Student();
		student.setId(studentId);
		test.setTeacher(teacher);
		test.setStudent(student);
		Test savedTest= testRepository.save(test);
		return testToDto(savedTest);
	}

	@Override
	public TestDto getTestById(Integer testId) {
		Test test = testRepository.findById(testId).orElseThrow();
		return testToDto(test);
	}

	@Override
	public List<TestDto> getAllTests() {
		List<Test> tests = testRepository.findAll();
		List<TestDto> testDtos = tests.stream().map((test)->testToDto(test)).collect(Collectors.toList());
		return testDtos;
	}
	
	
	//dto to test
	public Test dtoToTest(TestDto testDto) {
		return modelMapper.map(testDto, Test.class);
	}
	//test to dto
	public TestDto testToDto(Test test) {
		return modelMapper.map(test, TestDto.class);
	}
}

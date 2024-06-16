package com.vopa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vopa.payload.TestDto;
import com.vopa.service.TestService;

@RestController
@RequestMapping("/api/test")
public class TestController {
	@Autowired
	private TestService testService;
	
	@PostMapping("/{teacherId}/{studentId}")
	public ResponseEntity<TestDto> createTest(@RequestBody TestDto testDto,@RequestBody Integer teacherId,@RequestBody Integer studentId){
		TestDto test = testService.createTest(testDto,teacherId,studentId);
		return new ResponseEntity<TestDto>(test,HttpStatus.CREATED);
	}
	@GetMapping("/{testId}")
	public ResponseEntity<TestDto> getTestById(@PathVariable Integer testId){
		TestDto testDto = testService.getTestById(testId);
		return ResponseEntity.ok(testDto);
	}
	@GetMapping("/")
	public ResponseEntity<List<TestDto>> getAllTests(){
		List<TestDto> tests = testService.getAllTests();
		return ResponseEntity.ok(tests);
	}
	
	
}

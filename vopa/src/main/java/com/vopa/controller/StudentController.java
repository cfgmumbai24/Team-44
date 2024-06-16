package com.vopa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vopa.payload.StudentDto;
import com.vopa.service.InfoService;
import com.vopa.service.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins="http://localhost:5173")
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private InfoService infoService;
	
	@PostMapping("/")
	public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
		StudentDto student = studentService.createStudent(studentDto);
		return new ResponseEntity<StudentDto>(student,HttpStatus.CREATED);
	}
	@GetMapping("/{studentId}")
	public ResponseEntity<StudentDto> getStudentById(@PathVariable Integer studentId) {
		StudentDto studentDto = studentService.getStudentById(studentId);
		return ResponseEntity.ok(studentDto);
	}
	@GetMapping("/")
	public ResponseEntity<List<StudentDto>> getAllStudents(){
		List<StudentDto> students = studentService.getAllStudents();
		return ResponseEntity.ok(students);
	}
	@GetMapping("/std/{std}")
	public ResponseEntity<List<StudentDto>> getStudentByStd(@PathVariable int std){
		List<StudentDto> students = studentService.getStudentByStd(std);
		return ResponseEntity.ok(students);
	}
}

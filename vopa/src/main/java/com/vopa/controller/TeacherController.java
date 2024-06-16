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

import com.vopa.payload.TeacherDto;
import com.vopa.service.TeacherService;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	
	@PostMapping("/")
	public ResponseEntity<TeacherDto> createTeacher(@RequestBody TeacherDto teacherDto){
		TeacherDto teacher = teacherService.createTeacher(teacherDto);
		return new ResponseEntity<TeacherDto>(teacher,HttpStatus.CREATED);
	}
	
	@GetMapping("/{teacherId}")
	public ResponseEntity<TeacherDto> getTeacherById(@PathVariable Integer teacherId){
		TeacherDto teacherDto = teacherService.getTeacherById(teacherId);
		return ResponseEntity.ok(teacherDto);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<TeacherDto>> getAllTeachers(){
		List<TeacherDto> teachers = teacherService.getAllTeachers();
		return ResponseEntity.ok(teachers);
	}
	
}

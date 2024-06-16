package com.vopa.service;

import java.util.List;

import com.vopa.payload.StudentDto;

public interface StudentService {
	public StudentDto createStudent(StudentDto studentDto);
	public StudentDto getStudentById(Integer studentId);
	public List<StudentDto> getAllStudents();
	public List<StudentDto> getStudentByStd(Integer std);
}

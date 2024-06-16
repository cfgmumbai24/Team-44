package com.vopa.service;

import java.util.List;

import com.vopa.payload.TeacherDto;

public interface TeacherService {
	public TeacherDto createTeacher(TeacherDto teacherDto);
	public TeacherDto getTeacherById(Integer teacherId);
	public List<TeacherDto> getAllTeachers();
}

package com.vopa.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vopa.entities.Teacher;
import com.vopa.payload.TeacherDto;
import com.vopa.repository.TeacherRepository;
import com.vopa.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public TeacherDto createTeacher(TeacherDto teacherDto) {
		Teacher teacher = dtoToTeacher(teacherDto);
		Teacher savedTeacher = teacherRepository.save(teacher);
		return teacherToDto(savedTeacher);
	}

	@Override
	public TeacherDto getTeacherById(Integer teacherId) {
		Teacher teacher = teacherRepository.findById(teacherId).orElseThrow();
		return teacherToDto(teacher);
	}

	@Override
	public List<TeacherDto> getAllTeachers() {
		List<Teacher> teachers = teacherRepository.findAll();
		List<TeacherDto> teacherDtos=teachers.stream().map((teacher)-> teacherToDto(teacher)).collect(Collectors.toList());
		return teacherDtos;
	}
	
	
	//dto to teacher
	public Teacher dtoToTeacher(TeacherDto teacherDto) {
		return modelMapper.map(teacherDto, Teacher.class);
	}
	//teacher to dto
	public TeacherDto teacherToDto(Teacher teacher) {
		return modelMapper.map(teacher, TeacherDto.class);
	}
	
}

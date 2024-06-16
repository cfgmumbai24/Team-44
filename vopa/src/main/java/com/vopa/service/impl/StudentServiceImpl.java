package com.vopa.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vopa.entities.Info;
import com.vopa.entities.Student;
import com.vopa.payload.InfoDto;
import com.vopa.payload.LevelDto;
import com.vopa.payload.StudentDto;
import com.vopa.payload.TeacherDto;
import com.vopa.repository.InfoRepository;
import com.vopa.repository.StudentRepository;
import com.vopa.service.InfoService;
import com.vopa.service.StudentService;
import com.vopa.service.TeacherService;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private InfoRepository infoRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private InfoService infoService;
    @Autowired
    private TeacherService teacherService;
    
    
    
    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        // Convert DTO to entity
        Student student = dtoToStudent(studentDto);
        
        // Save student entity
        Student savedStudent = studentRepository.save(student);
        
        // Create LevelDto and InfoDto
        LevelDto levelDto = new LevelDto();
        levelDto.setId(1);
        
        InfoDto infoDto = new InfoDto();
        infoDto.setStudentDto(studentToDto(savedStudent)); // Use savedStudent to ensure IDs are set
        infoDto.setLevel(levelDto);
        
        TeacherDto teacherDto = teacherService.getTeacherById(1);
        infoDto.setTeacher(teacherDto);
        
        // Convert InfoDto to entity
        Info info = dtoToInfo(infoDto);
        
        // Save info entity
        infoRepository.save(info);

        
        // Call InfoService to handle further processing if any
       // infoService.createInfo(infoDto);
        
        // Return the saved student as a DTO
        return studentToDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(Integer studentId) {
        // Find student by ID or throw an exception
        Student student = studentRepository.findById(studentId).orElseThrow();
        
        // Convert entity to DTO
        return studentToDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        // Find all students
        List<Student> students = studentRepository.findAll();
        
        // Convert entities to DTOs
        List<StudentDto> studentDtos = students.stream()
            .map(this::studentToDto)
            .collect(Collectors.toList());
        
        return studentDtos;
    }

    @Override
	public List<StudentDto> getStudentByStd(Integer std) {
		List<Student> students = studentRepository.findByStd(std);
		List<StudentDto> studentDtos=students.stream().map((student)->studentToDto(student)).collect(Collectors.toList());
		return studentDtos;
	}
    
    // Helper method to convert Student to StudentDto
    private StudentDto studentToDto(Student student) {
        return modelMapper.map(student, StudentDto.class);
    }

    // Helper method to convert StudentDto to Student
    private Student dtoToStudent(StudentDto studentDto) {
        return modelMapper.map(studentDto, Student.class);
    }

    // Helper method to convert InfoDto to Info
    private Info dtoToInfo(InfoDto infoDto) {
        return modelMapper.map(infoDto, Info.class);
    }

    // Helper method to convert Info to InfoDto
    private InfoDto infoToDto(Info info) {
        return modelMapper.map(info, InfoDto.class);
    }

	
}

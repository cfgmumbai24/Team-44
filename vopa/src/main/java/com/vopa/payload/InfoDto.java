package com.vopa.payload;


import lombok.Data;

@Data
public class InfoDto {
	private int id;
	private LevelDto level;
	private TeacherDto teacher;
	private StudentDto studentDto;
}

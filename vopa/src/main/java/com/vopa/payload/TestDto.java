package com.vopa.payload;

import java.util.Date;

import com.vopa.entities.Student;

import lombok.Data;

@Data
public class TestDto {
	private int id;
	private Date timestamp;
	private String score;
    private Student student;
    private Student teacher;
}

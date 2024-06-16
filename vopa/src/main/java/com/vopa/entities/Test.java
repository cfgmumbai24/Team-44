package com.vopa.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Test {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//private Date timestamp;
	private String score;
	
	@ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
	@ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}

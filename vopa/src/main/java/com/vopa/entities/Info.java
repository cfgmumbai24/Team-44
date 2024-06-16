package com.vopa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Info {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="level_id")
	private Level level;
	@ManyToOne
	@JoinColumn(name="teacher_id")
	private Teacher teacher;
	@ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
	
}

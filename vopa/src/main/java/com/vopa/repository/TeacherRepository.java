package com.vopa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vopa.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
	

}

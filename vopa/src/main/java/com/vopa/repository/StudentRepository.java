package com.vopa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vopa.entities.Student;
import com.vopa.payload.StudentDto;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByStd(int std);
}

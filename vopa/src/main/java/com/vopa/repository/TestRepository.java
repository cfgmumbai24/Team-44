package com.vopa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vopa.entities.Test;

public interface TestRepository extends JpaRepository<Test, Integer>{

}

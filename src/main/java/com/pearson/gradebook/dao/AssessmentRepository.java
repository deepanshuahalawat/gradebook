package com.pearson.gradebook.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pearson.gradebook.entity.Assesment;

public interface AssessmentRepository extends JpaRepository<Assesment, Long>{

}

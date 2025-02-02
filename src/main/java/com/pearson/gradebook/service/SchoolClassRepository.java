package com.pearson.gradebook.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pearson.gradebook.entity.SchoolClass;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {

}

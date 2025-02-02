package com.pearson.gradebook.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pearson.gradebook.entity.SchoolClass;

public interface ClassRepository extends JpaRepository<SchoolClass, Long>{

}

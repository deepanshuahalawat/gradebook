package com.pearson.gradebook.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pearson.gradebook.entity.SchoolClass;
import com.pearson.gradebook.entity.User;

public interface UserDao extends JpaRepository<User, Long>{
	
	List<User> findByStudentClass(SchoolClass studentClass);
	
}

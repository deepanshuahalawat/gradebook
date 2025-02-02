package com.pearson.gradebook.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pearson.gradebook.entity.Assesment;
import com.pearson.gradebook.entity.Assignment;
import com.pearson.gradebook.entity.Result;
import com.pearson.gradebook.entity.User;

public interface ResultRepository extends JpaRepository<Result, Long>{
	
	List<Result> findResultByStudent(User user);
	
	List<Result> findResultByStudentAndAssesment(User user, Assesment assesment);
	
	List<Result> findResultByStudentAndAssesmentIn(User user, List<Assesment> assesments);
	
	List<Result> findResultByStudentIn(List<User> users);
	
	List<Result> findResultByStudentInAndAssesmentIn(List<User> users, List<Assesment> assesments);
	
}

package com.pearson.gradebook.util;

import java.util.Date;

import com.pearson.gradebook.entity.Assesment;
import com.pearson.gradebook.entity.Result;
import com.pearson.gradebook.entity.User;

public class ResultBuilder {
	
	private Result result;
	
	public ResultBuilder() {
		result = new Result();
	}
	public Result build() {
		return result;
	}
	public ResultBuilder studdent(User student) {
		result.setStudent(student);
		return this;
	}
	
	public ResultBuilder assesment(Assesment assesment) {
		result.setAssesment(assesment);
		return this;
	}
	public ResultBuilder score(Float score) {
		result.setScore(score);
		return this;
	}
	public ResultBuilder date(Date date) {
		result.setDate(date);
		return this;
	}
	
	
}

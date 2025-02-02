package com.pearson.gradebook.dto;

import java.util.List;

public class AssignmentDto {

	Long id;
	
	List<AssesmentDto> assessments;

	String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<AssesmentDto> getAssessments() {
		return assessments;
	}

	public void setAssesments(List<AssesmentDto> assessments) {
		this.assessments = assessments;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AssignmentDto [id=" + id + ", assessments=" + assessments + ", name=" + name + "]";
	}
	
	
}

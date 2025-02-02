package com.pearson.gradebook.dto;

import lombok.Data;

@Data
public class StudentCourseScoreDto extends StudentScoreDto{
	private CourseBaseDto course;
}

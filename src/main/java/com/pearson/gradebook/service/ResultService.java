package com.pearson.gradebook.service;

import com.pearson.gradebook.dto.ClassScoreDto;
import com.pearson.gradebook.dto.StudentAssessmentScoreDto;
import com.pearson.gradebook.dto.StudentCourseScoreDto;
import com.pearson.gradebook.dto.StudentScoreDto;
import com.pearson.gradebook.dto.StudentScoreRequestDto;

public interface ResultService {
	
	StudentScoreRequestDto saveResult(StudentScoreRequestDto dto);
	
	public StudentScoreDto studentOverallResult( Long studentId) throws Exception;
	
	public StudentAssessmentScoreDto studentAssessmentResult( Long studentId, Long assessmentId) throws Exception;
	
	public StudentCourseScoreDto studentCourseResult( Long studentId, Long courseId) throws Exception;
	
	public ClassScoreDto classResult(Long classId) throws Exception;
	
	public ClassScoreDto classCourseResult(Long classId,Long courseId) throws Exception;
}

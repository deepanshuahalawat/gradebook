package com.pearson.gradebook.mapper.impl;

import org.springframework.stereotype.Component;

import com.pearson.gradebook.dto.ScoreDto;
import com.pearson.gradebook.dto.StudentScoreRequestDto;
import com.pearson.gradebook.entity.Result;

@Component
public class CustomResultMapperImpl {
	
	public Result dtoToEntity(StudentScoreRequestDto dto) {
		
		return null;
	}
	
	
	public StudentScoreRequestDto entityToDto(Result result) {
		if(result == null) {
			return null;
		}
		StudentScoreRequestDto dto = new StudentScoreRequestDto();
		dto.setId(result.getId());
		dto.setAssessmentId(result.getAssesment().getId());
		dto.setCourseId(result.getAssesment().getAssignment().getCourse().getId());
		ScoreDto score = new ScoreDto();
		score.setPointsEarned(result.getScore());
		dto.setScore(score);
		dto.setUserId(result.getStudent().getId());
		dto.setDtSubmitted(result.getDate());
		
		return dto;
	}
}

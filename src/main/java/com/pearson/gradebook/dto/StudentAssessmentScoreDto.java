package com.pearson.gradebook.dto;

import lombok.Data;

@Data
public class StudentAssessmentScoreDto extends StudentScoreDto{

	private AssesmentDto assessment;
}

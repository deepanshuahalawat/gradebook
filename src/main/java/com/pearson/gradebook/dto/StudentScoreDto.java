package com.pearson.gradebook.dto;

import lombok.Data;

@Data
public class StudentScoreDto extends ScoreDto{
	private UserBaseDto student;
}

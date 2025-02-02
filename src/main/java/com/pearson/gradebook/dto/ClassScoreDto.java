package com.pearson.gradebook.dto;

import com.pearson.gradebook.entity.SchoolClass;

import lombok.Data;

@Data
public class ClassScoreDto extends ScoreDto{

	private SchoolClass schoolClass;
}

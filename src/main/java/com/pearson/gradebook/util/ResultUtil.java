package com.pearson.gradebook.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pearson.gradebook.entity.Result;

@Component
public class ResultUtil {
	
	public float getTotalMaximumPoints(List<Result> results) {
		if(results == null) {
			return 0;
		}
		return  results.stream()
				.map( result -> result.getAssesment().getPossiblePoints())
				.reduce(0f, (a,b) -> a+b);
	}
	
	
	public float getTotalGainedPoints(List<Result> results) {
		if(results == null) {
			return 0;
		}
		return  results.stream().map(result -> result.getScore())
				.reduce(0f, (a,b) -> a+b);
	}
	
	
}

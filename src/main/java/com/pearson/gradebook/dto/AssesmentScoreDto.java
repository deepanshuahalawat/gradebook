package com.pearson.gradebook.dto;

import java.util.Date;

public class AssesmentScoreDto {
	String courseId;
	String userId;
	String assesmentId;
	Date dtSubmitted;
	ScoreDto score;
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAssesmentId() {
		return assesmentId;
	}
	public void setAssesmentId(String assesmentId) {
		this.assesmentId = assesmentId;
	}
	public Date getDtSubmitted() {
		return dtSubmitted;
	}
	public void setDtSubmitted(Date dtSubmitted) {
		this.dtSubmitted = dtSubmitted;
	}
	public ScoreDto getScore() {
		return score;
	}
	public void setScore(ScoreDto score) {
		this.score = score;
	}
	
	
}

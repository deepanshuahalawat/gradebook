package com.pearson.gradebook.dto;

import java.util.Date;

public class StudentScoreRequestDto {

	Long id;
	Long courseId;
	Long userId;
	Long assessmentId;
	Date dtSubmitted;
	ScoreDto score;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getAssessmentId() {
		return assessmentId;
	}
	public void setAssessmentId(Long assessmentId) {
		this.assessmentId = assessmentId;
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
	@Override
	public String toString() {
		return "StudentScoreRequestDto [id=" + id + ", courseId=" + courseId + ", userId=" + userId + ", assessmentId="
				+ assessmentId + ", dtSubmitted=" + dtSubmitted + ", score=" + score + "]";
	}
	
	
	
}

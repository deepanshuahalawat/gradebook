package com.pearson.gradebook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pearson.gradebook.dto.ClassScoreDto;
import com.pearson.gradebook.dto.StudentAssessmentScoreDto;
import com.pearson.gradebook.dto.StudentCourseScoreDto;
import com.pearson.gradebook.dto.StudentScoreDto;
import com.pearson.gradebook.dto.StudentScoreRequestDto;
import com.pearson.gradebook.service.ResultService;

@RestController
@RequestMapping("/api/result")
public class ResultController {
	
	
	private ResultService resultService;
	
	public ResultController(ResultService resultService) {
		this.resultService = resultService;
	}
	
	@PostMapping("/save")
	public ResponseEntity<StudentScoreRequestDto> saveResult(@RequestBody StudentScoreRequestDto dto) {
		return new  ResponseEntity<StudentScoreRequestDto>(resultService.saveResult(dto),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/student/{studentId}")
	public ResponseEntity<StudentScoreDto> studentOverallResult(@PathVariable Long studentId) throws Exception {
		StudentScoreDto score = resultService.studentOverallResult(studentId);
		return new ResponseEntity<StudentScoreDto>(score, HttpStatus.OK);
	}
	
	@GetMapping("/student/{studentId}/assmt/{assessmentId}")
	public ResponseEntity<StudentAssessmentScoreDto> studentAssessmentResult(@PathVariable Long studentId, @PathVariable Long assessmentId) throws Exception{
		StudentAssessmentScoreDto score = resultService.studentAssessmentResult(studentId, assessmentId);
		return new ResponseEntity<StudentAssessmentScoreDto>(score, HttpStatus.OK);
	}
	
	@GetMapping("/student/{studentId}/course/{courseId}")
	public ResponseEntity<StudentCourseScoreDto> studentCourseResult(@PathVariable Long studentId, @PathVariable Long courseId)throws Exception{
		StudentCourseScoreDto score = resultService.studentCourseResult(studentId, courseId);
		return new ResponseEntity<StudentCourseScoreDto>(score, HttpStatus.OK);
	}
	
	@GetMapping("/class/{classId}")
	public ResponseEntity<ClassScoreDto> classResult(@PathVariable Long classId)throws Exception{
		ClassScoreDto score = resultService.classResult(classId);
		return new ResponseEntity<ClassScoreDto>(score, HttpStatus.OK);
	}
	
	@GetMapping("/class/{classId}/course/{courseId}")
	public ResponseEntity<ClassScoreDto> classCourseResult(@PathVariable Long classId, @PathVariable Long courseId) throws Exception{
		ClassScoreDto score = resultService.classCourseResult(classId, courseId);
		return new ResponseEntity<ClassScoreDto>(score, HttpStatus.OK);
	}
	
	
	
	
}

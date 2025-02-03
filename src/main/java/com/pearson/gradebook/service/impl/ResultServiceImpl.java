package com.pearson.gradebook.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pearson.gradebook.controller.UserController;
import com.pearson.gradebook.dao.AssessmentRepository;
import com.pearson.gradebook.dao.CourseRepository;
import com.pearson.gradebook.dao.UserRepository;
import com.pearson.gradebook.dto.AssesmentDto;
import com.pearson.gradebook.dto.ClassCourseScoreDto;
import com.pearson.gradebook.dto.ClassScoreDto;
import com.pearson.gradebook.dto.StudentAssessmentScoreDto;
import com.pearson.gradebook.dto.StudentCourseScoreDto;
import com.pearson.gradebook.dto.StudentScoreDto;
import com.pearson.gradebook.dto.StudentScoreRequestDto;
import com.pearson.gradebook.dto.UserBaseDto;
import com.pearson.gradebook.entity.Assesment;
import com.pearson.gradebook.entity.Assignment;
import com.pearson.gradebook.entity.Course;
import com.pearson.gradebook.entity.Result;
import com.pearson.gradebook.entity.SchoolClass;
import com.pearson.gradebook.entity.User;
import com.pearson.gradebook.exception.customexception.UserNotFoundException;
import com.pearson.gradebook.mapper.impl.CustomAssesmentMapperImpl;
import com.pearson.gradebook.mapper.impl.CustomCourseMapperImpl;
import com.pearson.gradebook.mapper.impl.CustomResultMapperImpl;
import com.pearson.gradebook.mapper.impl.CustomUserMapperImpl;
import com.pearson.gradebook.service.ResultRepository;
import com.pearson.gradebook.service.ResultService;
import com.pearson.gradebook.service.SchoolClassRepository;
import com.pearson.gradebook.util.ResultBuilder;
import com.pearson.gradebook.util.ResultUtil;


@Service
public class ResultServiceImpl implements ResultService{

	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private ResultRepository resultRepository;
	
	@Autowired
	private CustomResultMapperImpl customResultMapperImpl;
	
	@Autowired
	private CustomUserMapperImpl customUserMapperImpl;
	
	@Autowired
	private CustomAssesmentMapperImpl assesmentMapperImpl;
	
	@Autowired
	private CustomCourseMapperImpl courseMapperImpl;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private AssessmentRepository assessmentRepository;
	
	@Autowired
	private SchoolClassRepository classRepository;
	
	@Autowired
	private ResultUtil resultUtil;
	
	public ResultServiceImpl(ResultRepository resultRepository) {
		this.resultRepository = resultRepository;
	}
	
	@Override
	public StudentScoreRequestDto saveResult(StudentScoreRequestDto dto) {
		// TODO Auto-generated method stub
		User student = userRepository.findById(dto.getUserId()).get();
		Course course =  courseRepository.findById(dto.getCourseId()).get();
		Assesment assesment=null;
		if(course != null && student != null) {
			for(Assignment assignment: course.getAssignments()) {
				for(Assesment asmt: assignment.getAssesments()) {
					if(asmt.getId().equals(dto.getAssessmentId())) {
						assesment = asmt;
					}
				}
			}
			Result result = new ResultBuilder()
			.assesment(assesment)
			.studdent(student)
			.score(dto.getScore().getPointsEarned())
			.date(dto.getDtSubmitted())
			.build();
			
			logger.info("Build result: "+result);
			
			Result savedResult = resultRepository.save(result);
			return customResultMapperImpl.entityToDto(savedResult);
		}
		return null;
	}
	
	
	public StudentScoreDto studentOverallResult( Long studentId) throws UserNotFoundException{
		User student = userRepository.findById(studentId).orElseThrow(() -> new UserNotFoundException() );
		
		List<Result> results  = resultRepository.findResultByStudent(student);
		
		float maximumPoints = resultUtil.getTotalMaximumPoints(results);
		float gainedPoints = resultUtil.getTotalGainedPoints(results);
		
		
		StudentScoreDto scoreDto = new StudentScoreDto();
		scoreDto.setStudent(customUserMapperImpl.entityToBaseDto(student));
		scoreDto.setMaximumPoints(maximumPoints);
		scoreDto.setPointsEarned(gainedPoints);
		
		
		return scoreDto;
	}
	
	public StudentAssessmentScoreDto studentAssessmentResult( Long studentId, Long assessmentId)throws Exception{
		User student = userRepository.findById(studentId).orElseThrow(() -> new UserNotFoundException() );
		Assesment assessment = assessmentRepository.findById(assessmentId).get();
		List<Result> results  = resultRepository.findResultByStudentAndAssesment(student, assessment);
		
		float maximumPoints = resultUtil.getTotalMaximumPoints(results);
		float gainedPoints = resultUtil.getTotalGainedPoints(results);
		
		StudentAssessmentScoreDto scoreDto = new StudentAssessmentScoreDto();
		scoreDto.setStudent(customUserMapperImpl.entityToBaseDto(student));
		scoreDto.setMaximumPoints(maximumPoints);
		scoreDto.setPointsEarned(gainedPoints);
		scoreDto.setAssessment(assesmentMapperImpl.entityToDto(assessment));
		
		return scoreDto;
	}
	
	public StudentCourseScoreDto studentCourseResult( Long studentId, Long courseId) throws Exception{
		User student = userRepository.findById(studentId).orElseThrow(() -> new UserNotFoundException() );
		Course course = courseRepository.findById(courseId).get();
		List<Assesment> assessments = new LinkedList<>();
		course.getAssignments().forEach(asgmnt -> assessments.addAll(asgmnt.getAssesments()));
		
		List<Result> results  = resultRepository.findResultByStudentAndAssesmentIn(student, assessments);
		
		float maximumPoints = resultUtil.getTotalMaximumPoints(results);
		float gainedPoints = resultUtil.getTotalGainedPoints(results);
		
		StudentCourseScoreDto scoreDto = new StudentCourseScoreDto();
		scoreDto.setStudent(customUserMapperImpl.entityToBaseDto(student));
		scoreDto.setMaximumPoints(maximumPoints);
		scoreDto.setPointsEarned(gainedPoints);
		scoreDto.setCourse(courseMapperImpl.entityToBaseDTO(course));
		return scoreDto;
	}
	
	public ClassScoreDto classResult(Long classId){
		
		SchoolClass schoolClass = classRepository.findById(classId).get();
		List<User> students = userRepository.findByStudentClass(schoolClass);
		
		
		List<Result> results  = resultRepository.findResultByStudentIn(students);
		
		float maximumPoints = resultUtil.getTotalMaximumPoints(results);
		float gainedPoints = resultUtil.getTotalGainedPoints(results);
		
		ClassScoreDto classScoreDto = new ClassScoreDto();
		classScoreDto.setSchoolClass(schoolClass);
		classScoreDto.setMaximumPoints(maximumPoints);
		classScoreDto.setPointsEarned(gainedPoints);
		
		return classScoreDto;
	}
	
	public ClassScoreDto classCourseResult(Long classId,Long courseId){
		SchoolClass schoolClass = classRepository.findById(classId).get();
		List<User> students = userRepository.findByStudentClass(schoolClass);
		Course course = courseRepository.findById(courseId).get();
		List<Assesment> assessments = new LinkedList<>();
		course.getAssignments().forEach(asgmnt -> assessments.addAll(asgmnt.getAssesments()));
		
		List<Result> results  = resultRepository.findResultByStudentInAndAssesmentIn(students, assessments);
		
		float maximumPoints = resultUtil.getTotalMaximumPoints(results);
		float gainedPoints = resultUtil.getTotalGainedPoints(results);
		
		ClassCourseScoreDto classScoreDto = new ClassCourseScoreDto();
		classScoreDto.setSchoolClass(schoolClass);
		classScoreDto.setMaximumPoints(maximumPoints);
		classScoreDto.setPointsEarned(gainedPoints);
		classScoreDto.setCourse(courseMapperImpl.entityToBaseDTO(course));
		
		return classScoreDto;
	}

	
}

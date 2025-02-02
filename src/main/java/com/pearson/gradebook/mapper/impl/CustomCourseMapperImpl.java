package com.pearson.gradebook.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pearson.gradebook.dto.AssignmentDto;
import com.pearson.gradebook.dto.CourseBaseDto;
import com.pearson.gradebook.dto.CourseDto;
import com.pearson.gradebook.dto.CourseRosterDto;
import com.pearson.gradebook.dto.UserDto;
import com.pearson.gradebook.dto.UserBaseDto;
import com.pearson.gradebook.entity.Assignment;
import com.pearson.gradebook.entity.Course;
import com.pearson.gradebook.entity.User;

@Component
public class CustomCourseMapperImpl {

	private CustomAssignmentMapperImpl customAssignmentMapperImpl;
	
	
	public CustomCourseMapperImpl(CustomAssignmentMapperImpl customAssignmentMapperImpl) {
		this.customAssignmentMapperImpl = customAssignmentMapperImpl;
	}
	
	public CourseBaseDto entityToBaseDTO(Course course) {
		if (course == null) {
			return null;
		}

		CourseBaseDto courseDto = new CourseBaseDto();
		courseDto.setId(course.getId());
		courseDto.setName(course.getName());
		return courseDto;
	}

	public CourseDto entityToDTO(Course course) {
		if (course == null) {
			return null;
		}

		CourseDto courseDto = new CourseDto();

		courseDto.setId(course.getId());
		courseDto.setName(course.getName());
		if (course.getAssignments() != null) {
			List<AssignmentDto> assignmentDtos = course.getAssignments().stream()
					.map(entity -> customAssignmentMapperImpl.entityToDto(entity)).toList();
			courseDto.setAssignments(assignmentDtos);
		}
		return courseDto;
	}
	
	public CourseRosterDto entityToRosterDTO(Course course) {
		if (course == null) {
			return null;
		}

		CourseRosterDto courseRosterDto = new CourseRosterDto();

		courseRosterDto.setName(course.getName());
		courseRosterDto.setId(course.getId());
		if (course.getRoster() != null) {
			List<UserBaseDto> userBaseDtos = new ArrayList<>();
			for(User user: course.getRoster()) {
				UserBaseDto dto = new UserBaseDto();
				dto.setType(user.getType());
				dto.setId(user.getId());
				userBaseDtos.add(dto);
			}
			courseRosterDto.setRoster(userBaseDtos);
		}
		
		return courseRosterDto;
	}

	public Course dtoToEntity(CourseDto dto) {
		if (dto == null) {
			return null;
		}

		Course entity = new Course();
		
		entity.setName(dto.getName());
		entity.setId(dto.getId());
		if(dto.getAssignments() != null) {
			
			List<Assignment> assignments = dto.getAssignments()
					.stream()
					.map(assdto -> customAssignmentMapperImpl.dtoToEntity(assdto))
					.toList();
			entity.setAssignments(assignments);
		}

		return entity;
	}
}

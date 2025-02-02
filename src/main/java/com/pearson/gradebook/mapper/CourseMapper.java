package com.pearson.gradebook.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.pearson.gradebook.dto.CourseDto;
import com.pearson.gradebook.entity.Course;

@Mapper(componentModel = "spring")
public interface CourseMapper {
	
	public CourseDto courseEntityToDTO(Course course) ;
	
	public Course courseDtoToEntity(CourseDto courseDto);
	
}

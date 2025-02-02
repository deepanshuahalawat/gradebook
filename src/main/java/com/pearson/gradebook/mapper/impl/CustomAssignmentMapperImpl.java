package com.pearson.gradebook.mapper.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pearson.gradebook.dto.AssesmentDto;
import com.pearson.gradebook.dto.AssignmentDto;
import com.pearson.gradebook.entity.Assesment;
import com.pearson.gradebook.entity.Assignment;

@Component
public class CustomAssignmentMapperImpl {

	private CustomAssesmentMapperImpl customAssesmentMapperImpl;
	
	public CustomAssignmentMapperImpl(CustomAssesmentMapperImpl customAssesmentMapperImpl) {
		this.customAssesmentMapperImpl = customAssesmentMapperImpl;
	}
	
	public Assignment dtoToEntity(AssignmentDto assignmentDto) {
		if(assignmentDto == null) {
			return null;
		}
		Assignment assignment = new Assignment();
		
		assignment.setName(assignmentDto.getName());
		assignment.setId(assignmentDto.getId());
		if(assignmentDto.getAssessments() != null) {
		List<Assesment> assesments = assignmentDto.getAssessments()
				.stream()
				.map(dto -> customAssesmentMapperImpl.dtoToEntity(dto) )
				.toList();
		
		assignment.setAssesments(assesments);
		}
		
		return assignment;
	} 
	
	
	public AssignmentDto entityToDto(Assignment entity) {
		if(entity == null) {
			return null;
		}
		AssignmentDto dto = new AssignmentDto();
		
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		
		if(entity.getAssesments() != null) {
			List<AssesmentDto> assesmentDtos = entity.getAssesments()
					.stream()
					.map(ent -> customAssesmentMapperImpl.entityToDto(ent))
					.toList();
			dto.setAssesments(assesmentDtos);
		}
		
		return dto;
	}
}

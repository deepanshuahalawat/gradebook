package com.pearson.gradebook.mapper.impl;

import org.springframework.stereotype.Component;

import com.pearson.gradebook.dto.AssesmentDto;
import com.pearson.gradebook.entity.Assesment;


@Component
public class CustomAssesmentMapperImpl {

	public Assesment dtoToEntity(AssesmentDto assesmentDto) {
		if(assesmentDto == null) {
			return null;
		}
		Assesment assesment = new Assesment();
		
		assesment.setId(assesmentDto.getId());
		assesment.setName(assesmentDto.getName());
		assesment.setPossiblePoints(assesmentDto.getPointsPossible());
		assesment.setType(assesmentDto.getType());
		
		return assesment;
	} 
	
	
	public AssesmentDto entityToDto(Assesment entity) {
		if(entity == null) {
			return null;
		}
		AssesmentDto dto = new AssesmentDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setType(entity.getType());
		dto.setPointsPossible(entity.getPossiblePoints());
		
		return dto;
	}
}

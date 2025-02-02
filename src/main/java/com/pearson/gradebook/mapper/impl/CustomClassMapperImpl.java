package com.pearson.gradebook.mapper.impl;

import org.springframework.stereotype.Component;

import com.pearson.gradebook.dto.ClassDto;
import com.pearson.gradebook.entity.SchoolClass;

@Component
public class CustomClassMapperImpl {

	public ClassDto entityToDto(SchoolClass entity) {
		if(entity == null) {
			return null;
		}
		ClassDto dto  = new ClassDto();
		dto.setName(entity.getName());
		dto.setId(entity.getId());
		return dto;
	}
	
	
	public SchoolClass dtoToEntity(ClassDto dto) {
		if(dto == null) {
			return null;
		}
		SchoolClass entity = new SchoolClass();
		entity.setName(dto.getName());
		entity.setId(dto.getId());
		return entity;
	}
	
}

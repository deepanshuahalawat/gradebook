package com.pearson.gradebook.mapper;

import org.mapstruct.Mapper;

import com.pearson.gradebook.dto.UserDto;
import com.pearson.gradebook.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	public UserDto userEntityToDTO(User course) ;
	
	public User userDtoToEntity(UserDto courseDto);

}

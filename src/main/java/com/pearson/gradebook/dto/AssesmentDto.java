package com.pearson.gradebook.dto;

public class AssesmentDto {
	Long id;
	
	String name;
	
	String type;
	
	Float pointsPossible;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	public Float getPointsPossible() {
		return pointsPossible;
	}

	public void setPointsPossible(Float pointsPossible) {
		this.pointsPossible = pointsPossible;
	}

	@Override
	public String toString() {
		return "AssesmentDto [id=" + id + ", name=" + name + ", type=" + type + ", possiblePoints=" + pointsPossible
				+ "]";
	}
	
	
	
}

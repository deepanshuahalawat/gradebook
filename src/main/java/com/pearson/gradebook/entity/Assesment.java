package com.pearson.gradebook.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "assesment")
public class Assesment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	Long id;
	
	String name;
	
	String type;
	
	Float possiblePoints;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "assignment_id", referencedColumnName = "id")
	Assignment assignment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getPossiblePoints() {
		return possiblePoints;
	}

	public void setPossiblePoints(Float possiblePoints) {
		this.possiblePoints = possiblePoints;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Assesment [id=" + id + ", name=" + name + ", type=" + type + ", possiblePoints=" + possiblePoints
				+ "]";
	}
	
	
	
}

package com.pearson.gradebook.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
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

	
}

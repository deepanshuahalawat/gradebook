package com.pearson.gradebook.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Result {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long id;
	
	@ManyToOne
	User student;
	
	@ManyToOne
	Assesment assesment;
	
	Float score;
	
	Date date;

	
	
	
}

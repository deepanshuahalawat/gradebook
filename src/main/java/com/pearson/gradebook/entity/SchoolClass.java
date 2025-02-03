package com.pearson.gradebook.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "class")
public class SchoolClass {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long id;
	String name;
}

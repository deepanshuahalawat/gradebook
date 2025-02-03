package com.pearson.gradebook.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long id;
	
	@Column(name= "course_name")
	String name;
	

	@ManyToMany(fetch = FetchType.LAZY)
	List<User> roster;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "course",fetch = FetchType.LAZY)
	List<Assignment> assignments;
	

	
	
}

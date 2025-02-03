package com.pearson.gradebook.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "assignment")
public class Assignment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long id;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "course_id", referencedColumnName = "id")
	Course course;
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "assignment")
	List<Assesment> assesments;

	String name;
	
}

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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Assesment> getAssesments() {
		return assesments;
	}

	public void setAssesments(List<Assesment> assesments) {
		this.assesments = assesments;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Assignment [id=" + id + ", assesments=" + assesments + ", name=" + name + "]";
	}
	
	
	
}

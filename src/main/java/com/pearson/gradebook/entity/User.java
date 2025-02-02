package com.pearson.gradebook.entity;

import java.util.List;

import org.hibernate.annotations.Fetch;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long id;
	
	String type;
	
	@ManyToMany(mappedBy = "roster",fetch = FetchType.LAZY)
	List<Course> courses;
	
	@ManyToOne
	@JoinColumn(name = "student_class",referencedColumnName = "id")
	SchoolClass studentClass;

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

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public SchoolClass getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(SchoolClass studentClass) {
		this.studentClass = studentClass;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", type=" + type + ", studentClass=" + studentClass + "]";
	}
	
	
	
	

}

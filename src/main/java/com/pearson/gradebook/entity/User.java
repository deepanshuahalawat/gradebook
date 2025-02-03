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
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "user")
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long id;
	
	String type;
	
	@ManyToMany(mappedBy = "roster",fetch = FetchType.LAZY)
	List<Course> courses;
	
	@ManyToOne
	@JoinColumn(name = "student_class",referencedColumnName = "id")
	SchoolClass studentClass;

}

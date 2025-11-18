package br.com.arthdroid1.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_curso")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false,  name="name")
	private String name;
	@Column(nullable = false,  name="professor")
	private String professor;
	@Column(nullable = false,  name="category")
	private String category;
	@Column(nullable = false,  name="active_or_no")
	private boolean active;
	@Column(nullable = false,  name="created_at")
	@CreationTimestamp
	private LocalDateTime createdAt;
	@UpdateTimestamp
	@Column(nullable = false,  name="updated_at")
	private LocalDateTime updatedAt;
	
	
	public Course(String name) {
		this.name = name;
		this.active = true;
	}

	public Course() {
		
	}
	
	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	


	
	

}

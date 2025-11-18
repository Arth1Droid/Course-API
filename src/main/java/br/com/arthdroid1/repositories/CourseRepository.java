package br.com.arthdroid1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.arthdroid1.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
	
	List<Course> findByNameOrCategory();
}

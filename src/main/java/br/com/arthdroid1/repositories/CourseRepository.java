package br.com.arthdroid1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.arthdroid1.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
	
	boolean existsByName(String name);
	
	List<Course> findByNameContainingIgnoreCase(String name);

    List<Course> findByCategoryContainingIgnoreCase(String category);

    List<Course> findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(String name, String category);
}

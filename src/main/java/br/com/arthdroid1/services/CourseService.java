package br.com.arthdroid1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arthdroid1.models.Course;
import br.com.arthdroid1.repositories.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository repository;
	
	public Course createCourse(Course newCourse) {

        if (newCourse.getName() == null || newCourse.getName().isBlank()) {
            throw new IllegalArgumentException("Course name is required");
        }

        boolean exists = !repository
        	    .findByNameOrCategory(newCourse.getName(), newCourse.getCategory())
        	    .isEmpty();
        
        if (exists) {
            throw new IllegalArgumentException("A course with this name already exists");
        }

        return repository.save(newCourse);
	    
	}
	
	public List<Course> listAllCourses(){
		return repository.findAll();
	}
	
	public Course updateCourse(Long id, Course updatedCourse) {
		Course existCourse = repository.findById(id).
		orElseThrow(()-> new IllegalArgumentException("Course not encoutered :("));
		
		if(updatedCourse.getName() != null) {	
			existCourse.setName(updatedCourse.getName());
		}
		if(updatedCourse.getCategory() != null) {
			existCourse.setCategory(updatedCourse.getCategory());
		}
		if(updatedCourse.getProfessor() != null) {
			existCourse.setProfessor(updatedCourse.getProfessor());	
		}
		return repository.save(existCourse);
	}
	
	public boolean deleteCourse(Long id) {
		Course existingCourse = repository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("Course not encoutered :("));
		repository.delete(existingCourse);
		return true;

	}
	
	

}

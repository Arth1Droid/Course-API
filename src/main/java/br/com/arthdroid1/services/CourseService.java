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

        boolean exists = repository.existsByName(newCourse.getName());
        
        if (exists) {
            throw new IllegalArgumentException("A course with this name already exists");
        }

        return repository.save(newCourse);
	    
	}
	
	public List<Course> listAllCourses(String name, String category){
       
		if (name != null && category != null) {
            return repository.findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(name, category);
        }
        if (name != null) {
            return repository.findByNameContainingIgnoreCase(name);
        }
        if (category != null) {
            return repository.findByCategoryContainingIgnoreCase(category);
        }
        
        return repository.findAll();
	}
	
	public Course updateCourse(Long id, Course updatedCourse) {
		Course existCourse = repository.findById(id).
		orElseThrow(()-> new IllegalArgumentException("Course not encoutered :("));
		
        updatedCourse.setActive(existCourse.isActive());
		
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
	
    public Course updateActiveStatus(Long id, boolean active) {
        Course course = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));
        course.setActive(active);
        return repository.save(course);
    }
	
	
	

}

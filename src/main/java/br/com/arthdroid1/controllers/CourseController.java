package br.com.arthdroid1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.arthdroid1.models.Course;
import br.com.arthdroid1.services.CourseService;

@RequestMapping("/cursos")
@RestController
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	@PostMapping
	public ResponseEntity<Course> createCourse(@RequestBody Course course){
		Course createdCourse = service.createCourse(course);
		return ResponseEntity.ok(createdCourse);
	}
	@GetMapping
	public ResponseEntity<List<Course>> listAllCourses(@RequestParam(required = false) String name, @RequestParam(required = false) String category){
        return ResponseEntity.ok(service.listAllCourses(name, category));	
      }
	
	@PutMapping("/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course){
		
		Course updatedCourse =service.updateCourse(id, course);
		return ResponseEntity.ok(updatedCourse);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCourse(@PathVariable Long id){
		service.deleteCourse(id);
		return ResponseEntity.noContent().build();
	}
	@PatchMapping("/{id}/active")
	public ResponseEntity<Course> setActiveStatus(@PathVariable Long id, @RequestParam boolean active){
		 Course updated = service.updateActiveStatus(id, active);
	        return ResponseEntity.ok(updated);
		
	}
	
	

}

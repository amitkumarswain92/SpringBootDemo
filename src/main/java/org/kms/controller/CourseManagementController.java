package org.kms.controller;

import java.util.List;

import org.kms.model.Course;
import org.kms.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseManagementController {
	@Autowired
	CourseService courseService;
	
	@RequestMapping(value="/CourseManagementSanityTest")
	public String sayHello(){
		return "CourseManagement Module is working fine";
	}
	
	@RequestMapping("/courseList")
	public List<Course> getCourseList(){
		
	return courseService.getCourseList();
	
	}
	@RequestMapping(method=RequestMethod.POST, value="/courseList")
	public void addNewCourse(@RequestBody Course course){
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/courseList/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable int id){
		courseService.updateCourse(course,id);
	}
	
}

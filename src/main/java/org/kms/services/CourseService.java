package org.kms.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.kms.model.Course;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	private List <Course> courseList= new ArrayList<Course>(Arrays.asList(
			new Course(1, "MCA", new Date(), new Date()),
			new Course(2, "MBA", new Date(), new Date())
			));

	
	public List <Course> getCourseList(){
		
		return courseList;
	}
	
	public void addCourse(Course course){
		courseList.add(course);
	}
	
	public void updateCourse(Course course, int id){
		for (Course courseElement : courseList) {
			if(courseElement.getId()==id){
				courseList.set(id, course);
				return;
			}
		} 
	}
}

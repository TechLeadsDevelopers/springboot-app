package com.springboot.app.service;

import java.util.List;

import com.springboot.app.model.Course;

public interface CourseService {
	
	public Course getCourseDetails(String course) throws Exception;
	public List<Course> getAllCourses() throws Exception;
}

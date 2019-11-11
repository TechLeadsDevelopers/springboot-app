package com.springboot.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.model.Course;
import com.springboot.app.service.CourseService;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;

	@RequestMapping(value ="/courses",method=RequestMethod.GET)
	public List<Course> getCourse() {
		try {
			List<Course> courses = courseService.getAllCourses();
			return courses;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Course>();
	}
	
	@RequestMapping(value ="/course/{courseName}",method=RequestMethod.GET)
	public Course getCourseDetails(@PathVariable("courseName") String courseName) {
		try {
			Course course = courseService.getCourseDetails(courseName);
			return course;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Course();
	}
}

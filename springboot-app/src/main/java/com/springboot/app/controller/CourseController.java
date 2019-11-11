package com.springboot.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value ="/courses/{courseName}",method=RequestMethod.GET)
	public Course getCourseDetails(@PathVariable("courseName") String courseName) {
		try {
			Course course = courseService.getCourseDetails(courseName);
			return course;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Course();
	}
	
	@RequestMapping(value ="/courses",method=RequestMethod.POST)
	public List<Course> addCourse(@RequestBody Course course) {
		try {
			List<Course> courses = courseService.addCourse(course);
			return courses;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Course>();
	}
}

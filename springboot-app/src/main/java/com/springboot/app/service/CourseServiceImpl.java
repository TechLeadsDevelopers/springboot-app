package com.springboot.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.app.model.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Override
	public Course getCourseDetails(String courseName) throws Exception {
		try {
			Course course=new Course();
			if(courseName.equalsIgnoreCase("Spring boot")) {
				course.setName("SpringBoot");
				course.setDescription("Duration 3 weeks online training");
				
			}else if(courseName.equalsIgnoreCase("Microservices")) {
				course.setName("Microservices");
				course.setDescription("Microservices course is 4 weeks class room training");
			}
			
			return course;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Course> getAllCourses() throws Exception {
		
		try {
			return Arrays.asList(new Course(101,"Spring Boot","Duration 3 weeks online training")
					,new Course(102,"Microservices","Microservices course is 4 weeks class room training")
					);
		} catch (Exception e) {
			throw e;
		}
	
		
	}

}

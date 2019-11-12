package com.springboot.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.springboot.app.model.Course;

@Service
public class CourseServiceImpl implements CourseService {
	private List<Course> courses= new ArrayList<Course>(Arrays.asList(new Course(101,"Spring Boot","Duration 3 weeks online training")
			,new Course(102,"Microservices","Microservices course is 4 weeks class room training")
			));

	@Override
	public Course getCourseDetails(String courseName) throws Exception {
		try {
			
			return courses.stream().filter(c->c.getName().equals(courseName)).findFirst().get();
		} catch (Exception e) {
			throw e;
		}
	}
	@Override
	public Course getCourseDetails(long id) throws Exception {
		try {
			
			return courses.stream().filter(c->c.getId()==id).findFirst().get();
		} catch (Exception e) {
			throw e;
		}
	}


	@Override
	public List<Course> getAllCourses() throws Exception {
		
		try {
			return courses;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Course> addCourse(Course course) throws Exception {
		try {
			courses.add(course);
			return courses;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Course updateById(Course course,long id) throws Exception {
		try {
			course.setId(id);
			Course crse=getCourseDetails(id);
			BeanUtils.copyProperties(course, crse);
			return crse;
		} catch (Exception e) {
			throw e;
		}
	}
	@Override
	public List<Course> deleteCourseById(long id) throws Exception {
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getId() == id) {
				courses.remove(i);
			}
		}
		return courses;
	}

}

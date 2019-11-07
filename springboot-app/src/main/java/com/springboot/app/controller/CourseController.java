package com.springboot.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@RequestMapping("/course")
	public String getCourse() {
		return " Available Courses Spring Boot & Microservices";
	}
}

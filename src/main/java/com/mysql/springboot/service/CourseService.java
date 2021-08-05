package com.mysql.springboot.service;

import java.util.List;

import com.mysql.springboot.model.Course;

/**
 * Abstract Service to communicate with persistence layer.
 * 
 * @author metanoia
 * @version 1.0
 * 
 * */
public interface CourseService {

	public List<Course> findAllCourse();

	public Course findById(int id);

	public Course findByCourseId(String courseId);

	public void addCourse(Course course);

	public void updateCoursDetails(Course course, int id);

	public void deleteCourseDetails(int id);

}

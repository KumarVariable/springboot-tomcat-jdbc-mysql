package com.mysql.springboot.dao;

/**
 * Abstract APIs to support Data Persistence.
 * 
 * @author metanoia
 * @verion 1.0
 **/

import java.util.List;

import com.mysql.springboot.model.Course;

public interface CourseDAO {

	public List<Course> findAllCourse();

	public Course findById(int id);

	public Course findByCourseId(String courseId);

	public void addCourse(Course course);

	public void updateCoursDetails(Course course, int id);

	public void deleteCourseDetails(int id);

}

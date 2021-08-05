package com.mysql.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.springboot.dao.CourseDAO;
import com.mysql.springboot.model.Course;
import com.mysql.springboot.service.CourseService;

/**
 * A {@link CourseService} implementation class to establish a set of available
 * operations which coordinates with persistence layer in each operations.
 * 
 * @author metanoia
 * 
 * @version 1.0
 * 
 */
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDAO courseDao;

	@Override
	public List<Course> findAllCourse() {
		return courseDao.findAllCourse();
	}

	@Override
	public Course findById(int id) {
		return courseDao.findById(id);
	}

	@Override
	public Course findByCourseId(String courseId) {
		return courseDao.findByCourseId(courseId);
	}

	@Override
	public void addCourse(Course course) {
		courseDao.addCourse(course);

	}

	@Override
	public void updateCoursDetails(Course course, int id) {
		courseDao.updateCoursDetails(course, id);

	}

	@Override
	public void deleteCourseDetails(int id) {
		courseDao.deleteCourseDetails(id);

	}

}

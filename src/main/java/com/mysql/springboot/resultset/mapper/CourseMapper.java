/**
 * 
 */
package com.mysql.springboot.resultset.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

import com.mysql.springboot.model.Course;

/**
 * Maps each Course returned by result set.
 * 
 * @author metanoia
 *
 */
public class CourseMapper implements RowMapper<Course> {

	@Override
	public Course mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

		Course course = new Course();

		course.setId(resultSet.getInt("id"));
		course.setCourseId(resultSet.getString("course_id"));
		course.setCourseName(resultSet.getString("course_name"));
		course.setCourseTranerName(resultSet.getString("course_trainer_name"));
		course.setCourseDuration(resultSet.getInt("course_duration"));
		course.setTotalSeats(resultSet.getInt("course_total_seats"));
		course.setCourseFees(resultSet.getDouble("course_fees"));
		course.setCourseDescription(resultSet.getString("course_description"));

		String courseStartDate = dateFormatter
				.format(resultSet.getDate("course_start_date"));

		String courseEndDate = dateFormatter
				.format(resultSet.getDate("course_end_date"));

		course.setCourseStartDate(courseStartDate);
		course.setCourseEndDate(courseEndDate);

		return course;
	}

}

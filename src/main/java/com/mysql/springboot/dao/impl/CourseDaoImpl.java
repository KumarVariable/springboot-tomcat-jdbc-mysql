package com.mysql.springboot.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.mysql.springboot.dao.CourseDAO;
import com.mysql.springboot.model.Course;
import com.mysql.springboot.resultset.mapper.CourseMapper;

/**
 * Implementation {@link CourseDAO} to Database Persistence APIs
 * 
 * @author metanoia
 * @version 1.0
 */

@Repository
public class CourseDaoImpl implements CourseDAO {

	private static final Logger LOG = LoggerFactory
			.getLogger(CourseDaoImpl.class);

	private static final String FIND_ALL_COURSE = "SELECT id, course_id, course_name, course_trainer_name, "
			+ " course_duration, course_total_seats, course_fees, course_description, course_start_date, "
			+ " course_end_date FROM course ";

	private static final String FIND_BY_ID = "SELECT id, course_id, course_name, course_trainer_name, "
			+ " course_duration, course_total_seats, course_fees, course_description, course_start_date, "
			+ " course_end_date FROM course WHERE id = :id ";

	private static final String FIND_BY_COURSE_ID = "SELECT id, course_id, course_name, course_trainer_name, "
			+ " course_duration, course_total_seats, course_fees, course_description, course_start_date, "
			+ " course_end_date FROM course WHERE course_id = :course_id ";

	private static final String INSERT_INTO_COURSE = " INSERT INTO course(course_id, course_name, course_trainer_name, "
			+ " course_duration, course_total_seats, course_fees, course_description, "
			+ " course_start_date, course_end_date) "
			+ " VALUES (:courseId, :courseName, :courseTranerName, :courseDuration, :totalSeats, :courseFees, :courseDescription, "
			+ " :courseStartDate, :courseEndDate ) ";

	private static final String UPDATE_BY_ID = " UPDATE course SET course_id = :courseId, course_name = :courseName, "
			+ " course_trainer_name = :courseTranerName, course_duration = :courseDuration, course_total_seats = :totalSeats, "
			+ " course_fees = :courseFees, course_description = :courseDescription, course_start_date = :courseStartDate, "
			+ " course_end_date = :courseEndDate WHERE id = :id ";

	private static final String DELETE_BY_ID = " DELETE FROM course WHERE id = :id";

	@Autowired
	NamedParameterJdbcTemplate namedJdbcTemplate;

	/**
	 * Find all course available in database.
	 * 
	 * @return List<Course>
	 */
	@Override
	public List<Course> findAllCourse() {
		List<Course> courseList = namedJdbcTemplate.query(FIND_ALL_COURSE,
				new CourseMapper());

		if (courseList == null || courseList.size() == 0) {
			LOG.info("No records found in the database ");
			courseList = new ArrayList<Course>();
		}

		return courseList;
	}

	/**
	 * Find course available in database by id.
	 * 
	 * @param id
	 *            - auto-generated id of course.
	 * 
	 * @return Course
	 */
	@Override
	public Course findById(int id) {

		SqlParameterSource namedParameters = new MapSqlParameterSource("id",
				id);

		Course course = namedJdbcTemplate.queryForObject(FIND_BY_ID,
				namedParameters, new CourseMapper());

		if (ObjectUtils.isEmpty(course)) {
			LOG.info("No records found for id " + id);
			course = new Course();
		}

		return course;
	}

	/**
	 * Find course available in database by course id.
	 * 
	 * @param course
	 *            id
	 * 
	 * @return Course
	 */
	@Override
	public Course findByCourseId(String courseId) {
		SqlParameterSource namedParameters = new MapSqlParameterSource(
				"course_id", courseId);

		Course course = namedJdbcTemplate.queryForObject(FIND_BY_COURSE_ID,
				namedParameters, new CourseMapper());

		if (ObjectUtils.isEmpty(course)) {
			LOG.info("No records found for Course id " + courseId);
			course = new Course();
		}

		return course;
	}

	/**
	 * Insert one new course into database.
	 * 
	 * @param Course
	 * 
	 */
	@Override
	public void addCourse(Course course) {
		Map<String, String> parameters = new HashMap<>();

		parameters.put("courseId", course.getCourseId());
		parameters.put("courseName", course.getCourseName());
		parameters.put("courseTranerName", course.getCourseTranerName());
		parameters.put("courseDuration",
				String.valueOf(course.getCourseDuration()));
		parameters.put("totalSeats", String.valueOf(course.getTotalSeats()));
		parameters.put("courseFees", String.valueOf(course.getCourseFees()));
		parameters.put("courseDescription", course.getCourseDescription());
		parameters.put("courseStartDate", course.getCourseStartDate());
		parameters.put("courseEndDate", course.getCourseEndDate());

		int rowInserted = namedJdbcTemplate.update(INSERT_INTO_COURSE,
				parameters);

		LOG.info(rowInserted + " record inserted into database. ");

	}

	/**
	 * Update details of course by id.
	 * 
	 * @param Course,
	 *            id
	 * 
	 */
	@Override
	public void updateCoursDetails(Course course, int id) {
		Map<String, String> parameters = new HashMap<>();

		parameters.put("courseId", course.getCourseId());
		parameters.put("courseName", course.getCourseName());
		parameters.put("courseTranerName", course.getCourseTranerName());
		parameters.put("courseDuration",
				String.valueOf(course.getCourseDuration()));
		parameters.put("totalSeats", String.valueOf(course.getTotalSeats()));
		parameters.put("courseFees", String.valueOf(course.getCourseFees()));
		parameters.put("courseDescription", course.getCourseDescription());
		parameters.put("courseStartDate", course.getCourseStartDate());
		parameters.put("courseEndDate", course.getCourseEndDate());
		parameters.put("id", String.valueOf(id));

		int rowUpdated = namedJdbcTemplate.update(UPDATE_BY_ID, parameters);

		LOG.info(rowUpdated + " record updated successfully");

	}

	/**
	 * Delete selected course from database.
	 * 
	 * @param id
	 * 
	 */
	@Override
	public void deleteCourseDetails(int id) {
		SqlParameterSource parameterSource = new MapSqlParameterSource("id",
				id);

		int rowDeleted = namedJdbcTemplate.update(DELETE_BY_ID,
				parameterSource);

		LOG.info(rowDeleted + " record deleted successfully ");

	}

}

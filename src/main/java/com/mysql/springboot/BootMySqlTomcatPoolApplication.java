package com.mysql.springboot;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mysql.springboot.model.Course;
import com.mysql.springboot.service.CourseService;

/**
 * Boot Class to kick-start application,resolve dependencies by Spring.
 * 
 * @author metanoia
 * @version 1.0
 */
@SpringBootApplication(scanBasePackages = {"com.mysql.springboot"})
public class BootMySqlTomcatPoolApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory
			.getLogger(BootMySqlTomcatPoolApplication.class);

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	CourseService courseService;

	public static void main(String[] args) {
		SpringApplication.run(BootMySqlTomcatPoolApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info(" <<< Application Started >>> - Remember to create MySQL database, table to run this application");

		String[] dataSourceBeans = applicationContext
				.getBeanNamesForType(DataSource.class);

		for (String stringName : dataSourceBeans) {
			LOG.info("DataSource Beans " + stringName);
		}

		Map<String, DataSource> dataSourceTypeBean = applicationContext
				.getBeansOfType(DataSource.class);

		DataSource dataSource = dataSourceTypeBean.get("dataSource");

		LOG.info(" DataSource -->> " + dataSource.toString());

		// Uncomment below code for Create/Insert Operation
		/* courseService.addCourse(dummyInsertCourse()); */

		int dummyId = 1;
		String courseId = "SPR_121";
		// Uncomment below code for Update Operation
		/* courseService.updateCoursDetails(dummyUpdatetCourse(), dummyId); */
		
		// Find All Course(s) - Read Operation
		List<Course> courseList = courseService.findAllCourse();
		
		for(Course course : courseList) {
			LOG.info("Course --> " + course.toString());
		}
		
		// Find Course By Id - Read Operation
		Course singleCourse = courseService.findById(dummyId);
		LOG.info(" Course By Id --> " + singleCourse.toString());
		
		// Find Course By CourseId - Read Operation
		Course courseByCourseId = courseService.findByCourseId(courseId);
		LOG.info(" Course By CourseId --> " + courseByCourseId.toString());
		
		// Uncomment below code to Delete Course By Id - Delete Operation
		/* courseService.deleteCourseDetails(dummyId); */
		

	}

	/**
	 * Helper method to return dummy 'Course' to Insert.
	 * 
	 * The method takes Calendar class to get current date and next desired months
	 * to pass as start date and end date respectively.
	 * 
	 * @return Course
	 */
	private Course dummyInsertCourse() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Course course = new Course();

		Date startDate = calendar.getTime();
		String strStartDate = dateFormat.format(startDate);

		calendar.add(Calendar.MONTH, 2);

		Date endDate = calendar.getTime();
		String strEndDate = dateFormat.format(endDate);

		course.setCourseId("MVN_421");
		course.setCourseName("Maven Essentials");
		course.setCourseTranerName("Mr Maven");
		course.setCourseDuration(2);
		course.setTotalSeats(80);
		course.setCourseFees(2000);
		course.setCourseDescription("Mastering Maven v3 ");
		course.setCourseStartDate(strStartDate);
		course.setCourseEndDate(strEndDate);

		return course;
	}
	

	/**
	 * Helper method to return dummy 'Course' to Update.
	 * 
	 * The method takes Calendar class to get current date and next desired months
	 * to pass as start date and end date respectively.
	 * 
	 * @return Course
	 */
	private Course dummyUpdatetCourse() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Course course = new Course();

		Date startDate = calendar.getTime();
		String strStartDate = dateFormat.format(startDate);

		calendar.add(Calendar.MONTH, 7);

		Date endDate = calendar.getTime();
		String strEndDate = dateFormat.format(endDate);

		course.setCourseId("MYSQL_321");
		course.setCourseName("MySql Developer Course");
		course.setCourseTranerName("Mr MySQL");
		course.setCourseDuration(7);
		course.setTotalSeats(80);
		course.setCourseFees(12000);
		course.setCourseDescription("Mastering MySQL Dataabse ");
		course.setCourseStartDate(strStartDate);
		course.setCourseEndDate(strEndDate);

		return course;
	}

}

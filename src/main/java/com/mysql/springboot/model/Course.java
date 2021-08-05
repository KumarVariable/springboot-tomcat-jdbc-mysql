package com.mysql.springboot.model;

/**
 * Class represents a Course
 * 
 * @author metanoia
 * @version 1.0
 * 
 * */
public class Course {

	private int id;
	private int courseDuration;
	private int totalSeats;

	private double courseFees;
	private String courseId;
	private String courseName;
	private String courseTranerName;
	private String courseDescription;
	private String courseStartDate;
	private String courseEndDate;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}

	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public double getCourseFees() {
		return courseFees;
	}
	public void setCourseFees(double courseFees) {
		this.courseFees = courseFees;
	}

	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseTranerName() {
		return courseTranerName;
	}
	public void setCourseTranerName(String courseTranerName) {
		this.courseTranerName = courseTranerName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getCourseStartDate() {
		return courseStartDate;
	}
	public void setCourseStartDate(String courseStartDate) {
		this.courseStartDate = courseStartDate;
	}

	public String getCourseEndDate() {
		return courseEndDate;
	}
	public void setCourseEndDate(String courseEndDate) {
		this.courseEndDate = courseEndDate;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseDuration=" + courseDuration
				+ ", totalSeats=" + totalSeats + ", courseFees=" + courseFees
				+ ", courseId=" + courseId + ", courseName=" + courseName
				+ ", courseTranerName=" + courseTranerName
				+ ", courseDescription=" + courseDescription
				+ ", courseStartDate=" + courseStartDate + ", courseEndDate="
				+ courseEndDate + "]";
	}

}

package com.mycompany.app.mysql;

import java.sql.Time;

public class ResultRow {
	String lastName;
	String firstName;
	int dayOfWeek;
	Time startTime;
	Time finishTime;
	String courseName;
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Time finishTime) {
		this.finishTime = finishTime;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public String toString() {
		return ("Teacher: " + lastName + " " + firstName + "   Day of week: " + dayOfWeek + "   From " + startTime + " to " + finishTime + "   Course: " + courseName);
	}
}

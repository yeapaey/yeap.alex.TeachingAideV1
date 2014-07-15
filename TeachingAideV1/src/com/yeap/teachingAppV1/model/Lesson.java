package com.yeap.teachingAppV1.model;

import java.util.Date;
import java.util.UUID;

public class Lesson {
	
	private UUID id; // May not be necessary if dates are unique. DATES ARE NOT UNIQUE!!!
	private Date date; // Use this to set the actual date and time when the generator works
	private String plan;
	private String notes;
	private boolean absent;
//	private int lessonNo;
	
	
	public Lesson()
	{
		id = UUID.randomUUID();
		date = new Date();
		plan = new String();
		notes = new String();
		absent = false;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getPlan() {
		return plan;
	}


	public void setPlan(String plan) {
		this.plan = plan;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public boolean isAbsent() {
		return absent;
	}


	public void setAbsent(boolean absent) {
		this.absent = absent;
	}


	public UUID getId() {
		return id;
	}
	
	public void printDetails()
	{
		String output = new String(	"Date: " + date + "\n" +
									" Absent?: " + (absent ? "Yes\n" : "No\n") +
									" Plan: " + plan + "\n");
		
		System.out.println(output);
	}
	
	
	
}
	
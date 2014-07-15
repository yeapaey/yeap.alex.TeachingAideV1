package com.yeap.teachingAppV1.model;

import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import com.yeap.teachingAppV1.model.uniqueID.AbstractUniqueID;

public class Student implements Teachable {
	
	private StudentID id;
	private String surname;
	private String firstName;
	private String className;
	private String mobilePhone;
	private String homePhone;
	private String motherName;
	private String fatherName;
	private String motherPhone;
	private String fatherPhone;
	private String email;
	private StudentGroup group;
	private TreeSet<Lesson> lessons;

	
	public Student(String surname, String firstName, String className)
	{
		id = new StudentID();
		this.surname = surname;
		this.firstName = firstName;
		this.className = className;
		mobilePhone = new String();
		homePhone = new String();
		motherName = new String();
		fatherName = new String();
		motherPhone = new String();
		fatherPhone = new String();
		email = new String();
		lessons = new TreeSet<Lesson>();
		group = null;
	}

	
	@Override
	public void addLesson(Lesson newLesson) {
		lessons.add(newLesson);
		
	}

	@Override
	public boolean removeLesson() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	
	@Override
	public boolean equals(AbstractUniqueID otherID) {
		
		return id.equals(otherID);
	}



	
	
	@Override
	public SortedSet<Lesson> getLessons() {
		// TODO Auto-generated method stub
		return lessons;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherPhone() {
		return motherPhone;
	}

	public void setMotherPhone(String motherPhone) {
		this.motherPhone = motherPhone;
	}

	public String getFatherPhone() {
		return fatherPhone;
	}

	public void setFatherPhone(String fatherPhone) {
		this.fatherPhone = fatherPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public StudentID getId() {
		return id;
	}


	public StudentGroup getGroup() {
		return group;
	}


	public void setGroup(StudentGroup group) {
		this.group = group;
	}


	@Override
	public int compareTo(Teachable o) {
		
		return getComparator().compareToIgnoreCase(o.getComparator());
	}

	public String getComparator()
	{
		return surname + " " + firstName;
	}
	
	
	
}

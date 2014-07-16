package com.yeap.teachingAppV1.model;

import java.util.LinkedList;

import com.yeap.teachingAppV1.model.uniqueID.UniqueID;

public class Student implements Teachable {
	
	private static final String idPrefix = new String("STU");
	private UniqueID id;
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
	private AbstractLearningClass learningClass;
	private LinkedList<Lesson> lessons;

	
	public Student(String surname, String firstName, String className)
	{
		id = new UniqueID(idPrefix);
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
		lessons = new LinkedList<Lesson>();
		learningClass = null;
	}

	
	@Override
	public void addLesson(Lesson newLesson) {
		lessons.add(newLesson);
		
	}

	@Override
	public boolean removeLesson(UniqueID lessonID)
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	

	
	@Override
	public boolean equals(UniqueID otherID) {
		
		return id.equals(otherID);
	}


	
	@Override
	public LinkedList<Lesson> getLessons()
	{
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


	public UniqueID getId()
	{
		return id;
	}


	public AbstractLearningClass getLearningClass() {
		return learningClass;
	}


	public void setLearningClass(AbstractLearningClass learningClass) {
		this.learningClass = learningClass;
	}


	
	public int compareTo(Student other) {
		
		int result = surname.compareToIgnoreCase(other.getSurname());
		
		if (result != 0)
		{
			return result;
		}
		else
		{
			return firstName.compareToIgnoreCase(other.getFirstName());			
		}
	}


//	public String getComparator()
//	{
//		return surname + " " + firstName;
//	}
	
	
	
}

package com.yeap.teachingAppV1.model;

import java.util.Iterator;
import java.util.LinkedList;

import com.yeap.teachingAppV1.model.uniqueID.UniqueID;

public class Student implements Teachable, Comparable<Student>
{
	
	private static final String idPrefix = new String("STU");
	private UniqueID id;
	private String surname;
	private String firstName;
	private String mobilePhone;
	private String homePhone;
	private String motherName;
	private String fatherName;
	private String motherPhone;
	private String fatherPhone;
	private String email;
	private LinkedList<AbstractLearningClass> learningClasses;
	private LinkedList<Lesson> lessons;

	
	public Student(String surname, String firstName, String className)
	{
		id = new UniqueID(idPrefix);
		this.surname = surname;
		this.firstName = firstName;
		mobilePhone = new String();
		homePhone = new String();
		motherName = new String();
		fatherName = new String();
		motherPhone = new String();
		fatherPhone = new String();
		email = new String();
		lessons = new LinkedList<Lesson>();
		learningClasses = new LinkedList<AbstractLearningClass>();
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
	
	
	public void addLearningClass(AbstractLearningClass newLearningClass)
	{
		learningClasses.addFirst(newLearningClass);
	}


	public boolean removeLearningClass(UniqueID learningClassID)
	{
		Iterator<AbstractLearningClass> iter = learningClasses.iterator();

		while (iter.hasNext())
		{
			if (iter.next().getId().equals(learningClassID))
			{
				iter.remove();
				return true;
			}
		}

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


	public LinkedList<AbstractLearningClass> getLearningClasses()
	{
		return learningClasses;
	}





	// public boolean clearLearningClassReferences()
	// {
	// for (AbstractLearningClass alc : learningClasses)
	// {
	// alc
	// }
	// }
	//
	// return false;
	// }
	
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

package com.yeap.teachingAppV1.model;

import com.yeap.teachingAppV1.model.uniqueID.UniqueID;

public class Student implements Lessons, Comparable<Student>
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
	private SearchableTreeSet<AbstractLearningClass> learningClasses;
	private SearchableTreeSet<Lesson> lessons;

	
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
		lessons = new SearchableTreeSet<Lesson>();
		learningClasses = new SearchableTreeSet<AbstractLearningClass>();
	}

	
	@Override
	public boolean addLesson(Lesson newLesson) {
		return lessons.add(newLesson);
	}

	@Override
	public boolean removeLesson(UniqueID lessonID)
	{
		
		return false;
	}
	
	
	public boolean addLearningClass(AbstractLearningClass newLearningClass)
	{
		return learningClasses.add(newLearningClass);
	}


//	public boolean removeLearningClass(UniqueID learningClassID)
//	{
//		return learningClasses.removeByID(learningClassID);
//	}
	

	@Override
	public boolean equals(UniqueID otherID) {
		
		return id.equals(otherID);
	}

	
	@Override
	public SearchableTreeSet<Lesson> getAllLessons()
	{
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


	public SearchableTreeSet<AbstractLearningClass> getLearningClasses()
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

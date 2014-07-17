package com.yeap.teachingAppV1.model;

import com.yeap.teachingAppV1.model.uniqueID.UniqueID;

abstract public class AbstractLearningClass implements Lessons, Comparable<AbstractLearningClass>
{

	private UniqueID id;
	private String name;
	private SearchableTreeSet<Lesson> lessons; // Should be sorted by date


	public AbstractLearningClass(String idPrefix, String name, boolean individual)
	{
		id = new UniqueID(idPrefix);
		this.name = name;
		lessons = new SearchableTreeSet<Lesson>();
	}


	public int compareTo(AbstractLearningClass otherClass)
	{
		return name.compareToIgnoreCase(otherClass.getName());
	}


	// Need to implement sorting here
	@Override
	public boolean addLesson(Lesson newLesson)
	{
		return lessons.add(newLesson);
	}


	// Doesn't check for errors or handle any exceptions
	@Override
	public boolean removeLesson(UniqueID lessonID)
	{
		return lessons.removeByID(lessonID);
	}

	public String getName()
	{
		return name;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public UniqueID getId()
	{
		return id;
	}


	abstract public SearchableTreeSet<Student> getAllStudents();
	

	abstract public boolean addStudent(Student student);
	

	abstract public boolean removeStudent(UniqueID studentID);
	

	public SearchableTreeSet<Lesson> getAllLessons()
	{
		return lessons;
	}
	
	@Override
	public String toString()
	{
		return id.toString();
	}

	
	@Override
	public boolean equals(UniqueID otherID)
	{   
		try
		{
			throw new Exception();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return id.equals(otherID);
	}
}

/*
 * TESTS
 * 
 * add lesson - also add to related students??
 * remove lesson - also remove from related students??
 * add student
 * remove student
 * compare/sort
 */


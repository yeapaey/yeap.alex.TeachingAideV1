package com.yeap.teachingAppV1.model;

import java.util.Iterator;
import java.util.LinkedList;

import com.yeap.teachingAppV1.model.uniqueID.StudentGroupID;
import com.yeap.teachingAppV1.model.uniqueID.UniqueID;

public class StudentGroup implements Teachable
{

	private StudentGroupID id;
	private String name;
	private LinkedList<Student> students;
	private LinkedList<Lesson> lessons;


	public StudentGroup(String name)
	{
		this.name = name;
		id = new StudentGroupID();
		students = new LinkedList<Student>();
		lessons = new LinkedList<Lesson>();
	}


	// Handles references both ways
	public void addStudent(Student newStudent)
	{
		newStudent.setGroup(this);
		students.add(newStudent);
	}


	// Removes a student from the group, including clearing its reference to the group
	public boolean removeStudent(StudentID studentID)
	{
		boolean found = false;
		Iterator<Student> iter = students.iterator();

		while (iter.hasNext() && !found)
		{
			Student student = iter.next();
			if (student.getId().equals(studentID))
			{
				try
				{
					student.setGroup(null);
					iter.remove();
					found = true;
				}
				catch (Exception e)
				{
					System.out.println("There was an error removing student from the group.");
				}
			}
		}

		return found;
	}


	@Override
	public boolean equals(UniqueID otherID)
	{
		return id.equals(otherID);
	}


	@Override
	public void addLesson(Lesson newLesson)
	{
		lessons.add(newLesson);

	}


	@Override
	public boolean removeLesson(UniqueID lessonID)
	{
		// TODO Auto-generated method stub
		return false;
	}


	public String getName()
	{
		return name;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public StudentGroupID getId()
	{
		return id;
	}


	public LinkedList<Student> getStudents()
	{
		return students;
	}


	@Override
	public LinkedList<Lesson> getLessons()
	{
		// TODO Auto-generated method stub
		return lessons;
	}

}

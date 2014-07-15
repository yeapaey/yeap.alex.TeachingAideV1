package com.yeap.teachingAppV1.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeSet;
import java.util.TreeSet;

import com.yeap.teachingAppV1.model.uniqueID.AbstractUniqueID;
import com.yeap.teachingAppV1.model.uniqueID.StudentGroupID;

public class StudentGroup implements Teachable {

	private StudentGroupID id;
	private String name;
	private TreeSet<Student> students;
	private TreeSet<Lesson> lessons;
	
	public StudentGroup(String name)
	{
		this.name = name;
		id = new StudentGroupID();
		students = new TreeSet<Student>();
		lessons = new TreeSet<Lesson>();
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
				catch (Exception e) {
					System.out.println("There was an error removing student from the group.");
				}
			}
		}
		
		return found;
	}
	

	
	@Override
	public boolean equals(AbstractUniqueID otherID) {

		return id.equals(otherID);
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
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StudentGroupID getId() {
		return id;
	}

	public TreeSet<Student> getStudents() {
		return students;
	}


	@Override
	public TreeSet<Lesson> getLessons() {
		// TODO Auto-generated method stub
		return lessons;
	}


	@Override
	public int compareTo(Teachable o) {
		
		return getComparator().compareToIgnoreCase(o.getComparator());
	}


	@Override
	public String getComparator() {

		return name;
	}


	
}

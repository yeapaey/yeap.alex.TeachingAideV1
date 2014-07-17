package com.yeap.teachingAppV1.model;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import com.yeap.teachingAppV1.model.uniqueID.UniqueID;

public class GroupLearningClass extends AbstractLearningClass {

	private static final String idPrefix = new String("GLC");
	private LinkedList<Student> students;


	public GroupLearningClass()
	{
		super(idPrefix, "Default Group Name", false);
		students = new LinkedList<Student>();
	}
	
	public GroupLearningClass(String name) {
		
		super(idPrefix, name, false);
		students = new LinkedList<Student>();
	}

	public static String getIdprefix() {
		return idPrefix;
	}


	@Override
	public LinkedList<Student> getStudents()
	{
		return students;
	}


	@Override
	public void addStudent(Student student)
	{
		students.add(student);
		Collections.sort(students, new StudentCompareAlphabetically());
	}


	@Override
	public boolean removeStudent(UniqueID studentID)
	{
		Iterator<Student> iter = students.iterator();
		while (iter.hasNext())
		{
			if (iter.next().equals(studentID))
			{
				iter.remove();
				return true;
			}
		}

		return false;
	}
	
}

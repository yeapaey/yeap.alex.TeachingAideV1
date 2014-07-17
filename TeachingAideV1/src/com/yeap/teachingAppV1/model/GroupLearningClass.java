package com.yeap.teachingAppV1.model;

import java.util.Iterator;

import com.yeap.teachingAppV1.model.uniqueID.UniqueID;

public class GroupLearningClass extends AbstractLearningClass {

	private static final String idPrefix = new String("GLC");
	private SearchableTreeSet<Student> students;


	public GroupLearningClass()
	{
		super(idPrefix, "Default Group Name", false);
		students = new SearchableTreeSet<Student>();
	}
	
	public GroupLearningClass(String name) {
		
		super(idPrefix, name, false);
		students = new SearchableTreeSet<Student>();
	}

	public static String getIdprefix() {
		return idPrefix;
	}


	@Override
	public SearchableTreeSet<Student> getAllStudents()
	{
		return students;
	}


	@Override
	public boolean addStudent(Student student)
	{
		return students.add(student);
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

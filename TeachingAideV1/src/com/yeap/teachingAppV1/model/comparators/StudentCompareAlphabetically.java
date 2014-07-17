package com.yeap.teachingAppV1.model.comparators;

import java.util.Comparator;

import com.yeap.teachingAppV1.model.Student;

public class StudentCompareAlphabetically implements Comparator<Student>
{
	public StudentCompareAlphabetically()
	{
	}


	@Override
	public int compare(Student s1, Student s2)
	{
		String s1Name = new String(s1.getSurname() + " " + s1.getFirstName());
		String s2Name = new String(s2.getSurname() + " " + s2.getFirstName());
		return s1Name.compareToIgnoreCase(s2Name);
	}

}

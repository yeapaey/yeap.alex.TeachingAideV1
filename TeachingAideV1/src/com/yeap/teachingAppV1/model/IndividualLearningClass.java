package com.yeap.teachingAppV1.model;

import com.yeap.teachingAppV1.model.uniqueID.UniqueID;

public class IndividualLearningClass extends AbstractLearningClass {

	private static final String idPrefix = new String("ILC");
	private Student student;
	

	// public IndividualLearningClass()
	// {
	// super(idPrefix, "Default Individual Name", false);
	// student = null;
	// }

	public IndividualLearningClass(String name, Student student)
	{
		super(idPrefix, name, true);
		this.student = student;
	}

	public static String getIdprefix() {
		return idPrefix;
	}


	@Override
	public SearchableTreeSet<Student> getAllStudents()
	{
		if (student == null)
		{
			return null;
		}
		else
		{
			SearchableTreeSet<Student> wrapper = new SearchableTreeSet<Student>();
			wrapper.add(student);

			return wrapper;
		}
	}


	@Override
	public boolean addStudent(Student student)
	{
		if (student == null)
		{
			this.student = student;
			return true;
		}

		return false;
		// else throw some sort of exception to indicate it can't be changed

	}


	@Override
	public boolean removeStudent(UniqueID studentID)
	{
		student = null;
		return true;
	}


}

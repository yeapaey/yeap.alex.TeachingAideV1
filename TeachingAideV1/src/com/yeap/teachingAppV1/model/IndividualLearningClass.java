package com.yeap.teachingAppV1.model;

import java.util.HashMap;

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
	public HashMap<UniqueID, Student> getStudents()
	{
		if (student == null)
		{
			return null;
		}
		else
		{
			HashMap<UniqueID, Student> wrapper = new HashMap<UniqueID, Student>();
			wrapper.put(student.getId(), student);

			return wrapper;
		}
	}



}

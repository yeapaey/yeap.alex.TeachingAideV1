package com.yeap.teachingAppV1.model;

import java.util.HashMap;

import com.yeap.teachingAppV1.model.uniqueID.UniqueID;

public class GroupLearningClass extends AbstractLearningClass {

	private static final String idPrefix = new String("GLC");
	private HashMap<UniqueID, Student> students;


	public GroupLearningClass()
	{
		super(idPrefix, "Default Group Name", false);
		students = new HashMap<UniqueID, Student>();
	}
	
	public GroupLearningClass(String name) {
		
		super(idPrefix, name, false);
		students = new HashMap<UniqueID, Student>();
	}

	public static String getIdprefix() {
		return idPrefix;
	}


	@Override
	public HashMap<UniqueID, Student> getStudents()
	{
		return students;
	}
	
}

package com.yeap.teachingAppV1.model;

import java.util.HashMap;

import com.yeap.teachingAppV1.model.uniqueID.AbstractUniqueID;
import com.yeap.teachingAppV1.model.uniqueID.UniqueID;

public class AbstractLearningClass {

	private AbstractUniqueID id;
	private String name;
	private HashMap<AbstractUniqueID, Student> students;
	private HashMap<AbstractUniqueID, Lesson> lessons;
	
	
	public AbstractLearningClass(String idPrefix, String name, boolean individual)
	{
		id = new UniqueID(idPrefix);
		this.name = name;
		lessons = new HashMap<AbstractUniqueID, Lesson>();		
		students = (individual ? new HashMap<AbstractUniqueID, Student>(1) : new HashMap<AbstractUniqueID, Student>());
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public AbstractUniqueID getId() {
		return id;
	}


	public HashMap<AbstractUniqueID, Student> getStudents() {
		return students;
	}


	public HashMap<AbstractUniqueID, Lesson> getLessons() {
		return lessons;
	}
	
	
}

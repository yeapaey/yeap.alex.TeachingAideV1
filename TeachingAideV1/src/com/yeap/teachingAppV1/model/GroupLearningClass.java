package com.yeap.teachingAppV1.model;

public class GroupLearningClass extends AbstractLearningClass {

	public GroupLearningClass()
	{
		super("", "Default Group Name", false);
	}
	
	public GroupLearningClass(String idPrefix, String name) {
		
		super(idPrefix, name, false);
	}

}

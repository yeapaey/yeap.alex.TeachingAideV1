package com.yeap.teachingAppV1.model;

public class IndividualLearningClass extends AbstractLearningClass {

	public IndividualLearningClass()
	{
		super("", "Default Individual Name", false);
	}
	
	public IndividualLearningClass(String idPrefix, String name) 
	{
		super(idPrefix, name, true);
	}

	
}

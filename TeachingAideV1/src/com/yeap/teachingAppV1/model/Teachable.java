package com.yeap.teachingAppV1.model;

import java.util.LinkedList;

import com.yeap.teachingAppV1.model.uniqueID.AbstractUniqueID;
import com.yeap.teachingAppV1.model.uniqueID.UniqueID;

public interface Teachable {

	public void addLesson(Lesson newLesson);
	public boolean removeLesson(UniqueID lessonID);
	public LinkedList<Lesson> getLessons();
	public boolean equals(UniqueID id);
	
//	public String getComparator();
//	public void prepareForDeletion();	
	
	
}

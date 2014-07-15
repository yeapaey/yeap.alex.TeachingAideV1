package com.yeap.teachingAppV1.model;

import java.util.SortedSet;

import com.yeap.teachingAppV1.model.uniqueID.AbstractUniqueID;

public interface Teachable extends Comparable<Teachable>{

	public void addLesson(Lesson newLesson);
	public boolean removeLesson();
	public SortedSet<Lesson> getLessons();
	public boolean equals(AbstractUniqueID id);
	public String getComparator();
//	public void prepareForDeletion();	
	
	
}

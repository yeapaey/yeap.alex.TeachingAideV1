package com.yeap.teachingAppV1.model;

import com.yeap.teachingAppV1.model.uniqueID.UniqueID;

public interface Lessons {

	public boolean addLesson(Lesson newLesson);
	public boolean removeLesson(UniqueID lessonID);
	public SearchableTreeSet<Lesson> getAllLessons();
	public boolean equals(UniqueID otherID);
//	public Lesson getLessonByID(UniqueID lessonID);
	
	
	
//	public String getComparator();
//	public void prepareForDeletion();	
	
	
}

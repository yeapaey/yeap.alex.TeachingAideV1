package com.yeap.teachingAppV1.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import com.yeap.teachingAppV1.model.uniqueID.UniqueID;

abstract public class AbstractLearningClass implements Teachable, Comparable<AbstractLearningClass>
{

	private UniqueID id;
	private String name;
	// private HashMap<UniqueID, Student> students; // Should be sorted alphabetically
	private LinkedList<Lesson> lessons; // Should be sorted by date


	public AbstractLearningClass(String idPrefix, String name, boolean individual)
	{
		id = new UniqueID(idPrefix);
		this.name = name;
		lessons = new LinkedList<Lesson>();
		// students = (individual ? new HashMap<UniqueID, Student>(1) : new HashMap<UniqueID, Student>());
	}


	public int compareTo(AbstractLearningClass otherClass)
	{
		return name.compareToIgnoreCase(otherClass.getName());
	}


	// Need to implement sorting here
	@Override
	public void addLesson(Lesson newLesson)
	{
		Iterator<Lesson> iter = lessons.iterator();
		Lesson current = null;
		boolean inserted = false;

		newLesson.addLearningClass(this); // Very Important line!

		if (lessons.isEmpty())
		{
			lessons.add(newLesson);
		}
		else
		{
			while (iter.hasNext() && !inserted)
			{
				current = iter.next();
				if (newLesson.getDate().compareTo(current.getDate()) <= 0)
				{
					lessons.add(lessons.indexOf(current), newLesson); // This is (seemingly) not elegant
					inserted = false;
				}
			}

			if (!inserted)
			{
				lessons.addLast(newLesson);
			}
		}
	}


	// Doesn't check for errors or handle any exceptions
	@Override
	public boolean removeLesson(UniqueID lessonID)
	{
		Iterator<Lesson> iter = lessons.iterator();
		Lesson current = null;

		while (iter.hasNext())
		{
			current = iter.next();
			if (current.getId().equals(lessonID))
			{
				iter.remove();
				return true;
			}
		}

		return false;
	}


	@Override
	public boolean equals(UniqueID otherID)
	{
		return id.equals(otherID);
	}


	public String getName()
	{
		return name;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public UniqueID getId()
	{
		return id;
	}


	abstract public HashMap<UniqueID, Student> getStudents();

	public LinkedList<Lesson> getLessons()
	{
		return lessons;
	}

}

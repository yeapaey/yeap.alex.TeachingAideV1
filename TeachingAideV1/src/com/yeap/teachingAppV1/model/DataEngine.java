package com.yeap.teachingAppV1.model;

import java.util.Iterator;
import java.util.TreeSet;

import com.yeap.teachingAppV1.model.uniqueID.AbstractUniqueID;
import com.yeap.teachingAppV1.model.uniqueID.StudentGroupID;

public class DataEngine {

	private static final DataEngine instance = new DataEngine();
	private TreeSet<Teachable> allTeachable;
	
	private DataEngine()
	{
		allTeachable = new TreeSet<Teachable>();
	}
	
	public static DataEngine getInstance()
	{
		return instance;
	}

	
	public void addTeachable(Teachable newTeachable)
	{
		allTeachable.add(newTeachable);
	}
	
	
	public boolean deleteTeachable(AbstractUniqueID id)
	{	
		Iterator<Teachable> iter = allTeachable.iterator();

		while (iter.hasNext())
		{
			Teachable teachable = iter.next(); 
			if (teachable.equals(id))
			{
				prepTeachableForDeletion(teachable);
				allTeachable.remove(teachable);
				return true;
			}
		}
	
		return false;
	}
	
	
	public void addStudentToStudentGroup(StudentGroupID groupID, StudentID studentID)
	{	
		StudentGroup group = (StudentGroup) getTeachable(groupID);
		Student student = (Student) getTeachable(studentID);
		
		
		// check for nulls

		
		group.addStudent(student);	
		
	}
	
	// Need to update to do proper checks
	public boolean removeStudentFromStudentGroup(StudentGroupID groupID, StudentID studentID)
	{
		StudentGroup group = (StudentGroup) getTeachable(groupID);
		
		// check for nulls
		
		group.removeStudent(studentID);
		
		return true;
	}
	
	
	
	private void prepTeachableForDeletion(Teachable teachable)
	{
		if (teachable.getClass() == Student.class)
		{
			Student student = (Student) teachable;
			if (student.getGroup() != null)
			{
				student.getGroup().removeStudent(student.getId());
			}
			
		}
		else if (teachable.getClass() == StudentGroup.class)
		{
			StudentGroup group = (StudentGroup) teachable;

			for (Student s : group.getStudents())
			{
				s.setGroup(null);
			}
		}
	}
	
	
	public Teachable getTeachable(AbstractUniqueID id)
	{
		Iterator<Teachable> iter = allTeachable.iterator();
		
		while (iter.hasNext())
		{
			Teachable teachable = iter.next(); 
			if (teachable.equals(id))
			{
				return teachable;
			}
		}
		
		return null;
	}

	
	public TreeSet<Teachable> getAllTeachable()
	{
		return allTeachable;
	}
	
	
	/* NB - for this method and the one below, it may make more sense to return a TreeSet<Teachable>
	 * instead of the more specific type, as casting may not be required on the other end.
	 */
	public TreeSet<Student> getAllStudents() {
		
		TreeSet<Student> allStudents = new TreeSet<Student>();
		
		for (Teachable teachable : allTeachable)
		{
			if (teachable.getClass() == Student.class)
			{
				allStudents.add((Student) teachable);
			}
		}
		
		return allStudents;
	}


	// See comment of above method
	public TreeSet<StudentGroup> getAllStudentGroups() {
		
		TreeSet<StudentGroup> allStudentGroups = new TreeSet<StudentGroup>();
		
		for (Teachable teachable : allTeachable)
		{
			if (teachable.getClass() == StudentGroup.class)
			{
				allStudentGroups.add((StudentGroup) teachable);
			}
		}
		return allStudentGroups;
	}
	
	
	
	
}

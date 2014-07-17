package com.yeap.teachingAppV1.model;

import java.util.Iterator;

import com.yeap.teachingAppV1.model.uniqueID.UniqueID;

public class DataEngine
{

	private static final DataEngine instance = new DataEngine();
	private SearchableTreeSet<Student> allStudents;
	private SearchableTreeSet<AbstractLearningClass> allLearningClasses;


	private DataEngine()
	{
		allStudents = new SearchableTreeSet<Student>();
		allLearningClasses = new SearchableTreeSet<AbstractLearningClass>();
	}


	public static DataEngine getInstance()
	{
		return instance;
	}


	public boolean addStudent(Student newStudent)
	{
		return allStudents.add(newStudent);
	}


	public boolean removeStudent(UniqueID studID)
	{
		return allStudents.removeByID(studID);
		
//		Iterator<Student> iter = allStudents.iterator();
//		Student current;
//
//		while (iter.hasNext())
//		{
//			current = iter.next();
//			if (current.getId().equals(studID))
//			{
//				// remove references to learning classes
//				for (AbstractLearningClass alc : current.getLearningClasses())
//				{
//					if (alc.getClass() == IndividualLearningClass.class)
//					{
//						allStudents.remove(alc);
//					}
//					else
//					{
//						alc.getAllStudents().remove(studID);
//					}
//				}
//
//				iter.remove();
//				return true;
//			}
//		}
//
//		return false;
	}


	public void addLearningClass(AbstractLearningClass newLearningClass)
	{
		allLearningClasses.add(newLearningClass);
	}


	public boolean removeLearningClass(UniqueID learningClassID)
	{
		return allLearningClasses.removeByID(learningClassID);
//		Iterator<AbstractLearningClass> iter = allLearningClasses.iterator();
//		AbstractLearningClass current;
//
//		while (iter.hasNext())
//		{
//			current = iter.next();
//			if (current.equals(learningClassID))
//			{
//				current.getAllStudents().remove(learningClassID);
//			}
//
//			return true;
//		}
//
//		return false;
	}


	// returns boolean because it requires finding by ID. If student object was passed, could change to void.
	public boolean addStudentToLearningClass(UniqueID groupID, UniqueID studentID)
	{
//		AbstractLearningClass lc = getLearningClassByID(groupID);
//		
//		if (allLearningClasses.getByID(groupID) == null ||
//			allStudents.getByID(studentID) == null)
//		{
//			return false;
//		}
		try 
		{
			return allLearningClasses.getByID(groupID).addStudent(allStudents.getByID(studentID));
		}
		catch (NullPointerException npe)
		{
			return false; // May be better to just have the whole method throw a NPE
		}
	}

	// Is this even necessary?
	public AbstractLearningClass getLearningClassByID(UniqueID learningClassID)
	{
		return allLearningClasses.getByID(learningClassID);
//		Iterator<AbstractLearningClass> iter = allLearningClasses.iterator();
//		AbstractLearningClass current = null;
//
//		while (iter.hasNext())
//		{
//			current = iter.next();
//			if (current.equals(learningClassID))
//			{
//				return current;
//			}
//		}
//
//		return null;
	}


	// Is this even necessary?
	public Student getStudentByID(UniqueID studentID)
	{
		return allStudents.getByID(studentID);
//		Student current;
//		Iterator<Student> iter = allStudents.iterator();
//
//		while (iter.hasNext())
//		{
//			current = iter.next();
//			if (current.equals(studentID))
//			{
//				return current;
//			}
//		}
//
//		return null;
	}


	// Need to update to do proper checks
	// public boolean removeStudentFromStudentGroup(StudentGroupID groupID, StudentID studentID)
	// {
	// StudentGroup group = (StudentGroup) getTeachable(groupID);
	//
	// // check for nulls
	//
	// group.removeStudent(studentID);
	//
	// return true;
	// }


//	 private void prepTeachableForDeletion(Teachable teachable)
//	 {
//	 if (teachable.getClass() == Student.class)
//	 {
//	 Student student = (Student) teachable;
//	 if (student.getGroup() != null)
//	 {
//	 student.getGroup().removeStudent(student.getId());
//	 }
//	
//	 }
//	 else if (teachable.getClass() == StudentGroup.class)
//	 {
//	 StudentGroup group = (StudentGroup) teachable;
//	
//	 for (Student s : group.getStudents())
//	 {
//	 s.setGroup(null);
//	 }
//	 }
//	 }


	// public Teachable getTeachable(AbstractUniqueID id)
	// {
	// Iterator<Teachable> iter = allTeachable.iterator();
	//
	// while (iter.hasNext())
	// {
	// Teachable teachable = iter.next();
	// if (teachable.equals(id))
	// {
	// return teachable;
	// }
	// }
	//
	// return null;
	// }


	// public SearchableTreeSet<Teachable> getAllTeachable()
	// {
	// return allTeachable;
	// }


	/*
	 * NB - for this method and the one below, it may make more sense to return a SearchableTreeSet<Teachable> instead of the more
	 * specific type, as casting may not be required on the other end.
	 */
	public SearchableTreeSet<Student> getAllStudents()
	{
		return allStudents;
	}


	public SearchableTreeSet<AbstractLearningClass> getAllLearningClasses()
	{
		return allLearningClasses;
	}

	// See comment of above method
	// public SearchableTreeSet<StudentGroup> getAllStudentGroups()
	// {
	//
	// SearchableTreeSet<StudentGroup> allStudentGroups = new SearchableTreeSet<StudentGroup>();
	//
	// for (Teachable teachable : allTeachable)
	// {
	// if (teachable.getClass() == StudentGroup.class)
	// {
	// allStudentGroups.add((StudentGroup) teachable);
	// }
	// }
	// return allStudentGroups;
	// }

}

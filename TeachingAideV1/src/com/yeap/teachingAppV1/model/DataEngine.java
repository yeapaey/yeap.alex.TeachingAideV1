package com.yeap.teachingAppV1.model;

import java.util.Iterator;
import java.util.TreeSet;

import com.yeap.teachingAppV1.model.uniqueID.UniqueID;

public class DataEngine
{

	private static final DataEngine instance = new DataEngine();
	private TreeSet<Student> allStudents;
	private TreeSet<AbstractLearningClass> allLearningClasses;


	private DataEngine()
	{
		allStudents = new TreeSet<Student>();
		allLearningClasses = new TreeSet<AbstractLearningClass>();
	}


	public static DataEngine getInstance()
	{
		return instance;
	}


	public void addStudent(Student newStudent)
	{
		allStudents.add(newStudent);
	}


	public boolean removeStudent(UniqueID studID)
	{
		Iterator<Student> iter = allStudents.iterator();
		Student current;

		while (iter.hasNext())
		{
			current = iter.next();
			if (current.getId().equals(studID))
			{
				// remove references to learning classes
				for (AbstractLearningClass alc : current.getLearningClasses())
				{
					if (alc.getClass() == IndividualLearningClass.class)
					{
						allStudents.remove(alc);
					}
					else
					{
						alc.getStudents().remove(studID);
					}
				}

				iter.remove();
				return true;
			}
		}

		return false;
	}


	public void addLearningClass(AbstractLearningClass newLearningClass)
	{
		allLearningClasses.add(newLearningClass);
	}


	public boolean removeLearningClass(UniqueID learningClassID)
	{
		Iterator<AbstractLearningClass> iter = allLearningClasses.iterator();
		AbstractLearningClass current;

		while (iter.hasNext())
		{
			current = iter.next();
			if (current.equals(learningClassID))
			{
				current.getStudents().remove(learningClassID);
			}

			return true;
		}

		return false;
	}


	// returns boolean because it requires finding by ID. If student object was passed, could change to void.
	public boolean addStudentToLearningClass(UniqueID groupID, UniqueID studentID)
	{
		AbstractLearningClass lc = getLearningClassByID(groupID);
		
		if (lc != null)
		{
			Student s = getStudentByID(studentID);
			lc.addStudent(s);
			return true;
		}

		return false;
	}


	public AbstractLearningClass getLearningClassByID(UniqueID learningClassID)
	{
		Iterator<AbstractLearningClass> iter = allLearningClasses.iterator();
		AbstractLearningClass current = null;

		while (iter.hasNext())
		{
			current = iter.next();
			if (current.equals(learningClassID))
			{
				return current;
			}
		}

		return null;
	}


	public Student getStudentByID(UniqueID studentID)
	{
		Student current;
		Iterator<Student> iter = allStudents.iterator();

		while (iter.hasNext())
		{
			current = iter.next();
			if (current.equals(studentID))
			{
				return current;
			}
		}

		return null;
	}


	// public void addTeachable(Teachable newTeachable)
	// {
	// allTeachable.add(newTeachable);
	// }


	// public boolean deleteTeachable(AbstractUniqueID id)
	// {
	// Iterator<Teachable> iter = allTeachable.iterator();
	//
	// while (iter.hasNext())
	// {
	// Teachable teachable = iter.next();
	// if (teachable.equals(id))
	// {
	// prepTeachableForDeletion(teachable);
	// allTeachable.remove(teachable);
	// return true;
	// }
	// }
	//
	// return false;
	// }


	// public void addStudentToStudentGroup(StudentGroupID groupID, StudentID studentID)
	// {
	// StudentGroup group = (StudentGroup) getTeachable(groupID);
	// Student student = (Student) getTeachable(studentID);
	//
	// // check for nulls
	//
	// group.addStudent(student);
	//
	// }


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


	// private void prepTeachableForDeletion(Teachable teachable)
	// {
	// if (teachable.getClass() == Student.class)
	// {
	// Student student = (Student) teachable;
	// if (student.getGroup() != null)
	// {
	// student.getGroup().removeStudent(student.getId());
	// }
	//
	// }
	// else if (teachable.getClass() == StudentGroup.class)
	// {
	// StudentGroup group = (StudentGroup) teachable;
	//
	// for (Student s : group.getStudents())
	// {
	// s.setGroup(null);
	// }
	// }
	// }


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


	// public TreeSet<Teachable> getAllTeachable()
	// {
	// return allTeachable;
	// }


	/*
	 * NB - for this method and the one below, it may make more sense to return a TreeSet<Teachable> instead of the more
	 * specific type, as casting may not be required on the other end.
	 */
	public TreeSet<Student> getAllStudents()
	{
		return allStudents;
	}


	public TreeSet<AbstractLearningClass> getAllLearningClasses()
	{
		return allLearningClasses;
	}

	// See comment of above method
	// public TreeSet<StudentGroup> getAllStudentGroups()
	// {
	//
	// TreeSet<StudentGroup> allStudentGroups = new TreeSet<StudentGroup>();
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

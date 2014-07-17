package com.yeap.teachingAppV1.model;

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
	}


	public void addLearningClass(AbstractLearningClass newLearningClass)
	{
		allLearningClasses.add(newLearningClass);
	}


	public boolean removeLearningClass(UniqueID learningClassID)
	{
		return allLearningClasses.removeByID(learningClassID);
	}


	// returns boolean because it requires finding by ID. If student object was passed, could change to void.
	public boolean addStudentToLearningClass(UniqueID groupID, UniqueID studentID)
	{
//		System.out.printf("G - %s\nS - %s\n", groupID.toString(), studentID.toString());
		try 
		{
			AbstractLearningClass alc = allLearningClasses.getByID(groupID);
			Student s = allStudents.getByID(studentID);
			if (alc == null)
				System.out.println("alc returned null!");
			if(s == null)
				System.out.println("s returned null!");
			
			return alc.addStudent(s);
		}
		catch (NullPointerException npe)
		{
			npe.printStackTrace();
//			System.out.println("Null pointer! AddStudentToLearningClass");
			return false; // May be better to just have the whole method throw a NPE
		}
	}
	
	
	public boolean removeStudentFromLearningClass(UniqueID groupID, UniqueID studentID)
	{
		try 
		{
			return allLearningClasses.getByID(groupID).removeStudent(studentID);
		}
		catch (NullPointerException npe)
		{
			System.out.println("Null pointer! RemoveStudentFromLearningClass");
			return false; // May be better to just have the whole method throw a NPE
		}
	}

	// Is this even necessary?
	public AbstractLearningClass getLearningClassByID(UniqueID learningClassID)
	{
		return allLearningClasses.getByID(learningClassID);
	}


	// Is this even necessary?
	public Student getStudentByID(UniqueID studentID)
	{
		return allStudents.getByID(studentID);
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

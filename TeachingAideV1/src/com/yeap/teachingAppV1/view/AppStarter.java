package com.yeap.teachingAppV1.view;

import java.util.Collection;

import com.yeap.teachingAppV1.model.AbstractLearningClass;
import com.yeap.teachingAppV1.model.DataEngine;
import com.yeap.teachingAppV1.model.IndividualLearningClass;
import com.yeap.teachingAppV1.model.Student;

public class AppStarter {
	private static DataEngine engine  = DataEngine.getInstance();
	
	public static void main(String[] args) {
		
		loadDummyData();
		printEverything();
		
		// testAddStudentToGroup();
		//
		// testRemoveStudentFromGroup();
		//
		// testRemoveStudent();
		//
		// testAddLesson();
	}

	
	public static void printEverything()
	{
		System.out.printf("\nSTUDENTS:");
		for (Student s : engine.getAllStudents())
		{
			if (s != null)
			{
				System.out.printf("\n%s %s. Classes:", s.getFirstName(), s.getSurname());
				for (AbstractLearningClass alc : s.getLearningClasses())
				{
					System.out.printf(" %s", alc.getName());
				}
			}
		}
		
		System.out.printf("\n\nLEARNING CLASSES:");
		for (AbstractLearningClass alc : engine.getAllLearningClasses())
		{
			if (alc != null)
			{
				System.out.printf("\n%s. Students:", alc.getName());
			}
			
			Collection<Student> studs = alc.getStudents().values();
			for (Student s : studs)
			{
				System.out.printf(" %s %s", s.getFirstName(), s.getSurname());
			}
		}
		
		
		System.out.println("\n******************************************");
	}
	
	
	
	public static void loadDummyData()
	{
		Student a = new Student("Phelan", "Maddy", "9B");
		engine.addStudent(a);
		engine.addStudent(new Student("Anderson", "Ashleigh", "9C"));
		engine.addStudent(new Student("Baxter", "Evie", "9A"));
		engine.addLearningClass(new IndividualLearningClass("Maddy Phelan Class", a));
	}
	
	// public static void testAddStudentToGroup()
	// {
	// StudentGroup a = new StudentGroup("Group Z");
	// Student b = new Student("Cron", "Annelise", "12A");
	// Student c = new Student("Svensson", "Rachel", "7C");
	// engine.addTeachable(a);
	// engine.addTeachable(b);
	// engine.addTeachable(c);
	// engine.addStudentToStudentGroup(a.getId(), b.getId());
	// engine.addStudentToStudentGroup(a.getId(), c.getId());
	//
	// printEverything();
	// }
	
	
	// public static void testRemoveStudentFromGroup()
	// {
	// Iterator<Student> iter = engine.getAllStudents().iterator();
	// boolean exit = false;
	//
	// while (iter.hasNext() && !exit)
	// {
	// Student student = iter.next();
	// if (student.getGroup() != null)
	// {
	// engine.removeStudentFromStudentGroup(student.getGroup().getId(), student.getId());
	// exit = true;
	// }
	// }
	//
	// printEverything();
	// }
	
	
	// public static void testRemoveStudent()
	// {
	// engine.addStudentToStudentGroup(engine.getAllStudentGroups().first().getId(),
	// engine.getAllStudents().first().getId());
	// printEverything();
	//
	// engine.deleteTeachable(engine.getAllStudents().first().getId());
	// printEverything();
	// }
	
	
	// public static void testAddLesson()
	// {
	// Teachable teachable = engine.getAllStudents().first();
	//
	// Lesson a = new Lesson();
	// a.setPlan("Test plan");
	// a.setAbsent(true);
	//
	// teachable.addLesson(a);
	// System.out.println("Lesson added to " + teachable.getComparator());
	// a.printDetails();
	//
	// for (Teachable t : engine.getAllStudents())
	// {
	// System.out.println(t.getComparator() + " has " + t.getLessons().size() + " lessons");
	//
	// for (Lesson l : t.getLessons())
	// {
	// l.printDetails();
	// }
	// }
	//
	// }
	
	
	
}

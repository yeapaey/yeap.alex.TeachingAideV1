package com.yeap.teachingAppV1.view;

import java.util.Iterator;

import javax.print.event.PrintEvent;

import com.yeap.teachingAppV1.model.DataEngine;
import com.yeap.teachingAppV1.model.Lesson;
import com.yeap.teachingAppV1.model.Student;
import com.yeap.teachingAppV1.model.StudentGroup;
import com.yeap.teachingAppV1.model.Teachable;

public class AppStarter {
	private static DataEngine engine  = DataEngine.getInstance();
	
	public static void main(String[] args) {
		
		loadDummyData();
		printEverything();
		
		testAddStudentToGroup();
		
		testRemoveStudentFromGroup();
		
		testRemoveStudent();
		
		testAddLesson();
	}

	
	public static void printEverything()
	{
		System.out.println("STUDENTS:");
		for (Student s : engine.getAllStudents())
		{
			if (s != null)
			{
				System.out.printf("%s %s, %s\n", s.getFirstName(), s.getSurname(), s.getClassName());
			}
		}
		
		System.out.println("\nGROUPS:");
		for (StudentGroup g : engine.getAllStudentGroups())
		{
			if (g != null)
			{
				System.out.printf("%s: \n", g.getName());
			}
			
			for (Student gs : g.getStudents())
			{
				if (gs != null)
				{
					System.out.printf("\t%s %s\n", gs.getFirstName(), gs.getSurname());
				}
				
			}
		}
		
		
		System.out.println("******************************************");
	}
	
	
	
	public static void loadDummyData()
	{
		engine.addTeachable(new Student("Phelan", "Maddy", "9B"));
		engine.addTeachable(new Student("Anderson", "Ashleigh", "9C"));
		engine.addTeachable(new Student("Baxter", "Evie", "9A"));
		engine.addTeachable(new StudentGroup("Group A"));
	}
	
	public static void testAddStudentToGroup()
	{
		StudentGroup a = new StudentGroup("Group Z");
		Student b = new Student("Cron", "Annelise", "12A");
		Student c = new Student("Svensson", "Rachel", "7C");
		engine.addTeachable(a);
		engine.addTeachable(b);
		engine.addTeachable(c);
		engine.addStudentToStudentGroup(a.getId(), b.getId());
		engine.addStudentToStudentGroup(a.getId(), c.getId());
		
		printEverything();
	}
	
	
	public static void testRemoveStudentFromGroup()
	{
		Iterator<Student> iter = engine.getAllStudents().iterator();
		boolean exit = false;
		
		while (iter.hasNext() && !exit)
		{
			Student student = iter.next();
			if (student.getGroup() != null)
			{
				engine.removeStudentFromStudentGroup(student.getGroup().getId(), student.getId());
				exit = true;
			}
		}
		
		printEverything();
	}
	
	
	public static void testRemoveStudent()
	{		
		engine.addStudentToStudentGroup(engine.getAllStudentGroups().first().getId(), engine.getAllStudents().first().getId());
		printEverything();
		
		engine.deleteTeachable(engine.getAllStudents().first().getId());
		printEverything();
	}
	
	
	public static void testAddLesson()
	{
		Teachable teachable = engine.getAllStudents().first();
		
		Lesson a = new Lesson();
		a.setPlan("Test plan");
		a.setAbsent(true);
		
		teachable.addLesson(a);
		System.out.println("Lesson added to " + teachable.getComparator());
		a.printDetails();
		
		for (Teachable t : engine.getAllStudents())
		{
			System.out.println(t.getComparator() + " has " + t.getLessons().size() + " lessons");
			
			for (Lesson l : t.getLessons())
			{
				l.printDetails();
			}
		}
		
	}
	
	
	
}

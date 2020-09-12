package master_assignment.manager;

import java.util.ArrayList;
import java.util.Date;

import master_assignment.bean.Academy;
import master_assignment.bean.Course;

public class CourseManager {
	

	public static void printMostFavouredCourse() {
		// TODO use courseList & studentMap from Academy
	}
	
	public static ArrayList<Course> addCourse(ArrayList<Course> courseList) {
		Course c1 = new Course(1, "Computer", new Date(3 / 10 / 2017), "java", 30000, "2 months");
		Course c2 = new Course(2, "IT", new Date(4 / 10 / 2017), "Adv java", 40000, "3 months");
		Course c3 = new Course(3, "Computer", new Date(5 / 10 / 2017), "networking", 20000, "2 months");
		Course c4 = new Course(4, "IT", new Date(6 / 10 / 2017), "java", 30000, "4 months");
		Course c5 = new Course(5, "ENTC", new Date(7 / 10 / 2017), "Ecg", 50000, "5 months");

		Academy.courseList.add(c1);
		Academy.courseList.add(c2);
		Academy.courseList.add(c3);
		Academy.courseList.add(c4);
		Academy.courseList.add(c5);

		return Academy.courseList;
	}

}

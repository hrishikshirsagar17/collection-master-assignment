package master_assignment.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import master_assignment.bean.Academy;
import master_assignment.bean.Course;
import master_assignment.bean.Student;

public class StudentManager {

	static List<Student> studentList;

	public static void addStudent(int courseId) {

		studentList = Academy.studentMap.get(courseId);

		Student s1 = new Student(101, "john", 12345, "john@gmail.com");
		Student s2 = new Student(102, "smith", 12346, "smith@gmail.com");
		Student s3 = new Student(105, "robin", 12347, "robin@gmail.com");
		Student s4 = new Student(106, "james", 12348, "james@gmail.com");
		Student s5 = new Student(103, "ronald", 12349, "ronald@gmail.com");

		if (studentList == null) 
		{
			studentList = new ArrayList<>();
			Academy.studentMap.put(courseId, studentList);
		}
		if (courseId == 1)
		{
			studentList.add(s1);
			studentList.add(s3);
		}
		else if (courseId == 2)
        {
			studentList.add(s2);
			studentList.add(s4);
		} 
		else if (courseId == 3)
			studentList.add(s5);

		CourseManager.addCourse(Academy.courseList);

	}

	/*
	 * 
	 * get student data when course id as a input..
	 * 
	 * public static HashMap<Long, List<Student>> getStudent(long courseId) {
	 * addStudent(1);
	 * 
	 * ArrayList<Student>stud_manager_list=new ArrayList<Student>();
	 * 
	 * 
	 * 
	 * for(int j=0;j<studentList.size();j++) {
	 * 
	 * if(courseId==studentList.get(j).getcourseId()) {
	 * 
	 * stud_manager_list.add(studentList.get(j));
	 * 
	 * 
	 * }
	 * 
	 * }//System.out.println(stud_manager_list);
	 * 
	 * 
	 * Accademy.studentMap.put((long) courseId,new
	 * ArrayList<Student>(stud_manager_list) ); //
	 * System.out.println(Accademy.studentMap);
	 * 
	 * 
	 * 
	 * return Accademy.studentMap; }
	 */
	// get student data when corse name as a input
	public static void getStudentUsingCourseName(String course_name) {
		addStudent(1);

		/*
		 * System.out.
		 * println("******************courese list**********************");
		 * System.out.println(Accademy.courseList);
		 */

		System.out.println("*******course id of student who enrolled for one course******");
		for (int i = 0; i < Academy.courseList.size(); i++) {
			Course c;
			c = Academy.courseList.get(i);
			String str = c.course_name;

			if (str.equals(course_name)) {
				long cid = c.courseId;
				if (Academy.studentMap.containsKey(cid)) {

					System.out.println(Academy.studentMap + "\n");
				}

			}
		}

	}

	public static void maxStudentForCourse() {
		addStudent(1);
		int max = 0;

		HashMap<Long, Integer> studentdummymap = new HashMap<Long, Integer>();

		studentdummymap = (HashMap<Long, Integer>) Academy.studentMap.get(studentList);
		System.out.println(Academy.studentMap);
		CourseManager.addCourse(Academy.courseList);

		for (int j = 0; j < Academy.courseList.size(); j++) {
			int count = 0;
			for (int i = 0; i < Academy.studentMap.size(); i++) {
				/*if (studentList.get(i).getcourseId() == 1) {
					count++;
					long sid = studentList.get(i).getStudent_id();

				}*/
				if (count >= max) {
					max = count;
					// studentdummymap.put((Long)1, count);
				}
			}
			System.out.println(studentdummymap);
		}
	}
}
package master_assignment.action;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import master_assignment.bean.*;

class DuplicateEntryException extends RuntimeException {
	public DuplicateEntryException() {
		super("Duplicate Entry... Student Already Exists...");
	}

	public DuplicateEntryException(String msg) {
		super(msg);
	}
}

public class TestAcademy {
	public static void Ques1() 
	{
		// write method to delete a student using student name. 
		//delete from studlist,attendance list and test list
		
		Student s1 = new Student(101, "Hrishi", 7709932562L, "Hrishi@gmail.com");
		Student s2 = new Student(104, "Sameer", 7709932563L, "Sameer@gmail.com");
		Student s3 = new Student(103, "Rahul", 7709932564L, "Rahul@gmail.com");
		Student s4 = new Student(105, "Chetan", 7709932565L, "Chetan@gmail.com");
		Student s5 = new Student(102, "Aditya", 7709932566L, "Aditya@gmail.com");
		
		  Academy.studentMap.put(1, Arrays.asList(s5)); 
		  Academy.studentMap.put(2, Arrays.asList(s4)); 
		  Academy.studentMap.put(3, Arrays.asList(s1));
		  Academy.studentMap.put(4, Arrays.asList(s3)); 
		  Academy.studentMap.put(5, Arrays.asList(s2));
		  
		    Attendance a1 = new Attendance(11, 102, "P", new Date(2020, 07, 03));
			Attendance a2 = new Attendance(12, 105, "A", new Date(2020, 07, 04));
			Attendance a3 = new Attendance(13, 101, "P", new Date(2020, 07, 05));
			Attendance a4 = new Attendance(14, 103, "P", new Date(2020, 07, 06));
			Attendance a5 = new Attendance(15, 104, "A", new Date(2020, 07, 07));
			
			  Academy.attendanceMap.put(1, Arrays.asList(a5)); 
			  Academy.attendanceMap.put(2, Arrays.asList(a4)); 
			  Academy.attendanceMap.put(3, Arrays.asList(a1));
			  Academy.attendanceMap.put(4, Arrays.asList(a3)); 
			  Academy.attendanceMap.put(5, Arrays.asList(a2));
			
			  	TestResult t1 =new TestResult(new Date(2020, 10, 9), 10, 102, 90, 100);
			  	TestResult t2 =new TestResult(new Date(2020, 10, 9), 11, 105, 91, 100);
				TestResult t3 =new TestResult(new Date(2020, 10, 9), 12, 101, 92, 100);
				TestResult t4 =new TestResult(new Date(2020, 10, 9), 13, 103, 93, 100);
				TestResult t5 =new TestResult(new Date(2020, 10, 9), 14, 104, 94, 100);
				
				 Academy.test_map.put(1, Arrays.asList(t5));
				 Academy.test_map.put(2, Arrays.asList(t4)); 
				 Academy.test_map.put(3, Arrays.asList(t1));
				 Academy.test_map.put(4, Arrays.asList(t3));
				 Academy.test_map.put(5, Arrays.asList(t2));
			
		  
		  
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Student Name Whose Data You Want To Delete?");
		String name = sc.next();

		Iterator<Map.Entry<Integer, List<Student>>> si = Academy.studentMap.entrySet().iterator();
		Iterator<Map.Entry<Integer, List<Attendance>>> ai = Academy.attendanceMap.entrySet().iterator();
		Iterator<Map.Entry<Integer, List<TestResult>>> ti = Academy.test_map.entrySet().iterator();
		while (si.hasNext()) {
			List<Student> s = si.next().getValue();
			for (Student st : s) {
				if (st.getstudent_name().equalsIgnoreCase(name)) {
					si.remove();
					while (ai.hasNext()) {
						List<Attendance> a = ai.next().getValue();
						for (Attendance at : a) {
							if (at.getStudId() == st.getStudent_id()) {
								ai.remove();
								while (ti.hasNext()) {
									List<TestResult> t = ti.next().getValue();
									for (TestResult tt : t) {
										if (tt.getStudentId() == st.getStudent_id()) {
											ti.remove();

										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(Academy.studentMap);
		System.out.println("**********************************");
		System.out.println(Academy.attendanceMap);
		System.out.println("**********************************");
		System.out.println(Academy.test_map);
		sc.close();

	}

	public static void Ques2()
	{
		// show most favoured course based on number of students enrolled. (Course with
		// maximum students)
		
		 Student s1 = new Student(107, "john", 12345, "john@gmail.com");
		 Student s2 = new Student(109, "smith", 12346, "smith@gmail.com"); 
		 Student s3 = new Student(110, "robin", 12347, "robin@gmail.com");
	     Student s4 = new Student(106, "james", 12348, "james@gmail.com"); 
		 Student s5 = new Student(108, "ronald", 12349, "ronald@gmail.com"); 
		 Student s6 = new Student(101, "Hrishi", 7709932562L, "hrishi@gmail.com"); 
		 Student s7 = new Student(104, "Sameer", 7709932563L, "Sameer@gmail.com"); 
		 Student s8 = new Student(103, "Rahul", 7709932564L, "Rahul@gmail.com"); 
		 Student s9 = new Student(105, "Chetan", 7709932565L, "Chetan@gmail.com"); 
		 Student s10 = new Student(102, "Aditya", 7709932566L, "Aditya@gmail.com");
		 
		 Academy.studentMap.put(1, Arrays.asList(s1, s2)); 
		 Academy.studentMap.put(2,Arrays.asList(s1, s2, s3, s4)); 
		 Academy.studentMap.put(3, Arrays.asList(s1,s2, s3));
		 Academy.studentMap.put(4, Arrays.asList(s1, s2));
		 Academy.studentMap.put(5, Arrays.asList(s6, s7, s8, s9, s10));

		int max = 0;
		int c = 0;

		for (Map.Entry<Integer, List<Student>> obj : Academy.studentMap.entrySet()) {
			if (obj.getValue().size() > max) {
				max = obj.getValue().size();
				c = obj.getKey();

			}
		}
		for (Course ob : Academy.courseList) {
			if (ob.courseId == c) {
				System.out.println("Course Name = " + ob.course_name);
				System.out.println("Number Of Students = " + max);
			}
		}

	}

	public static void Ques3() {

		// find our loyal students, use LinkedHashMap in order to find out those first 3
		// students across courses who paid full fees.

		LinkedHashMap<Integer, Integer> l = new LinkedHashMap<>();
		LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>();
		for (Map.Entry<Integer, List<Transaction>> e : Academy.transactionMap.entrySet()) {
			List<Transaction> tr = e.getValue();
			for (Transaction t : tr) {
				if (l.containsKey(t.studId)) {
					l.put(t.studId, l.get(t.studId) + t.paidfees);
				} else {
					l.put(t.studId, t.paidfees);
				}
			}
		}

		for (Map.Entry<Integer, List<Transaction>> e : Academy.transactionMap.entrySet()) {
			List<Transaction> tr = e.getValue();
			for (Transaction t : tr) {
				Integer id = t.studId;
				for (Map.Entry<Integer, Integer> e1 : l.entrySet()) {
					Integer cfees = e1.getValue();
					if (e1.getKey() == id) {
						Integer cid = e.getKey();
						for (Course c : Academy.courseList) {
							if (c.courseId == cid) {
								if (c.courseFees == cfees) {
									for (Map.Entry<Integer, List<Student>> e2 : Academy.studentMap.entrySet()) {
										List<Student> st = e2.getValue();
										for (Student s : st) {
											if (s.getStudent_id() == id) {
												lhm.put(s.getStudent_id(), s.getstudent_name());
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		int i = 1;
		for (Map.Entry<Integer, String> e : lhm.entrySet()) {
			if (i <= 3) {
				System.out.println(e.getKey() + "  " + e.getValue());
				i++;
			} else
				break;

		}

	}

	public static void Ques4() {
		/*
		 * use TreeSet to store course details on fees from highest to lowest fees and
		 * printing the treemap output with course details.
		 */

		TreeSet<Course> t = new TreeSet<>(new Comparator<Course>() {
			@Override
			public int compare(Course o1, Course o2) {

				if (o1.courseFees < o2.courseFees)
					return 1;
				else if (o1.courseFees > o2.courseFees)
					return -1;
				else
					return 0;
			}
		});

		t.addAll(Academy.courseList);
		for (Course obj : t)
			System.out.println(obj);
	}

	public static void Ques5() {
		// show poor performing students (marks <40%) across all tests for a course id.

		System.out.println("List Of Poor Performing Students...");

		for (Map.Entry<Integer, List<TestResult>> e : Academy.test_map.entrySet()) {
			float total = 0;
			List<TestResult> t = e.getValue();
			Iterator<TestResult> i = t.iterator();
			while (i.hasNext()) {
				TestResult r = i.next();
				total += r.getMarks();

			}

			float per = total / 500 * 100;
			// System.out.println(per);

			if (per < 40) {
				int courseid = e.getKey();

				List<TestResult> test = e.getValue();
				Iterator<TestResult> i1 = test.iterator();

				while (i1.hasNext()) {
					int sid = i1.next().studentId;
					for (Map.Entry<Integer, List<Student>> s : Academy.studentMap.entrySet()) {
						List<Student> st = s.getValue();
						for (Student ss : st) {
							if (ss.getStudent_id() == sid) {
								System.out
								.println("Course Id :" + courseid + " Student Name : " + ss.getstudent_name());

							}
						}
					}
				}

			}
		}

	}

	public static void Ques6()
	{
		// add all student names in one place and print all unique student names

		Student s1 = new Student(101, "Hrishi", 7709932562L, "Hrishi@gmail.com");
		Student s2 = new Student(104, "Sameer", 7709932563L, "Sameer@gmail.com");
		Student s3 = new Student(103, "Rahul", 7709932564L, "Rahul@gmail.com");
		Student s4 = new Student(105, "Chetan", 7709932565L, "Chetan@gmail.com");
		Student s5 = new Student(102, "Aditya", 7709932566L, "Aditya@gmail.com");
		Student s6 = new Student(106, "Hrishi", 7709932567L, "hrishi@gmail.com");
		
		  Academy.studentMap.put(1, Arrays.asList(s5,s6)); 
		  Academy.studentMap.put(2, Arrays.asList(s4)); 
		  Academy.studentMap.put(3, Arrays.asList(s1));
		  Academy.studentMap.put(4, Arrays.asList(s3)); 
		  Academy.studentMap.put(5, Arrays.asList(s2));
		
		ArrayList<String> al = new ArrayList<>();
		Map<Integer, List<Student>> s = new HashMap<>(Academy.studentMap);
		for (Map.Entry<Integer, List<Student>> obj : s.entrySet()) {
			List<Student> st = obj.getValue();
			for (Student ss : st) {
				String name = ss.getstudent_name();

				if (!al.contains(name))
					al.add(name);
			}

		}
		System.out.println(al);
	}

	public static void Ques7() {
		/*
		 * create hashmap of student object, total marks from all tests for one course
		 * id sent in input and then print the response
		 */

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Course ID Whose Test Result You Want To See?");
		Integer courseid = sc.nextInt();// 1

		Integer total = 0;
		for (Map.Entry<Integer, List<TestResult>> e : Academy.test_map.entrySet()) {
			if (e.getKey().equals(courseid)) {
				List<TestResult> tr = e.getValue();
				for (TestResult t : tr) {
					total += t.marks;
				}
			}
		}
		System.out.println("Total Marks For All The Tests For Course Id : " + courseid + " ---> " + total);

	}

	public static void Ques8() {

		// show sorting options on course cname or startDate or subject or fees and in
		// response print all details of course

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Your Response For Sorting...");
		System.out.println("1)Course Name  2)Start Date  3)Subject  4)Fees");
		int n = sc.nextInt();

		switch (n) {
		case 1:
			Collections.sort(Academy.courseList, new Comparator<Course>() {

				@Override
				public int compare(Course o1, Course o2) {

					return o1.course_name.compareTo(o2.course_name);

				}

			});
			for (Course c : Academy.courseList)
				System.out.println(c);
			break;
		case 2:
			Collections.sort(Academy.courseList, new Comparator<Course>() {

				@Override
				public int compare(Course o1, Course o2) {

					if (o1.startDate.getYear() != o2.startDate.getYear())
						return o1.startDate.getYear() - o2.startDate.getYear();
					else if (o1.startDate.getMonth() != o2.startDate.getMonth())
						return o1.startDate.getMonth() - o2.startDate.getMonth();
					else
						return o1.startDate.getDay() - o2.startDate.getDay();
				}
			});
			for (Course c : Academy.courseList)
				System.out.println(c);
			break;
		case 3:
			Collections.sort(Academy.courseList, new Comparator<Course>() {

				@Override
				public int compare(Course o1, Course o2) {

					return o1.subject.compareTo(o2.subject);
				}
			});
			for (Course c : Academy.courseList)
				System.out.println(c);
			break;
		case 4:
			Collections.sort(Academy.courseList, new Comparator<Course>() {

				@Override
				public int compare(Course o1, Course o2) {

					return o1.courseFees - o2.courseFees;
				}

			});
			for (Course c : Academy.courseList)
				System.out.println(c);
			break;
		default:
			System.out.println("Invalid Input... Please Enter Correct Choice...");

		}
	}

	public static void Ques9() {
		// if stud is being added again on mobile no uniqueness to any course show error
		// that student already enrolled.

		Student s1 = new Student(101, "Hrishi", 7709932562L, "Hrishi@gmail.com");
		Student s2 = new Student(104, "Sameer", 7709932563L, "Sameer@gmail.com");
		Student s3 = new Student(103, "Rahul", 7709932564L, "Rahul@gmail.com");
		Student s4 = new Student(105, "Chetan", 7709932565L, "Chetan@gmail.com");
		Student s5 = new Student(102, "Hrishi", 7709932566L, "Hrishi@gmail.com");
		
		  Academy.studentMap.put(1, Arrays.asList(s5)); 
		  Academy.studentMap.put(2, Arrays.asList(s4)); 
		  Academy.studentMap.put(3, Arrays.asList(s1));
		  Academy.studentMap.put(4, Arrays.asList(s3)); 
		  Academy.studentMap.put(5, Arrays.asList(s2));
		
		
		
		boolean flag = false;
		HashMap<String, String> hm = new HashMap<>();
		try {
			for (Map.Entry<Integer, List<Student>> stud : Academy.studentMap.entrySet()) {
				List<Student> st = stud.getValue();
				for (Student s : st) {
					if (hm.containsKey(s.getstudent_name())) {
						String email = hm.get(s.getstudent_name());
						if (s.getEmail() == email) {
							System.out.println(s);
							flag = true;
							throw new DuplicateEntryException();
						}

					} else {
						hm.put(s.getstudent_name(), s.getEmail());
					}
				}
			}
		} catch (DuplicateEntryException e) {
			System.out.println(e.getMessage());
		}

		if (flag != true)
			System.out.println("No Duplicate Entry Found...");
	}

	public static void Ques10() {

		/*
		 * show student result for course id and test id sorted from topper to lowest
		 * marks. If student marks are equal sort on their names
		 */

		for (Map.Entry<Integer, List<TestResult>> e : Academy.test_map.entrySet()) {
			List<TestResult> tr = e.getValue();
			System.out.println("Result For Course Id : " + e.getKey());
			TreeSet<TestResult> tset = new TreeSet<>(new Comparator<TestResult>() {

				@Override
				public int compare(TestResult o1, TestResult o2) {

					if (o1.marks < o2.marks)
						return 1;
					else if (o1.marks > o2.marks)
						return -1;
					else {
						String str1 = "";
						String str2 = "";
						for (Map.Entry<Integer, List<Student>> e1 : Academy.studentMap.entrySet()) {
							List<Student> st = e1.getValue();
							for (Student s : st) {
								if (s.getStudent_id() == o1.studentId) {
									str1 = s.getstudent_name();
									for (Student s1 : st) {
										if (s1.getStudent_id() == o2.studentId) {

											str2 = s1.getstudent_name();
										}
									}
								}
							}
						}

						return str1.compareTo(str2);
					}
				}

			});

			tset.addAll(tr);

			for (TestResult t : tset) {
				for (Map.Entry<Integer, List<Student>> e1 : Academy.studentMap.entrySet()) {
					List<Student> s = e1.getValue();
					for (Student st : s) {
						if (st.getStudent_id() == t.studentId) {
							System.out.println("Student Name : " + st.getstudent_name() + "-->" + " Student Id : "
									+ t.studentId + "-->" + "Test Id : " + t.testid + "-->" + "Marks : " + t.marks);
						}
					}

				}

			}

		}
	}

	public static void Ques11()
	{
		/*Show one table which has course name , course start date and total students,
		total revenue till date, total left fees, total projected revenue, percentage collection till date*/
		
		Student s1 = new Student(101, "Hrishi", 7709932562L, "Hrishi@gmail.com");
		Student s2 = new Student(104, "Sameer", 7709932563L, "Sameer@gmail.com");
		Student s3 = new Student(103, "Rahul", 7709932564L, "Rahul@gmail.com");
		Student s4 = new Student(105, "Chetan", 7709932565L, "Chetan@gmail.com");
		Student s5 = new Student(102, "Aditya", 7709932566L, "Aditya@gmail.com");
		Student s6 = new Student(106, "A", 7709932562L, "A@gmail.com");
		Student s7 = new Student(107, "B", 7709932562L, "B@gmail.com");
		
		ArrayList<Student> al1 = new ArrayList<>();
		al1.add(s5);
		al1.add(s6);
		al1.add(s7);
		ArrayList<Student> al2 = new ArrayList<>();
		al2.add(s4);
		ArrayList<Student> al3 = new ArrayList<>();
		al3.add(s1);
		ArrayList<Student> al4 = new ArrayList<>();
		al4.add(s3);
		ArrayList<Student> al5 = new ArrayList<>();
		al5.add(s2);

		Academy.studentMap.put(1, al1);
		Academy.studentMap.put(2, al2);
		Academy.studentMap.put(3, al3);
		Academy.studentMap.put(4, al4);
		Academy.studentMap.put(5, al5);
		
		Transaction tr1 = new Transaction(5000, 102, new Date(2020, 05, 01));
		Transaction tr2 = new Transaction(5000, 102, new Date(2020, 06, 05));
		Transaction tr3 = new Transaction(10000, 105, new Date(2020, 05, 01));
		Transaction tr4 = new Transaction(10000, 105, new Date(2020, 06, 05));
		Transaction tr5 = new Transaction(5000, 101, new Date(2020, 05, 01));
		Transaction tr6 = new Transaction(5000, 101, new Date(2020, 06, 05));
		Transaction tr7 = new Transaction(2500, 103, new Date(2020, 05, 01));
		Transaction tr8 = new Transaction(2500, 103, new Date(2020, 06, 05));
		Transaction tr9 = new Transaction(25000, 104, new Date(2020, 05, 01));
		Transaction tr10 = new Transaction(25000, 104, new Date(2020, 06, 05));
		Transaction tr11 = new Transaction(1000, 106, new Date(2020, 06, 05));
		Transaction tr12 = new Transaction(2000, 107, new Date(2020, 06, 05));

		ArrayList<Transaction> trans1 = new ArrayList<>();
		trans1.add(tr1);
		trans1.add(tr2);
		trans1.add(tr11);
		trans1.add(tr12);
		ArrayList<Transaction> trans2 = new ArrayList<>();
		trans2.add(tr3);
		trans2.add(tr4);
		ArrayList<Transaction> trans3 = new ArrayList<>();
		trans3.add(tr5);
		trans3.add(tr6);
		ArrayList<Transaction> trans4 = new ArrayList<>();
		trans4.add(tr7);
		trans4.add(tr8);
		ArrayList<Transaction> trans5 = new ArrayList<>();
		trans5.add(tr9);
		trans5.add(tr10);

		Academy.transactionMap.put(1, trans1); // Ques15
		Academy.transactionMap.put(2, trans2);
		Academy.transactionMap.put(3, trans3);
		Academy.transactionMap.put(4, trans4);
		Academy.transactionMap.put(5, trans5);

		
		for(Course c:Academy.courseList)
		{
			String coursename=c.course_name;
			Date coursedate=c.startDate;
			System.out.println("Number Of Students For "+coursename+" are ...");
			for(Map.Entry<Integer, List<Student>> e:Academy.studentMap.entrySet())
			{
				int count=0;
				List<Student> st=e.getValue();
				for(Student s:st)
				{
					count++;
				}
				if(c.courseId == e.getKey())
				{
					System.out.println(e.getValue());
					for(Map.Entry<Integer, List<Transaction>> e1:Academy.transactionMap.entrySet())
					{
						if(c.courseId == e1.getKey())
						{
							List<Transaction> tr=e1.getValue();
							float total_revenue=0;
							float total_fees_left=0;
							float projected_revenue=0;
							for(Transaction t:tr)
							{
								projected_revenue=count*c.courseFees;
								total_revenue=total_revenue+t.paidfees;
								total_fees_left=projected_revenue-total_revenue;
							}
							System.out.println("Total Revenue Till Date : "+total_revenue);
							System.out.println("Total Fees Left : "+total_fees_left);
							System.out.println("Total Projected Revenue : "+projected_revenue);
							System.out.println("Percentage Collection Till Date : "+(total_revenue/projected_revenue)*(100)+" % ");
							System.out.println();
						}
					}
				}
			}
		}
		
		

	}
	public static void Ques13() {
		/*
		 * move student from one course to another. Delete his past attendance all
		 * records, test series records but transaction record maintain it . Show it
		 * against new course id
		 */
		
		Course c1 = new Course(1, "Java", new Date(2020, 05, 01), "Computer", 10000, "2 months");// 11
		Course c2 = new Course(2, "Adv java", new Date(2020, 05, 02), "IT", 20000, "3 months");// 12
		Course c3 = new Course(3, "Python", new Date(2020, 05, 03), "Computer", 15000, "2 months");// 13
		Course c4 = new Course(4, "Networking", new Date(2020, 05, 04), "IT", 5000, "4 months");// 14
		Course c5 = new Course(5, "Full Stack Developer", new Date(2020, 05, 05), "ENTC", 50000, "6 months");// 15
		Course c6 = new Course(6, "Embedded Developer", new Date(2020, 05, 06), "ENTC", 50000, "6 months");// For Ques-13 

		Academy.courseList.add(c1);
		Academy.courseList.add(c2);
		Academy.courseList.add(c3);
		Academy.courseList.add(c4);
		Academy.courseList.add(c5);
		Academy.courseList.add(c6); //For Ques-13

		
		Student s1 = new Student(101, "Hrishi", 7709932562L, "Hrishi@gmail.com");
		Student s2 = new Student(104, "Sameer", 7709932563L, "Sameer@gmail.com");
		Student s3 = new Student(103, "Rahul", 7709932564L, "Rahul@gmail.com");
		Student s4 = new Student(105, "Chetan", 7709932565L, "Chetan@gmail.com");
		Student s5 = new Student(102, "Aditya", 7709932566L, "Aditya@gmail.com");
		
		ArrayList<Student> al1 = new ArrayList<>();
		al1.add(s5);
		ArrayList<Student> al2 = new ArrayList<>();
		al2.add(s4);
		ArrayList<Student> al3 = new ArrayList<>();
		al3.add(s1);
		ArrayList<Student> al4 = new ArrayList<>();
		al4.add(s3);
		ArrayList<Student> al5 = new ArrayList<>();
		al5.add(s2);

		Academy.studentMap.put(1, al1);
		Academy.studentMap.put(2, al2);
		Academy.studentMap.put(3, al3);
		Academy.studentMap.put(4, al4);
		Academy.studentMap.put(5, al5);
		
		Attendance a1 = new Attendance(11, 102, "P", new Date(2020, 07, 03));
		Attendance a2 = new Attendance(12, 105, "A", new Date(2020, 07, 04));
		Attendance a3 = new Attendance(13, 101, "P", new Date(2020, 07, 05));
		Attendance a4 = new Attendance(14, 103, "P", new Date(2020, 07, 06));
		Attendance a5 = new Attendance(15, 104, "A", new Date(2020, 07, 07));
		
		ArrayList<Attendance> att1 = new ArrayList<>();
		att1.add(a5);
		ArrayList<Attendance> att2 = new ArrayList<>();
		att1.add(a4);
		ArrayList<Attendance> att3 = new ArrayList<>();
		att1.add(a1);
		ArrayList<Attendance> att4 = new ArrayList<>();
		att1.add(a3);
		ArrayList<Attendance> att5 = new ArrayList<>();
		att1.add(a2);

		Academy.attendanceMap.put(1, att1);
		Academy.attendanceMap.put(2, att2);
		Academy.attendanceMap.put(3, att3);
		Academy.attendanceMap.put(4, att4);
		Academy.attendanceMap.put(5, att5);
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student Id :");
		Integer studentid = sc.nextInt();

		ConcurrentHashMap<Integer, List<Student>> chm=new ConcurrentHashMap<>(Academy.studentMap);
		Iterator<Map.Entry<Integer, List<Student>>> itr = chm.entrySet().iterator();
		System.out.println("Map After Moving A Student From One Course To Another...");
		while(itr.hasNext())
		{
			List<Student> st=itr.next().getValue();
			for(int j=0;j<st.size();j++)
			{
				if(st.get(j).getStudent_id() == studentid)
				{
					ArrayList<Student> stud=new ArrayList<Student>();
					stud.add(st.get(j));
					Academy.studentMap.put(6, stud);
					//System.out.println(Academy.studentMap);
					st.remove(j);
					System.out.println(Academy.studentMap);

				}
			}
		}


		Iterator<Map.Entry<Integer, List<Attendance>>> i1 = Academy.attendanceMap.entrySet().iterator();
		while (i1.hasNext()) {
			List<Attendance> att = i1.next().getValue();
			Iterator<Attendance> aa = att.iterator();
			while (aa.hasNext()) {
				Attendance a = aa.next();
				if (a.studId == studentid) {
					aa.remove();
				}
			}
		}
		System.out.println("Map After Deleting Attendance Records...");
		System.out.println(Academy.attendanceMap);

		Iterator<Map.Entry<Integer, List<TestResult>>> i2 = Academy.test_map.entrySet().iterator();
		while (i2.hasNext()) {
			List<TestResult> t = i2.next().getValue();
			Iterator<TestResult> te = t.iterator();
			while (te.hasNext()) {
				TestResult tt = te.next();
				if (tt.studentId == studentid) {
					te.remove();
					break;
				}
			}
		}
		System.out.println("Map After Deleting Test Series Records...");
		System.out.println(Academy.test_map);
		 
	}

	public static void Ques14() {
		/*
		 * Show the students from a course who have not paid any fees till date which
		 * takes course id as input and shows all students registered for this course.
		 */

		Transaction tr1 = new Transaction(000, 102, new Date(2020, 05, 01));
		Transaction tr2 = new Transaction(000, 105, new Date(2020, 05, 01));
		Transaction tr3 = new Transaction(5000, 101, new Date(2020, 05, 01));
		Transaction tr4 = new Transaction(5000, 103, new Date(2020, 05, 01));
		Transaction tr5 = new Transaction(5000, 104, new Date(2020, 05, 01));
		
		ArrayList<Transaction> trans1 = new ArrayList<>();
		trans1.add(tr1);
		
		ArrayList<Transaction> trans2 = new ArrayList<>();
		trans2.add(tr2);
		
		ArrayList<Transaction> trans3 = new ArrayList<>();
		trans3.add(tr3);
		
		ArrayList<Transaction> trans4 = new ArrayList<>();
		trans4.add(tr4);
		
		ArrayList<Transaction> trans5 = new ArrayList<>();
		trans5.add(tr5);
		
		
		Academy.transactionMap.put(1, trans1); 
		Academy.transactionMap.put(2, trans2);
		Academy.transactionMap.put(3, trans3);
		Academy.transactionMap.put(4, trans4);
		Academy.transactionMap.put(5, trans5);
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Course Id : ");
		Integer courseid = sc.nextInt();
		System.out.println("Students Registered For This Course...");
		for (Map.Entry<Integer, List<TestResult>> e : Academy.test_map.entrySet()) {
			if (e.getKey() == courseid) {
				List<TestResult> t = e.getValue();
				for (TestResult tt : t) {
					Integer sid = tt.studentId;
					for (Map.Entry<Integer, List<Transaction>> e1 : Academy.transactionMap.entrySet()) {
						List<Transaction> tr = e1.getValue();
						for (Transaction trans : tr) {
							if (trans.studId == sid) {
								for (Map.Entry<Integer, List<Student>> e2 : Academy.studentMap.entrySet()) {
									List<Student> st = e2.getValue();
									for (Student s : st) {

										if (s.getStudent_id() == sid) {
											if (trans.paidfees == 0) {
												System.out.println("Students Who Has Not Paid Any Fees...");
												System.out.println("Student Name : " + s.getstudent_name() + "-->"
														+ "Student ID : " + s.getStudent_id());
											} else {
												System.out.println("Student Name : " + s.getstudent_name() + "-->"
														+ "Student ID : " + s.getStudent_id());
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

	}

	public static void Ques15() {
		// to delete a transaction. Note transaction all records across all beans should
		// be deleted.

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Student Id Whose Transaction Records You Wanted To Delete?");
		Integer sid = sc.nextInt();

		Iterator<Map.Entry<Integer, List<Transaction>>> i = Academy.transactionMap.entrySet().iterator();
		while (i.hasNext()) {
			List<Transaction> tr = i.next().getValue();
			ListIterator<Transaction> i1 = tr.listIterator();
			while (i1.hasNext()) {
				Integer id = i1.next().studId;
				if (id == sid) {
					i1.remove();
				}

			}
		}

		System.out.println(Academy.transactionMap);
	}

	public static void main(String[] args) {

		
		// java=10000, advjava=20000,
		// python=15000,networking=5000,fSD=50000
		Course c1 = new Course(1, "Java", new Date(2020, 05, 01), "Computer", 10000, "2 months");// 11
		Course c2 = new Course(2, "Adv java", new Date(2020, 05, 02), "IT", 20000, "3 months");// 12
		Course c3 = new Course(3, "Python", new Date(2020, 05, 03), "Computer", 15000, "2 months");// 13
		Course c4 = new Course(4, "Networking", new Date(2020, 05, 04), "IT", 5000, "4 months");// 14
		Course c5 = new Course(5, "Full Stack Developer", new Date(2020, 05, 05), "ENTC", 50000, "6 months");// 15
	

		Academy.courseList.add(c1);
		Academy.courseList.add(c2);
		Academy.courseList.add(c3);
		Academy.courseList.add(c4);
		Academy.courseList.add(c5);

		
		Student s1 = new Student(101, "Hrishi", 7709932562L, "Hrishi@gmail.com");
		Student s2 = new Student(104, "Sameer", 7709932563L, "Sameer@gmail.com");
		Student s3 = new Student(103, "Rahul", 7709932564L, "Rahul@gmail.com");
		Student s4 = new Student(105, "Chetan", 7709932565L, "Chetan@gmail.com");
		Student s5 = new Student(102, "Aditya", 7709932566L, "Aditya@gmail.com");
		
		ArrayList<Student> al1 = new ArrayList<>();
		al1.add(s5);
		ArrayList<Student> al2 = new ArrayList<>();
		al2.add(s4);
		ArrayList<Student> al3 = new ArrayList<>();
		al3.add(s1);
		ArrayList<Student> al4 = new ArrayList<>();
		al4.add(s3);
		ArrayList<Student> al5 = new ArrayList<>();
		al5.add(s2);

		Academy.studentMap.put(1, al1);
		Academy.studentMap.put(2, al2);
		Academy.studentMap.put(3, al3);
		Academy.studentMap.put(4, al4);
		Academy.studentMap.put(5, al5);

		
		 /* Academy.studentMap.put(1, Arrays.asList(s5)); 
		  Academy.studentMap.put(2, Arrays.asList(s4)); 
		  Academy.studentMap.put(3, Arrays.asList(s1));
		  Academy.studentMap.put(4, Arrays.asList(s3)); 
		  Academy.studentMap.put(5, Arrays.asList(s2));*/
		 

		Attendance a1 = new Attendance(11, 102, "P", new Date(2020, 07, 03));
		Attendance a2 = new Attendance(12, 105, "A", new Date(2020, 07, 04));
		Attendance a3 = new Attendance(13, 101, "P", new Date(2020, 07, 05));
		Attendance a4 = new Attendance(14, 103, "P", new Date(2020, 07, 06));
		Attendance a5 = new Attendance(15, 104, "A", new Date(2020, 07, 07));

		ArrayList<Attendance> att1 = new ArrayList<>();
		att1.add(a5);
		ArrayList<Attendance> att2 = new ArrayList<>();
		att1.add(a4);
		ArrayList<Attendance> att3 = new ArrayList<>();
		att1.add(a1);
		ArrayList<Attendance> att4 = new ArrayList<>();
		att1.add(a3);
		ArrayList<Attendance> att5 = new ArrayList<>();
		att1.add(a2);

		Academy.attendanceMap.put(1, att1);
		Academy.attendanceMap.put(2, att2);
		Academy.attendanceMap.put(3, att3);
		Academy.attendanceMap.put(4, att4);
		Academy.attendanceMap.put(5, att5);

		
		  /*Academy.attendanceMap.put(1, Arrays.asList(a5)); 
		  Academy.attendanceMap.put(2, Arrays.asList(a4)); 
		  Academy.attendanceMap.put(3, Arrays.asList(a1));
		  Academy.attendanceMap.put(4, Arrays.asList(a3)); 
		  Academy.attendanceMap.put(5, Arrays.asList(a2));*/
		 
		 

		// Java-1(10)
		TestResult t1 = new TestResult(new Date(2020, 07, 01), 10, 101, 90, 100);
		TestResult t2 = new TestResult(new Date(2020, 07, 01), 10, 104, 91, 100);
		TestResult t3 = new TestResult(new Date(2020, 07, 01), 10, 103, 90, 100);
		TestResult t4 = new TestResult(new Date(2020, 07, 01), 10, 105, 93, 100);
		TestResult t5 = new TestResult(new Date(2020, 07, 01), 10, 102, 94, 100);
		// Adv Java-2(20)
		TestResult t6 = new TestResult(new Date(2020, 07, 01), 20, 101, 80, 100);
		TestResult t7 = new TestResult(new Date(2020, 07, 01), 20, 104, 80, 100);
		TestResult t8 = new TestResult(new Date(2020, 07, 01), 20, 103, 80, 100);
		TestResult t9 = new TestResult(new Date(2020, 07, 01), 20, 105, 83, 100);
		TestResult t10 = new TestResult(new Date(2020, 07, 01), 20, 102, 84, 100);
		// Python(30)
		TestResult t11 = new TestResult(new Date(2020, 07, 01), 30, 101, 70, 100);
		TestResult t12 = new TestResult(new Date(2020, 07, 01), 30, 104, 71, 100);
		TestResult t13 = new TestResult(new Date(2020, 07, 01), 30, 103, 72, 100);
		TestResult t14 = new TestResult(new Date(2020, 07, 01), 30, 105, 73, 100);
		TestResult t15 = new TestResult(new Date(2020, 07, 01), 30, 102, 74, 100);
		// Networking(40)
		TestResult t16 = new TestResult(new Date(2020, 07, 01), 40, 101, 63, 100);
		TestResult t17 = new TestResult(new Date(2020, 07, 01), 40, 104, 60, 100);
		TestResult t18 = new TestResult(new Date(2020, 07, 01), 40, 103, 64, 100);
		TestResult t19 = new TestResult(new Date(2020, 07, 01), 40, 105, 61, 100);
		TestResult t20 = new TestResult(new Date(2020, 07, 01), 40, 102, 65, 100);
		// FSD(50)
		TestResult t21 = new TestResult(new Date(2020, 07, 01), 50, 101, 40, 100);
		TestResult t22 = new TestResult(new Date(2020, 07, 01), 50, 104, 39, 100);
		TestResult t23 = new TestResult(new Date(2020, 07, 01), 50, 103, 40, 100);
		TestResult t24 = new TestResult(new Date(2020, 07, 01), 50, 105, 35, 100);
		TestResult t25 = new TestResult(new Date(2020, 07, 01), 50, 102, 38, 100);

		ArrayList<TestResult> te1 = new ArrayList<>();
		te1.add(t1);
		te1.add(t2);
		te1.add(t3);
		te1.add(t4);
		te1.add(t5);
		ArrayList<TestResult> te2 = new ArrayList<>();
		te2.add(t6);
		te2.add(t7);
		te2.add(t8);
		te2.add(t9);
		te2.add(t10);
		ArrayList<TestResult> te3 = new ArrayList<>();
		te3.add(t11);
		te3.add(t12);
		te3.add(t13);
		te3.add(t14);
		te3.add(t15);
		ArrayList<TestResult> te4 = new ArrayList<>();
		te4.add(t16);
		te4.add(t17);
		te4.add(t18);
		te4.add(t19);
		te4.add(t20);
		ArrayList<TestResult> te5 = new ArrayList<>();
		te5.add(t21);
		te5.add(t22);
		te5.add(t23);
		te5.add(t24);
		te5.add(t25);

		Academy.test_map.put(1, te1);
		Academy.test_map.put(2, te2);
		Academy.test_map.put(3, te3);
		Academy.test_map.put(4, te4);
		Academy.test_map.put(5, te5);

		
		 /* Academy.test_map.put(1, Arrays.asList(t1, t2, t3, t4, t5));
		  Academy.test_map.put(2, Arrays.asList(t6, t7, t8, t9, t10));
		  Academy.test_map.put(3, Arrays.asList(t11, t12, t13, t14, t15));
		  Academy.test_map.put(4, Arrays.asList(t16, t17, t18, t19, t20));
		  Academy.test_map.put(5, Arrays.asList(t21, t22, t23, t24, t25));*/
		 

		// java=10000, advjava=20000,
		// python=10000,networking=5000,fSD=50000
		Transaction tr1 = new Transaction(5000, 102, new Date(2020, 05, 01));
		Transaction tr2 = new Transaction(5000, 102, new Date(2020, 06, 05));
		Transaction tr3 = new Transaction(10000, 105, new Date(2020, 05, 01));
		Transaction tr4 = new Transaction(10000, 105, new Date(2020, 06, 05));
		Transaction tr5 = new Transaction(5000, 101, new Date(2020, 05, 01));
		Transaction tr6 = new Transaction(5000, 101, new Date(2020, 06, 05));
		Transaction tr7 = new Transaction(2500, 103, new Date(2020, 05, 01));
		Transaction tr8 = new Transaction(2500, 103, new Date(2020, 06, 05));
		Transaction tr9 = new Transaction(25000, 104, new Date(2020, 05, 01));
		Transaction tr10 = new Transaction(25000, 104, new Date(2020, 06, 05));
		

		ArrayList<Transaction> trans1 = new ArrayList<>();
		trans1.add(tr1);
		trans1.add(tr2);
		ArrayList<Transaction> trans2 = new ArrayList<>();
		trans2.add(tr3);
		trans2.add(tr4);
		ArrayList<Transaction> trans3 = new ArrayList<>();
		trans3.add(tr5);
		trans3.add(tr6);
		ArrayList<Transaction> trans4 = new ArrayList<>();
		trans4.add(tr7);
		trans4.add(tr8);
		ArrayList<Transaction> trans5 = new ArrayList<>();
		trans5.add(tr9);
		trans5.add(tr10);

		Academy.transactionMap.put(1, trans1); // Ques15
		Academy.transactionMap.put(2, trans2);
		Academy.transactionMap.put(3, trans3);
		Academy.transactionMap.put(4, trans4);
		Academy.transactionMap.put(5, trans5);

		/*
		 * Academy.transactionMap.put(1, Arrays.asList(tr1,tr2));
		 * Academy.transactionMap.put(2, Arrays.asList(tr3,tr4));
		 * Academy.transactionMap.put(3, Arrays.asList(tr5,tr6));
		 * Academy.transactionMap.put(4, Arrays.asList(tr7,tr8));
		 * Academy.transactionMap.put(5, Arrays.asList(tr9,tr10));
		 */

		

		
		

		//Ques1();
		//Ques2();
		//Ques3();
		//Ques4();
		//Ques5();
		//Ques6();
		//Ques7();
		//Ques8();
		//Ques9();
		//Ques10();
		//Ques11();
		//Ques13();
		//Ques14();
		//Ques15();

	}

}

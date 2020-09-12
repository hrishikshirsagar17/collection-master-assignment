package master_assignment.bean;

import java.util.Comparator;
import java.util.Date;

public class TestResult implements Comparator<TestResult>{
	public Date testdate;
	public int testid;
	public int studentId;
	public int marks;
	public int out_of_marks;

	public TestResult(Date testdate, int testid, int Test_studentId, int marks, int out_of_marks) {

		this.testdate = testdate;
		this.testid = testid;
		this.studentId = Test_studentId;
		this.marks = marks;
		this.out_of_marks = out_of_marks;
	}

	public Date getTestdate() {
		return testdate;
	}


	public void setTestdate(Date testdate) {
		this.testdate = testdate;
	}


	public int getTestid() {
		return testid;
	}


	public void setTestid(int testid) {
		this.testid = testid;
	}


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public int getMarks() {
		return marks;
	}


	public void setMarks(int marks) {
		this.marks = marks;
	}


	public int getOut_of_marks() {
		return out_of_marks;
	}


	public void setOut_of_marks(int out_of_marks) {
		this.out_of_marks = out_of_marks;
	}


	public String toString() {
		return ("test date:  " + this.testdate + " " + "test id:  " + this.testid + " " + "test Test_studentId: "
				+ this.studentId + " " + "test marks: " + this.marks + " " + "test out of marks: "
				+ this.out_of_marks + "\n");

	}

	@Override
	public int compare(TestResult o1, TestResult o2) {
		
		return o2.marks-o1.marks;
	}

}

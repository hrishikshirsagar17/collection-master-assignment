package master_assignment.bean;

public class Student {
	private int studentId;
	private String student_name;
	private long phone_number;
	private String email;

	public Student(int Student_id, String student_name, long phone_number, String email) {
		this.setStudent_id(Student_id);
		this.setstudent_name(student_name);
		this.setphone_number(phone_number);
		this.setEmail(email);
	}

	public int getStudent_id() {
		return studentId;
	}

	public void setStudent_id(int Student_id) {
		this.studentId = Student_id;
	}

	public String getstudent_name() {
		return student_name;
	}

	public void setstudent_name(String student_name) {
		this.student_name = student_name;
	}

	public long getphone_number() {
		return phone_number;
	}

	public void setphone_number(long phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return ("student id:  " + this.getStudent_id() + "  " + "Student name:  " + this.getstudent_name() + "  "
				+ "phone no: " + this.getphone_number() + "  " + "email: " + this.getEmail() + "\n");

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (phone_number ^ (phone_number >>> 32));
		result = prime * result + studentId;
		result = prime * result + ((student_name == null) ? 0 : student_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (phone_number != other.phone_number)
			return false;
		if (studentId != other.studentId)
			return false;
		if (student_name == null) {
			if (other.student_name != null)
				return false;
		} else if (!student_name.equals(other.student_name))
			return false;
		return true;
	}
	
	

}

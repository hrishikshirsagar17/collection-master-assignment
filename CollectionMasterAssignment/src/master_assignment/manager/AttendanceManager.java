package master_assignment.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import master_assignment.bean.Academy;
import master_assignment.bean.Attendance;

public class AttendanceManager {
	
public static void addAttendance(int courseId) {
		
		List<Attendance> attendancelist = Academy.attendanceMap.get(courseId);
		 Attendance a1=new Attendance(111, 101, "p", new Date(4/10/2020));
			Attendance a2=new Attendance(112, 102, "a", new Date(8/10/2020));
			Attendance a3=new Attendance(113, 105, "p", new Date(9/10/2020));
			Attendance a4=new Attendance(114, 106, "p", new Date(10/10/2020));
			Attendance a5=new Attendance(115, 103, "a", new Date(11/10/2020));
			
		if(attendancelist == null) {
			attendancelist = new ArrayList<>();
			Academy.attendanceMap.put(courseId, attendancelist);
		}
		attendancelist.add(a1);
		attendancelist.add(a2);
		attendancelist.add(a3);
		attendancelist.add(a4);
		attendancelist.add(a5);
	}
	
	public static List<Attendance> getAllAttendance(long courseId) {
		
		return Academy.attendanceMap.get(courseId);
	}


}

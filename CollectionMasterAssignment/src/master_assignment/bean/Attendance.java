package master_assignment.bean;

import java.util.Date;

public class Attendance {
	public int att_sr_no;
	public int studId;
	public String att_status;
	public Date att_date;
	public Attendance(int att_sr_no, int att_sid, String att_status, Date att_date) {
		this.att_sr_no = att_sr_no;
		this.studId = att_sid;
		this.att_status = att_status;
		this.att_date = att_date;
	}
	
	public int getAtt_sr_no() {
		return att_sr_no;
	}


	public void setAtt_sr_no(int att_sr_no) {
		this.att_sr_no = att_sr_no;
	}


	public int getStudId() {
		return studId;
	}


	public void setStudId(int studId) {
		this.studId = studId;
	}


	public String getAtt_status() {
		return att_status;
	}


	public void setAtt_status(String att_status) {
		this.att_status = att_status;
	}


	public Date getAtt_date() {
		return att_date;
	}


	public void setAtt_date(Date att_date) {
		this.att_date = att_date;
	}


	public String toString()
	{
		return("attendance srno:  "+this.att_sr_no+" "+"attendance sid:  "+this.studId+" "+"attendance status: "
	+this.att_status+" "+"attendance date: "+this.att_date+"\n");
		
	}
	
	
}

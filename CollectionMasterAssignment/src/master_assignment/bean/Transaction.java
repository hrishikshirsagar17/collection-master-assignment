package master_assignment.bean;

import java.util.Date;

public class Transaction {
	public int paidfees;
	public int studId;
	public Date trans_date;

	public Transaction(int paidfees, int trans_studentId, Date trans_date) {
		this.paidfees = paidfees;
		this.studId = trans_studentId;
		this.trans_date = trans_date;

	}

	public String toString() {
		return ("paid fees:  " + this.paidfees + " " + "transaction sid:  " + this.studId + " "
				+ "transaction date: " + this.trans_date + "\n");

	}

}

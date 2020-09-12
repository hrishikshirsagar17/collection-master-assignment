package master_assignment.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import master_assignment.bean.Academy;
import master_assignment.bean.Transaction;

public class TransactionManager {

	public static void addTransaction(int courseId) {

		List<Transaction> transactionlist = Academy.transactionMap.get(courseId);
		Transaction t1 = new Transaction(10000, 101, new Date(3 / 10 / 2017));
		Transaction t2 = new Transaction(5000, 102, new Date(4 / 10 / 2017));
		Transaction t3 = new Transaction(15000, 101, new Date(5 / 10 / 2017));
		Transaction t4 = new Transaction(20000, 103, new Date(21 / 10 / 2017));
		Transaction t5 = new Transaction(10000, 104, new Date(22 / 10 / 2017));
		if (transactionlist == null) {
			transactionlist = new ArrayList<>();
			Academy.transactionMap.put(courseId, transactionlist);
		}
		transactionlist.add(t1);
		transactionlist.add(t2);
		transactionlist.add(t3);
		transactionlist.add(t4);
		transactionlist.add(t5);
	}

	public static List<Transaction> getAllTransaction(long courseId) {

		return Academy.transactionMap.get(courseId);
	}

}

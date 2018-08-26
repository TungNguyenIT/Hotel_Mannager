package com.nvt.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.nvt.common.IConfiguration;
import com.nvt.entity.Customer;
import com.nvt.entity.Room;
import com.nvt.entity.Transaction;
import com.nvt.imodel.ITransaction;

public class TransactionDAO implements ITransaction {
	// SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	public boolean rentRoom(List<Transaction> lstTransaction, int roomNumber,
			List<Room> lstRoom, Customer customer, Transaction transaction) {
		boolean flag = false;
		for (int i = 0; i < lstRoom.size(); i++) {
			if (lstRoom.get(i).getRoomNumber() == roomNumber) {
				lstRoom.get(i).setRoomType(IConfiguration.STATUS_ROOM_BUSY);
				lstRoom.get(i).setCustomer(customer);
				transaction.setCustomer(customer);
				transaction.setRoom(lstRoom.get(i));

				lstTransaction.add(transaction);

				flag = true;

			}
		}
		return flag;
	}

	public boolean payRoom(List<Transaction> lstTransactions, int transactionID) {
		boolean flag = false;
		for (Transaction transaction : lstTransactions) {

			if (transaction.getId() == transactionID) {
				SimpleDateFormat format = new SimpleDateFormat(
						"HH:mm:ss dd/MM/yyyy");
				Date date = new Date();
				Date d1 = null;
				Date d2 = null;
				try {
					d1 = format.parse(transaction.getTimeIn());
					d2 = format.parse(transaction.getTimeOut());

					long timee = d2.getTime() - d1.getTime();
					long second = timee / 1000 % 60;
					long minute = timee / (60 * 1000) % 60;
					long hour = timee / (60 * 60 * 1000) % 24;
					long day = timee / (24 * 60 * 60 * 1000);
					System.out.println("=====Time rent: ====");
					System.out.print(day + " day, ");
					System.out.print(hour + " hour, ");
					System.out.print(minute + " minute, ");
					System.out.print(second + " second.");
					System.out.println("\tTotal monney: ");
					if (day < 1) {
						if (hour >= 1) {
							System.out.println((hour * transaction.getRoom()
									.getPrice()) / 24 + "$");
						} else {
							System.out.println(10);
						}
					} else {
						System.out.println(day
								* transaction.getRoom().getPrice() + "$");
					}
				} catch (Exception e) {
					System.out.println(e);
				}

				transaction.getRoom().setStatus(
						IConfiguration.STATUS_ROOM_EMPTY);
				transaction.setCustomer(null);

				flag = true;
			}
		}
		return flag;
	}
}

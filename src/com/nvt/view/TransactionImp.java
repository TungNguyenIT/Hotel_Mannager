package com.nvt.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.nvt.common.IConfiguration;
import com.nvt.entity.Customer;
import com.nvt.entity.Room;
import com.nvt.entity.Transaction;
import com.nvt.iview.ITransaction;

public class TransactionImp implements ITransaction {
	InputData input = new InputData();
	CustomerImp customerImp = new CustomerImp();
	RoomImp roomImp = new RoomImp();

	public int rentRoom(List<Room> lstRoom, Customer customer,
			Transaction transaction) {
		int roomNumber = 0;
		int check = 0;
		roomNumber = input.enterInterger("Enter room number: ");
		for (Room room : lstRoom) {
			if (room.getRoomNumber() == roomNumber
					&& room.getStatus() == IConfiguration.STATUS_ROOM_EMPTY) {
				SimpleDateFormat format = new SimpleDateFormat(
						"HH:mm:ss dd/MM/yyyy");
				Date date = new Date();
				String showTimeIn = format.format(date.getTime());
				transaction.setTimeIn(showTimeIn);
				transaction.setId(input
						.enterInterger("Enter number transaction"));
				System.out.println("Enter information of customer.");
				customerImp.addCustomer(customer);
				check++;
				return roomNumber;
			}
		}
		if (check == 0) {
			System.out.println("Room do not exist or rented.");
		}

		return 0;
	}

	public int payRoom(List<Transaction> lstTransactions) {
		int transactionID = 0;
		int check = 0;

		transactionID = input.enterInterger("Enter transaction id: ");
		for (Transaction transaction : lstTransactions) {
			if (transaction.getId() == transactionID) {
				check++;
				showTransaction(transaction);
				SimpleDateFormat format = new SimpleDateFormat(
						"HH:mm:ss dd/MM/yyyy");
				Date date = new Date();
				String dateOut = format.format(date.getTime());
				transaction.setTimeOut(dateOut);
				String dateIn = transaction.getTimeIn();
				// String dateOut = transaction.getTimeOut();

				return transactionID;
			}
		}
		if (check == 0) {
			System.out.println("Room do not exist or empty");
		}
		return transactionID;
	}

	public void showTransaction(Transaction transaction) {
		System.out.println("==Transaction ID");
		System.out.println("Transaction ID: " + transaction.getId());
		System.out.println("======Customer======");
		System.out.println("Full name : "
				+ transaction.getCustomer().getFullName());
		System.out.println("Age: " + transaction.getCustomer().getAge());
		System.out.println("City: "
				+ transaction.getCustomer().getAddress().getCity());
		System.out.println("====Room info====");
		System.out.println("Room number: "
				+ transaction.getRoom().getRoomNumber());
		System.out.println("Room type: " + transaction.getRoom().getRoomType());
		System.out.println("Price " + transaction.getRoom().getPrice());
		System.out.println("Time In : " + transaction.getTimeIn());

	}

	public void showListTransaction(List<Transaction> lstTransaction) {
		for (Transaction transaction : lstTransaction) {
			showTransaction(transaction);
		}
	}

}

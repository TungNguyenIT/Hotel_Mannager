package com.nvt.imodel;

import java.util.List;

import com.nvt.entity.Customer;
import com.nvt.entity.Room;
import com.nvt.entity.Transaction;

public interface ITransaction {
	public boolean rentRoom(List<Transaction> lstTransaction, int roomNumber,
			List<Room> lstRoom, Customer customer, Transaction transaction);

	public boolean payRoom(List<Transaction> lstTransactions, int transactionID);
}

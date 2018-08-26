package com.nvt.iview;

import java.util.List;

import com.nvt.entity.Customer;
import com.nvt.entity.Room;
import com.nvt.entity.Transaction;

public interface ITransaction {
	public int rentRoom(List<Room> lstRoom, Customer customer,
			Transaction transaction);

	public int payRoom(List<Transaction> lstTransactions);

	public void showTransaction(Transaction transaction);

	public void showListTransaction(List<Transaction> lstTransaction);
}

package com.nvt.iview;

import java.util.List;

import com.nvt.entity.Customer;

public interface ICustomer {
	public abstract Customer addCustomer(Customer customer);

	public abstract Customer editCustomer(List<Customer> lstCustomer);

	public abstract int deleteCustomer();

	public abstract void showCustomer(Customer customer);

	public abstract void showListCustomer(List<Customer> lstCustomer);
}

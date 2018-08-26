package com.nvt.imodel;

import java.util.List;

import com.nvt.entity.Customer;

public interface ICustomer {
	public abstract boolean addCustomer(List<Customer> lstCustomer,
			Customer customer);

	public abstract boolean editCustomer(List<Customer> lstCustomer,
			Customer customer);

	public abstract boolean deleteCustomer(List<Customer> lstCustomer,
			int idCustomer);
}

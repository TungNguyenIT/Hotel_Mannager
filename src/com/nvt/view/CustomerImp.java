package com.nvt.view;

import java.util.List;

import com.nvt.entity.Address;
import com.nvt.entity.Customer;
import com.nvt.iview.ICustomer;

public class CustomerImp implements ICustomer {
	InputData input = new InputData();

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Address address = new Address();
		customer.setId(input.enterInterger("Enter ID: "));
		customer.setFullName(input.enterString("Enter full name: "));
		customer.setAge(input.enterInterger("Enter age: "));
		customer.setPhone(input.enterString("Enter phone: "));
		address.setCity(input.enterString("Enter city"));
		customer.setAddress(address);

		return customer;
	}

	@Override
	public Customer editCustomer(List<Customer> lstCustomer) {
		// TODO Auto-generated method stub
		int idCustomer;
		boolean flag = false;
		Customer customer = null;
		idCustomer = input.enterInterger("Enter id: ");
		for (Customer customerE : lstCustomer) {
			if (idCustomer == customerE.getId()) {
				flag = true;
			}
		}
		if (flag = true) {
			customer = new Customer();
			Address address = new Address();
			customer.setId(input.enterInterger("Enter ID: "));
			customer.setFullName(input.enterString("Enter full name: "));
			customer.setAge(input.enterInterger("Enter age: "));
			customer.setPhone(input.enterString("Enter phone: "));
			address.setCity(input.enterString("Enter city: "));
			customer.setAddress(address);
		} else {
			System.out.println("ID customer invalid!");
		}
		return customer;
	}

	@Override
	public int deleteCustomer() {
		// TODO Auto-generated method stub
		int idCustomer;
		idCustomer = input.enterInterger("Enter id customer: ");
		return idCustomer;
	}

	@Override
	public void showCustomer(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("ID: " + customer.getId());
		System.out.println("Full name: " + customer.getFullName());
		System.out.println("Age: " + customer.getAge());
		System.out.println("Phone : " + customer.getPhone());
		System.out.println("City: " + customer.getAddress().getCity());

	}

	@Override
	public void showListCustomer(List<Customer> lstCustomer) {
		// TODO Auto-generated method stub
		for (Customer customer : lstCustomer) {
			showCustomer(customer);
		}
	}

}

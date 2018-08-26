package com.nvt.model;

import java.util.List;

import com.nvt.entity.Address;
import com.nvt.entity.Customer;

public class CustomerDAO implements com.nvt.imodel.ICustomer {

	@Override
	public boolean addCustomer(List<Customer> lstCustomer, Customer customer) {
		// TODO Auto-generated method stub
		boolean flag = false;
		int lenght = 0;
		lenght = lstCustomer.size();
		lstCustomer.add(customer);
		if (lstCustomer != null && lstCustomer.size() == (lenght + 1)) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean editCustomer(List<Customer> lstCustomer, Customer customer) {
		// TODO Auto-generated method stub
		Address address = new Address();
		for (Customer customerE : lstCustomer) {
			if (customerE.getId() == customer.getId()) {
				customerE.setId(customer.getId());
				customerE.setFullName(customer.getFullName());
				customerE.setAge(customer.getAge());
				customerE.setPhone(customer.getPhone());
				address.setCity(customer.getAddress().getCity());
				customerE.setAddress(address);
			}
		}
		return true;
	}

	@Override
	public boolean deleteCustomer(List<Customer> lstCustomer, int idCustomer) {
		// TODO Auto-generated method stub
		for (Customer customer : lstCustomer) {
			if (customer.getId() == idCustomer) {
				lstCustomer.remove(customer);
				return true;
			}
		}
		return false;
	}

}

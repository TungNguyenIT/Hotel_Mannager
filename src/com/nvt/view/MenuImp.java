package com.nvt.view;

import com.nvt.iview.IMenu;

public class MenuImp implements IMenu {

	@Override
	public void mainMenu() {
		// TODO Auto-generated method stub
		System.out.println("1.Handle Room");
		System.out.println("2.Handle Customer");
		System.out.println("3.Transaction");
		System.out.println("4.Exit program!");
	}

	@Override
	public void roomMenu() {
		// TODO Auto-generated method stub
		System.out.println("\t11.Add Room");
		System.out.println("\t12.Edit Room");
		System.out.println("\t13.Delete Room");
		System.out.println("\t14.Show list room");
		System.out.println("\t15.Exit Handle Room");
	}

	@Override
	public void customerMenu() {
		// TODO Auto-generated method stub
		System.out.println("\t21.Add customer");
		System.out.println("\t22.Edit customer");
		System.out.println("\t23.Delete customer");
		System.out.println("\t24.Show list customer");
		System.out.println("\t25.Exit handle customer");
	}

	@Override
	public void transactionMenu() {
		// TODO Auto-generated method stub
		System.out.println("\t31.Rent Room");
		System.out.println("\t32.Pay room");
		System.out.println("\t33.Show list transaction");
		System.out.println("\t34.Exit transaction");
	}

}

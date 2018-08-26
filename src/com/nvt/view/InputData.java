package com.nvt.view;

import java.util.Scanner;

import com.nvt.iview.IData;

public class InputData implements IData {
	public int enterInterger(String message) {
		int intValue = 0;
		boolean flag = true;
		do {
			Scanner scanner = new Scanner(System.in);
			try {
				System.out.println(message);
				intValue = scanner.nextInt();
				flag = false;
			} catch (Exception e) {
				// TODO: handle exception
				System.out
						.println("Your value invalid. You must enter Interger type!");
			}
		} while (flag);
		return intValue;
	}

	public double enterDouble(String message) {
		double doubleValue = 0.0;
		boolean flag = true;
		do {
			Scanner scanner = new Scanner(System.in);
			try {
				System.out.println(message);
				doubleValue = scanner.nextDouble();
				flag = false;
			} catch (Exception e) {
				// TODO: handle exception
				System.out
						.println("Your value invalid.You must enter Double type!");
			}
		} while (flag);
		return doubleValue;
	}

	public String enterString(String message) {
		String stringValue = "";
		boolean flag = true;
		do {
			Scanner scanner = new Scanner(System.in);
			try {
				System.out.println(message);
				stringValue = scanner.nextLine();
				flag = false;
			} catch (Exception e) {
				// TODO: handle exception
				System.out
						.println("Your value invalid. You must enter String type!");
			}
		} while (flag);
		return stringValue;
	}
}

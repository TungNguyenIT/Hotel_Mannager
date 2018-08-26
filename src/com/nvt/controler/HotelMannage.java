package com.nvt.controler;

import java.util.ArrayList;
import java.util.List;

import com.nvt.common.IConfiguration;
import com.nvt.entity.Customer;
import com.nvt.entity.Room;
import com.nvt.entity.Transaction;
import com.nvt.model.CustomerDAO;
import com.nvt.model.RoomDAO;
import com.nvt.model.TransactionDAO;
import com.nvt.view.CustomerImp;
import com.nvt.view.InputData;
import com.nvt.view.MenuImp;
import com.nvt.view.MessageImp;
import com.nvt.view.RoomImp;
import com.nvt.view.TransactionImp;

public class HotelMannage {
	public static void main(String[] args) {
		boolean flag = true;
		boolean flagHandleRoom = true;
		boolean flagHandleCus = true;
		boolean flagHandleTransaction = true;
		int chosse = 0;
		int chosseHandleRoom = 0;
		int chosseHandleCus = 0;
		int chosseHandTransaction = 0;
		String checkOut = "";
		List<Room> lstRoom = new ArrayList<Room>();
		List<Customer> lstCustomer = new ArrayList<Customer>();
		List<Transaction> lstTransaction = new ArrayList<Transaction>();
		Room room = null;
		Customer customer = null;
		Transaction transaction = null;
		InputData input = new InputData();
		RoomImp roomImp = new RoomImp();
		RoomDAO roomDAO = new RoomDAO();
		CustomerImp customerImp = new CustomerImp();
		CustomerDAO customerDAO = new CustomerDAO();
		TransactionImp transactionImp = new TransactionImp();
		TransactionDAO transactionDAO = new TransactionDAO();
		MenuImp menuImp = new MenuImp();
		MessageImp messageImp = new MessageImp();
		do {
			menuImp.mainMenu();
			chosse = input.enterInterger("Enter your chosse: ");
			switch (chosse) {
			case IConfiguration.MENU_HANDLE_ROOM: {
				do {
					menuImp.roomMenu();
					chosseHandleRoom = input
							.enterInterger("Enter your chosse: ");
					switch (chosseHandleRoom) {
					case IConfiguration.MENU_ADD_ROOM: {
						do {
							boolean flagAddRoom = false;
							room = new Room();
							roomImp.addRoom(room);
							flagAddRoom = roomDAO.addRoom(lstRoom, room);
							if (flagAddRoom != false) {
								messageImp.showMessage("Congrat! Add success");
							} else {
								messageImp.showMessage("Add fail");
							}
							checkOut = input.enterString("Enter "
									+ IConfiguration.CONFIRM + " to continue");
						} while (checkOut
								.equalsIgnoreCase(IConfiguration.CONFIRM));
						break;
					}
					case IConfiguration.MENU_EDIT_ROOM: {
						do {
							// room = new Room();
							boolean flagEditRoom = false;
							room = roomImp.editRoom(lstRoom);
							flagEditRoom = roomDAO.editRoom(lstRoom, room);
							if (flagEditRoom == true) {
								messageImp.showMessage("Edit scuccess!");
							} else {
								messageImp.showMessage("Edit fail");
							}
							checkOut = input.enterString("Enter "
									+ IConfiguration.CONFIRM + " to continue");
						} while (checkOut
								.equalsIgnoreCase(IConfiguration.CONFIRM));

						break;
					}
					case IConfiguration.MENU_DELETE_ROOM: {
						do {
							int roomNumber;
							boolean flagDelete = false;
							roomNumber = roomImp.deleteRoom();
							flagDelete = roomDAO
									.deleteRoom(lstRoom, roomNumber);
							if (flagDelete = true) {
								messageImp.showMessage("Delete success!");
							} else {
								messageImp.showMessage("Delete fail!");
							}
							checkOut = input.enterString("Enter "
									+ IConfiguration.CONFIRM + " to continue");
						} while (checkOut
								.equalsIgnoreCase(IConfiguration.CONFIRM));

						break;
					}
					case IConfiguration.MENU_SHOW_LIST_ROOM: {
						roomImp.showListRoom(lstRoom);
						break;
					}
					case IConfiguration.MENU_EXIT_ROOM: {
						System.out.println("Exit handle room");
						flagHandleRoom = false;
						break;
					}
					default:
						System.out.println("Try again");
						break;
					}

				} while (flagHandleRoom);
				break;
			}
			case IConfiguration.MENU_HANDLE_CUSTOMER: {
				do {
					menuImp.customerMenu();
					chosseHandleCus = input
							.enterInterger("Enter your chosse: ");
					switch (chosseHandleCus) {
					case IConfiguration.MENU_ADD_CUSTOMER: {
						do {
							customer = new Customer();
							boolean flagAdd = false;
							customerImp.addCustomer(customer);
							flagAdd = customerDAO.addCustomer(lstCustomer,
									customer);
							if (flagAdd == true) {
								messageImp
										.showMessage("Add customer success: ");
							} else {
								messageImp.showMessage("Add fail.");
							}
							checkOut = input.enterString("Enter "
									+ IConfiguration.CONFIRM + " to continue");
						} while (checkOut
								.equalsIgnoreCase(IConfiguration.CONFIRM));
						break;
					}
					case IConfiguration.MENU_EDIT_CUSTOMER: {
						do {
							boolean flagEdit = false;
							customer = customerImp.editCustomer(lstCustomer);
							flagEdit = customerDAO.editCustomer(lstCustomer,
									customer);
							if (flagEdit == true) {
								messageImp.showMessage("Edit success!");
							} else {
								messageImp.showMessage("Edit fail!");
							}
							checkOut = input.enterString("Enter "
									+ IConfiguration.CONFIRM + " to continue");
						} while (checkOut
								.equalsIgnoreCase(IConfiguration.CONFIRM));
						break;
					}
					case IConfiguration.MENU_DELETE_CUSTOMER: {
						do {
							boolean flagDelete = false;
							int idCustomer;
							idCustomer = customerImp.deleteCustomer();
							flagDelete = customerDAO.deleteCustomer(
									lstCustomer, idCustomer);
							if (flagDelete == true) {
								messageImp.showMessage("Delete succes!");
							} else {
								messageImp.showMessage("Delete fail~!");
							}
							checkOut = input.enterString("Enter "
									+ IConfiguration.CONFIRM + " to continue");
						} while (checkOut
								.equalsIgnoreCase(IConfiguration.CONFIRM));
						break;
					}
					case IConfiguration.MENU_SHOW_LIST_CUSTOMER: {
						customerImp.showListCustomer(lstCustomer);
						break;
					}
					case IConfiguration.MENU_EXIT_CUSTOMER: {
						flagHandleCus = false;
						break;
					}

					default:
						messageImp.showMessage("Try again!");
						break;
					}
				} while (flagHandleCus);
				break;
			}
			case IConfiguration.MENU_HANDLE_TRANSACTION: {
				do {
					menuImp.transactionMenu();
					chosseHandTransaction = input
							.enterInterger("Enter your chosse: ");
					switch (chosseHandTransaction) {
					case IConfiguration.MENU_RENT_ROOM: {
						do {
							boolean flagRentRoom = false;
							int roomNumber;
							transaction = new Transaction();
							customer = new Customer();
							roomNumber = transactionImp.rentRoom(lstRoom,
									customer, transaction);
							flagRentRoom = transactionDAO.rentRoom(
									lstTransaction, roomNumber, lstRoom,
									customer, transaction);
							if (flagRentRoom == true) {
								messageImp.showMessage("Transaction success!");
							} else {
								messageImp.showMessage("Transaction fail");
							}
							checkOut = input.enterString("Enter "
									+ IConfiguration.CONFIRM + " to continue");
						} while (checkOut
								.equalsIgnoreCase(IConfiguration.CONFIRM));
						break;
					}
					case IConfiguration.MENU_PAY_ROOM: {
						do {
							boolean flagPayRoom = false;
							int roomNumber = 0;
							roomNumber = transactionImp.payRoom(lstTransaction);
							flagPayRoom = transactionDAO.payRoom(
									lstTransaction, roomNumber);
							if (flagPayRoom == true) {
								messageImp.showMessage("Pay success!");
							} else {
								messageImp.showMessage("Pay fail");
							}
							checkOut = input.enterString("Enter "
									+ IConfiguration.CONFIRM + " to continue");
						} while (checkOut
								.equalsIgnoreCase(IConfiguration.CONFIRM));
						break;
					}
					case IConfiguration.MENU_SHOW_LIST_TRANSACTION: {
						transactionImp.showListTransaction(lstTransaction);
						break;
					}
					case IConfiguration.MENU_EXIT_TRANS: {
						flagHandleTransaction = false;
						break;
					}

					default:
						messageImp.showMessage("Try again!");
						break;
					}

				} while (flagHandleTransaction);
				break;
			}
			case IConfiguration.EXIT_MAIN_MENU: {
				messageImp.showMessage("Exit program!");
				flag = false;
				break;
			}

			default:
				System.out.println("Your value invalid.Try again: ");
				break;
			}

		} while (flag);

	}
}
// boolean flagAddRoom = false;
// room = new Room();
// roomImp.addRoom(room);
// flagAddRoom = roomDAO.addRoom(lstRoom, room);
// if (flagAddRoom = true) {
// messageImp.showMessage("Success!");
// } else {
// messageImp.showMessage("Add failed!");
// }


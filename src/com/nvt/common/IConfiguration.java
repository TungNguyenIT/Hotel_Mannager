package com.nvt.common;

public interface IConfiguration {
	// main menu
	public static final int MENU_HANDLE_ROOM = 1;
	public static final int MENU_HANDLE_CUSTOMER = 2;
	public static final int MENU_HANDLE_TRANSACTION = 3;
	public static final int EXIT_MAIN_MENU = 4;

	// Handle room
	public static final int MENU_ADD_ROOM = 11;
	public static final int MENU_EDIT_ROOM = 12;
	public static final int MENU_DELETE_ROOM = 13;
	public static final int MENU_SHOW_LIST_ROOM = 14;
	public static final int MENU_EXIT_ROOM = 15;

	// Handle customer
	public static final int MENU_ADD_CUSTOMER = 21;
	public static final int MENU_EDIT_CUSTOMER = 22;
	public static final int MENU_DELETE_CUSTOMER = 23;
	public static final int MENU_SHOW_LIST_CUSTOMER = 24;
	public static final int MENU_EXIT_CUSTOMER = 25;
	// Transaction
	public static final int MENU_RENT_ROOM = 31;
	public static final int MENU_PAY_ROOM = 32;
	public static final int MENU_SHOW_LIST_TRANSACTION = 33;
	public static final int MENU_EXIT_TRANS = 34;

	// properties of ROOM
	public static final String STATUS_ROOM_EMPTY = "EMPTY";
	public static final String STATUS_ROOM_BUSY = "BUSY";
	public static final String TYPE_ROOM_NORMAL = "NORMAL";
	public static final String TYPE_ROOM_VIP = "VIP";
	public static final double DISCOUNT_ROOM_NORMAL = 10.0;
	public static final double DISCOUNT_ROOM_VIP = 5.5;

	public static final String CONFIRM = "Y";

}

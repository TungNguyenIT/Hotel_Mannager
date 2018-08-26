package com.nvt.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import com.nvt.common.IConfiguration;
import com.nvt.entity.Room;
import com.nvt.iview.IRoom;

public class RoomImp implements IRoom {
	InputData input = new InputData();
	MessageImp message = new MessageImp();

	@Override
	public Room addRoom(Room room) {
		// TODO Auto-generated method stub
		int roomType;
		room.setRoomNumber(input.enterInterger("Enter room number: "));
		roomType = input.enterInterger("1 " + IConfiguration.TYPE_ROOM_NORMAL
				+ " or  2 " + IConfiguration.TYPE_ROOM_VIP);
		// room.setRoomType(roomType);
		room.setRentCost(input.enterDouble("Enter rent cost: "));
		room.setNumberOfPeople(input.enterInterger("Enter number of people: "));
		room.setStatus(IConfiguration.STATUS_ROOM_EMPTY);

		switch (roomType) {
		case 1: {
			room.setRoomType(IConfiguration.TYPE_ROOM_NORMAL);
			room.setDiscount(IConfiguration.DISCOUNT_ROOM_NORMAL);
			break;
		}
		case 2: {
			room.setRoomType(IConfiguration.TYPE_ROOM_VIP);
			room.setDiscount(IConfiguration.DISCOUNT_ROOM_VIP);
			break;
		}

		default:
			System.out.println("Room type invalid");
			break;
		}

		return room;
	}

	@Override
	public Room editRoom(List<Room> lstRoom) {
		// TODO Auto-generated method stub
		int roomNumber = 0;
		int roomType = 0;
		int roomStatus = 0;
		boolean flagCheck = false;
		Room room = null;
		roomNumber = input.enterInterger("Enter room number: ");
		for (Room roomE : lstRoom) {
			if (roomE.getRoomNumber() == roomNumber) {
				flagCheck = true;
			}
		}

		if (flagCheck == true) {
			room = new Room();
			room.setRoomNumber(roomNumber);
			room.setRentCost(input.enterDouble("Enter rent cost: "));
			room.setNumberOfPeople(input
					.enterInterger("Enter number of people: "));
			roomType = input.enterInterger("1 "
					+ IConfiguration.TYPE_ROOM_NORMAL + " 2 "
					+ IConfiguration.TYPE_ROOM_VIP);
			roomStatus = input.enterInterger("1 "
					+ IConfiguration.STATUS_ROOM_BUSY + "2 "
					+ IConfiguration.STATUS_ROOM_EMPTY);

			switch (roomType) {
			case 1:
				room.setRoomType(IConfiguration.TYPE_ROOM_NORMAL);
				room.setDiscount(IConfiguration.DISCOUNT_ROOM_NORMAL);
				break;
			case 2:
				room.setRoomType(IConfiguration.TYPE_ROOM_VIP);
				room.setDiscount(IConfiguration.DISCOUNT_ROOM_VIP);
				break;
			default:
				System.out.println("room type Invalid");

			}

			switch (roomStatus) {
			case 1:
				room.setStatus(IConfiguration.STATUS_ROOM_BUSY);
				break;
			case 2:
				room.setStatus(IConfiguration.STATUS_ROOM_EMPTY);
				break;

			default:
				System.out.println("status Invalid");
				break;
			}
		} else {
			System.out.println("Room number invalid");
		}

		return room;
	}

	@Override
	public int deleteRoom() {
		// TODO Auto-generated method stub
		int roomNumber;
		roomNumber = input.enterInterger("Enter room number: ");
		return roomNumber;
	}

	@Override
	public void showRoom(Room room) {
		// TODO Auto-generated method stub
		System.out.println("Room Number " + room.getRoomNumber());
		System.out.println("Discount: " + room.getDiscount());
		System.out.println("Number of people: " + room.getNumberOfPeople());
		System.out.println("Number of rent day : " + room.getNumberOfDayRent());
		System.out.println("Rent cost: " + room.getRentCost());
		System.out.println("Price: " + room.getPrice());
		System.out.println("Room type: " + room.getRoomType());
		System.out.println("Room status: " + room.getStatus());

	}

	@Override
	public void showListRoom(List<Room> lstRoom) {
		// TODO Auto-generated method stub
		for (Room room : lstRoom) {
			showRoom(room);
		}
	}

	public void showRoomEmpty(List<Room> lstRoom) {
		for (Room room : lstRoom) {
			if (room.getStatus() == IConfiguration.STATUS_ROOM_EMPTY) {
				showRoom(room);
			}

		}
	}

}

package com.nvt.model;

import java.util.List;

import com.nvt.entity.Room;
import com.nvt.imodel.IRoom;

public class RoomDAO implements IRoom {

	@Override
	public boolean addRoom(List<Room> lstRoom, Room room) {
		// TODO Auto-generated method stub
		boolean flag = false;
		int length = 0;
		room.setPrice((room.getRentCost() * room.getDiscount()) / 100);
		length = lstRoom.size();
		lstRoom.add(room);
		if (lstRoom != null && lstRoom.size() == (length + 1)) {
			flag = true;
		}

		return flag;
	}

	@Override
	public boolean editRoom(List<Room> lstRoom, Room room) {
		// TODO Auto-generated method stub
		for (Room roomE : lstRoom) {
			if (roomE.getRoomNumber() == room.getRoomNumber()) {
				roomE.setRoomNumber(room.getRoomNumber());
				roomE.setDiscount(room.getDiscount());
				roomE.setNumberOfDayRent(room.getNumberOfDayRent());
				roomE.setNumberOfPeople(room.getNumberOfPeople());
				roomE.setRentCost(room.getRentCost());
				roomE.setRoomType(room.getRoomType());
				roomE.setPrice(room.getRentCost() * room.getDiscount() / 100);
				roomE.setStatus(room.getStatus());
			}
		}
		
		return true;
	}

	@Override
	public boolean deleteRoom(List<Room> lstRoom, int roomNumber) {
		for (Room room : lstRoom) {
			if (room.getRoomNumber() == roomNumber) {
				lstRoom.remove(room);
				return true;
			}
		}
		return false;
	}

}

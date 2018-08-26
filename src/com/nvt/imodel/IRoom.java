package com.nvt.imodel;

import java.util.List;

import com.nvt.entity.Room;

public interface IRoom {
	public abstract boolean addRoom(List<Room> lstRoom, Room room);

	public abstract boolean editRoom(List<Room> lstRoom, Room room);

	public abstract boolean deleteRoom(List<Room> lstRoom, int roomNumber);
}

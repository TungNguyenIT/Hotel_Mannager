package com.nvt.iview;

import java.util.List;

import com.nvt.entity.Room;

public interface IRoom {
	public abstract Room addRoom(Room room);

	public abstract Room editRoom(List<Room> lstRoom);

	public abstract void showRoom(Room room);

	public abstract void showListRoom(List<Room> lstRoom);

	public abstract int deleteRoom();
}

package com.nvt.entity;

public class Room {
	private int roomNumber;
	private String roomType;
	private int numberOfPeople;
	private double rentCost;
	private double discount;
	private double price;
	private int numberOfDayRent;
	private String timeIn;
	private String status;
	private Customer customer ;

	
	public String getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(String timeIn) {
		this.timeIn = timeIn;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public double getRentCost() {
		return rentCost;
	}

	public void setRentCost(double rentCost) {
		this.rentCost = rentCost;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumberOfDayRent() {
		return numberOfDayRent;
	}

	public void setNumberOfDayRent(int numberOfDayRent) {
		this.numberOfDayRent = numberOfDayRent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

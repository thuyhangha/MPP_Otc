package com.mpp.lab4.prob2;

import java.time.LocalDate;

public class Order {
	private  int orderNo = 0;
	private LocalDate orderDate;
	private int orderAmount = 0;
	
	public Order(int orderNo, int orderAmount, LocalDate orderDate) {
		// TODO Auto-generated constructor stub
		this.orderNo = orderNo;
		this.orderAmount = orderAmount;
		this.orderDate = orderDate;
	}
	
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}
}

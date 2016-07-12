package com.tahadelen.datatypes;

import java.util.ArrayList;

public class User {

	private static double totalPrice = 0.0;
	private static ArrayList<Food> orders = new ArrayList<Food>();

	public static double getTotalPrice() {
		return User.totalPrice;
	}

	public static void setTotalPrice(double totalPrice) {
		User.totalPrice = totalPrice;
	}

	public static double calculateTotalPrice() {
		totalPrice = 0.0;

		for (Food order : orders) {
			totalPrice += order.getPrice();
		}

		return totalPrice;
	}

	public static void addOrder(Food order, int number) {
		for (int i = 0; i < number; i++)
			orders.add(order);

		totalPrice += order.getPrice() * number;
	}

	public static void deleteOrder(int index) {
		totalPrice -= orders.get(index).getPrice();
		orders.remove(index);
	}

	public static ArrayList<Food> getOrders() {
		return orders;
	}

	public static void freeOrders() {
		orders.clear();
		totalPrice = 0.0;
	}
}

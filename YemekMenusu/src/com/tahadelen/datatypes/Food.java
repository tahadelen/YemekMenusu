package com.tahadelen.datatypes;

import java.io.Serializable;

public class Food implements Serializable {

	private int id;
	private String name;
	private String description;
	private double price;
	private String imagePath;
	private int category;
	// private Bitmap image;

	public int tableNumber;

	public Food() {
		
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}
	
	public String toString() {
		return getName();
	}

	/*
	 * public Bitmap getImage() { return image; }
	 * 
	 * public void setImage(Bitmap image) { this.image = image; }
	 */
}

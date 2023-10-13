package com.entities;

public class Furniture implements IEntity {
	private String furnitureName;
	
	public Furniture(String furnitureName) {
		this.furnitureName = furnitureName;
	}
	
	public String getName() {
		return furnitureName;
	}
}

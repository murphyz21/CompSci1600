package com.actions;

import com.entities.Furniture;
import com.entities.Item;

public class Pickup implements IAction{
	private Character name;
	private Item item;
	private Furniture furn = null;
	
	public Pickup(Character name, Item item) {
		this.name = name;
		this.item = item;
	}
	
	public Pickup(Character name, Item item, Furniture furn) {
		this.name = name;
		this.item = item;
		this.furn = furn;
	}
	
	public String getName() {
		return "Pickup";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s)", getName(), name.getName(name));
	}
}

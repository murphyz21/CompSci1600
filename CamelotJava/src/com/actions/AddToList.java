package com.actions;

import com.entities.Item;

public class AddToList implements IAction{
	private Item item;
	private String descrip;
	
	public AddToList(Item item, String descrip) {
		this.item = item;
		this.descrip = descrip;
	}
	
	public String getName() {
		return "AddToList";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s, %s)", getName(), item, descrip);
	}
}

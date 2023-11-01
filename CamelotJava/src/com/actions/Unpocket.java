package com.actions;

import com.entities.Character;
import com.entities.Item;

public class Unpocket implements IAction{
	
	private Character name;
	private Item item;
	
	public Unpocket(Character name, Item item) {
		this.name = name;
		this.item = item;
	}
	
	public String getName() {
		return "Unpocket";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s, %s)", getName(), name, item);
	}

}

package com.actions;

import com.entities.Item;
import com.entities.Character;

public class Pocket implements IAction{
	
	private Character name;
	private Item item;
	
	public Pocket(Character name, Item item) {
		this.name = name;
		this.item = item;
	}
	
	public String getName() {
		return "Pocket";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s, %s)", getName(), name, item);
	}

}

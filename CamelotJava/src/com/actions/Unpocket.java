package com.actions;

import com.entities.Item;
import com.entities.Character;

public class Unpocket implements IAction{
	
	Character name;
	Item item;
	
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
		return String.format("%s(%s, %s)", getName(), name.getName(), item.getName());
	}

}

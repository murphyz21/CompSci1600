package com.actions;

import com.entities.Item;
import com.entities.Character;

public class Draw implements IAction{
	Character name;
	Item item;
	
	public Draw(Character name, Item item) {
		this.name = name;
		this.item = item;
	}
	
	public String getName() {
		return "Draw";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s, %s)", getName(), name.getName(), item.getName());
	}

}

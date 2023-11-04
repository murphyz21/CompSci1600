package com.actions;

import com.entities.Item;

public class Draw implements IAction{
	private com.entities.Character name;
	private Item item;
	
	public Draw(com.entities.Character name, Item item) {
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
		return String.format("%s(%s, %s", getName(), name.toString(), item.toString());
	}

}

package com.actions;

import com.entities.IEntity;
import com.entities.Item;

public class LookAt implements IAction{
	private Character looker;
	private Item target;
	
	public LookAt(Character looker) {
		this.looker = looker;
	}
	
	public LookAt(Character name, Item target) {
		this.looker = name;
		this.target = target;
	}
	
	public String getName() {
		return "LookAt";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s, %s)", getName(), looker, target.toString());
	}
}

package com.actions;

import com.entities.Furniture;
import com.entities.Character;


public class Enter implements IAction{
	Character name;
	Furniture portal;
	Boolean bool;
	
	public Enter(Character name, Furniture portal, Boolean bool) {
		this.name = name;
		this.portal = portal;
		this.bool = bool;
	}
	
	public String getName() {
		return "Enter";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s, %s, %s)", getName(), name, portal, bool);
	}
	
	

}

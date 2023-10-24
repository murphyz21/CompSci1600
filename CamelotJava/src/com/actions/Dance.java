package com.actions;

import com.entities.Character;

public class Dance implements IAction{
	private Character name;
	
	public Dance(Character name) {
		this.name = name;
	}
	
	public String getName() {
		return "Dance";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s)", getName(), name);
	}
}

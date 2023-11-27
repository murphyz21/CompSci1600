package com.actions;

import com.entities.Character;

public class SetLeft implements IAction {

	Character name;
	
	public SetLeft(Character name) {
		this.name = name;
	}
	
	public String getName() {
		return "ShowDialog";
	}
		
	public boolean getShouldWait() {
		return true;
	}
		
	public String toString() {
		return String.format("%s()", getName(), name.getName());
	}

}


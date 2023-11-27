package com.actions;

import com.entities.Character;

public class SetRight implements IAction {

	Character name;
	
	public SetRight(Character name) {
		this.name = name;
	}
	
	public String getName() {
		return "ShowDialog";
	}
		
	public boolean getShouldWait() {
		return true;
	}
		
	public String toString() {
		return String.format("%s(%s)", name.getName());
	}

}


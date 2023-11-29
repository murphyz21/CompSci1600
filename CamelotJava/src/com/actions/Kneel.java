package com.actions;

import com.entities.Character;

public class Kneel implements IAction{
	Character name;
	
	public Kneel(Character king) {
		name = king;
	}
	
	public String getName() {
		return "Kneel";
	}
	
	public boolean getShouldWait() {
		return true;
	}

	public String toString() {
		return String.format("%s(%s)", getName(), name.getName());
	}
}

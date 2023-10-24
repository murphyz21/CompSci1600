package com.actions;

public class Kneel implements IAction{
	private com.entities.Character name;
	
	public Kneel(com.entities.Character king) {
		name = king;
	}
	
	public String getName() {
		return "Kneel";
	}
	
	public boolean getShouldWait() {
		return true;
	}

	public String toString() {
		return String.format("%s(%s)", getName(), name);
	}
}

package com.actions;
import com.entities.Character;

public class ShowList implements IAction{
	private Character name;
	
	public ShowList(Character name) {
		this.name = name;
	}
	
	public String getName() {
		return "ShowList";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s)", getName(), name);
	}

}

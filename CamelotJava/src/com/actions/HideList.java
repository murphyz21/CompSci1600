package com.actions;

public class HideList implements IAction{
	
	public String getName() {
		return "HideList";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s()", getName());
	}

}

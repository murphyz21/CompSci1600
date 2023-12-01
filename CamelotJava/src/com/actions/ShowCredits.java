package com.actions;

public class ShowCredits implements IAction {
	boolean show;
	
	public String getName() {
		return "ShowCredits";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s()", getName());

	}
}

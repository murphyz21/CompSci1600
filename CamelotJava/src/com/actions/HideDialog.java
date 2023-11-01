package com.actions;

public class HideDialog implements IAction{
	public String getName() {
		return "HideDialog";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s()", getName());
	}

}

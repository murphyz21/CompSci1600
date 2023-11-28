package com.actions;

public class ClearDialog implements IAction {
	public String getName() {
		return "ClearDialog";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s()", getName());
	}

}

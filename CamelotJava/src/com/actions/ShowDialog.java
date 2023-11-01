package com.actions;

public class ShowDialog implements IAction{
	public String getName() {
		return "ShowDialog";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s()", getName());
	}

}

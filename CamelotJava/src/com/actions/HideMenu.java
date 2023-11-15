package com.actions;

public class HideMenu implements IAction{
		
	public String getName() {
		return "HideMenu";
	}
		
	public boolean getShouldWait() {
		return true;
	}
		
	public String toString() {
		return String.format("%s()", getName());
	}
}


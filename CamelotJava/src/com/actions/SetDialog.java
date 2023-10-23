package com.actions;

public class SetDialog implements IAction{
	private String line;
	
	public SetDialog(String line) {
		this.line = line;
	}
	
	public String getName() {
		return "SetDialog";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s)", getName(), line.getName());
	}
}

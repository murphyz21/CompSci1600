package com.actions;

public class SetCredits implements IAction{
	private String line;
	
	public SetCredits(String line) {
		this.line = line;
	}
	
	public String getName() {
		return "SetCredits";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s)", getName(), line);
	}
}
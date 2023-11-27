package com.actions;

public class Wait implements IAction {
	private int time;
	
	public Wait(int time) {
		this.time = time;
	}
	public String getName() {
		return "Wait";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%d)", getName(), time);
	}
}

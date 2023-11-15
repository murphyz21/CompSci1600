package com.actions;

public class CreateEffect implements IAction{
	Character name;
	String effect;
	
	public CreateEffect(Character name, String effect) {
		this.name = name;
		this.effect = effect;
	}
	
	public String getName() {
		return "CreateEffect";
	}

	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s, %s)", getName(), name, effect);
	}
}

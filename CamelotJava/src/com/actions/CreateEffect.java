package com.actions;

public class CreateEffect implements IAction{
	Character name;
	Effect effect;
	
	public CreateEffect(Character name, Effect effect) {
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

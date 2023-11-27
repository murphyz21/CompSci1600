package com.actions;

import com.entities.Character;

public class Die implements IAction{
	Character cha;
	
	public Die(Character cha) {
		this.cha = cha;
	}
	
	public String getName() {
		return "Die";
	}

	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s)", getName(), cha.getName());
	}
}

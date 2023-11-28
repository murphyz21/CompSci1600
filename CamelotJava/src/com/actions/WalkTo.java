package com.actions;

import com.entities.Character;

public class WalkTo {
	Character stander;
	Character walker;
	
	public WalkTo(Character stander, Character walker) {
		this.stander = stander;
		this.walker = walker;
	}
	
	public String getName() {
		return "WalkTo";
	}
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s, %s)", getName(), stander.getName(), walker.getName());
	}
}

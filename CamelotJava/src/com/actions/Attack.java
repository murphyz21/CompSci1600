package com.actions;

public abstract class Attack implements IAction{
	private Character attack;
	private Character name;
	private Character enemy;
	private Boolean bool = false;
	
	public Attack(Character name, Character enemy) {
		this.name = name;
		this.enemy = enemy;
	}
	
	public Attack(Character name, Character enemy, boolean bool) {
		this.name = name;
		this.enemy = enemy;
		this.bool = bool;
	}
	public String getName() {
		return "attack";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s)", getName(), attack.getName(attack));
	}
}
}

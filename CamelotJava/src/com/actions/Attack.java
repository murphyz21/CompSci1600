package com.actions;

public class Attack implements IAction{
	private Character attacker;
	private Character enemy;
	private Boolean bool = false;
	
	public Attack(Character attacker, Character enemy) {
		this.attacker = attacker;
		this.enemy = enemy;
	}
	
	public Attack(Character attacker, Character enemy, boolean bool) {
		this.attacker=attacker;
		this.enemy = enemy;
		this.bool = bool;
	}
	public String getName() {
		return "Attack";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s, %s, %s)", getName(), attacker, enemy, bool.toString());
	}
}


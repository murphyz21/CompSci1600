package com.actions;

public abstract class Drink implements IAction{
	private Character drink;
	
	public Drink(Character drink) {
		this.drink = drink;
	}
	
	public String getName() {
		return "Drink";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s)", getName(), drink);
	}
}

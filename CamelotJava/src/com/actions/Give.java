package com.actions;

import com.entities.Item;

public abstract class Give implements IAction{
	private Character giver;
	private Character receiver;
	private Item potion;
	
	public Give(Character giver, Item potion, Character receiver) {
		this.giver = giver;
		this.potion = potion;
		this.receiver = receiver;
	}
	
	public String getName() {
		return "give";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s)", getName(), giver.getName(giver));
	}
}

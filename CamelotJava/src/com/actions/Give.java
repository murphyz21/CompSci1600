package com.actions;

import com.entities.Item;
import com.entities.Character;

public class Give implements IAction{
	Character giver;
	Character receiver;
	Item potion;
	
	public Give(Character giver, Item potion, Character receiver) {
		this.giver = giver;
		this.potion = potion;
		this.receiver = receiver;
	}
	
	public String getName() {
		return "Give";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s, %s, %s)", getName(), giver.getName(), potion.getName(), receiver.getName());
	}
}

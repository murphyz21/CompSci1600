package com.actions;

import com.entities.Character;
import com.entities.IEntity;
import com.entities.Item;

public class PutDown implements IAction{
	Character character;
	Item item;
	IEntity other;
	
	public PutDown(Character character, Item item) {
		this.character = character;
		this.item = item;
	}
	
	public PutDown(Character character, Item item, IEntity other) {
		this(character, item);
		this.other=other;
	}
	
	public String getName() {
		return "PutDown";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		if(other==null)
			return String.format("%s(%s, %s)", getName(), character.getName(), item.getName());
		else
			return String.format("%s(%s, %s, %s)", getName(), character.getName(), item.getName(), other.getName());
	}

}

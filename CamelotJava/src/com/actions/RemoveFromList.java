package com.actions;

import javax.swing.text.html.parser.Entity;

public class RemoveFromList implements IAction{
	private Entity entity;
	
	public RemoveFromList(Entity entity) {
		this.entity = entity;
	}
	
	public String getName() {
		return "RemoveFromList";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s)", getName(), entity);
	}
}


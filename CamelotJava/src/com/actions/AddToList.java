package com.actions;

import javax.swing.text.html.parser.Entity;

public class AddToList implements IAction{
	private Entity entity;
	private String descrip;
	
	public AddToList(Entity entity, String descrip) {
		this.entity = entity;
		this.descrip = descrip;
	}
	
	public String getName() {
		return "AddToList";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s, %s)", getName(), entity, descrip);
	}
}

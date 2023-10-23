package com.actions;

import com.entities.IEntity;

public class LookAt implements IAction{
	private Character looker;
	private Character target = null;
	private IEntity ent = null;
	
	public LookAt(Character looker) {
		this.looker = looker;
	}
	
	public LookAt(Character looker, Character target) {
		this.looker = looker;
		this.target = target;
	}
	
	public LookAt(Character looker, IEntity ent) {
		this.looker = looker;
		this.ent = ent;
	}
	
	public String getName() {
		return "LookAt";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s)", getName(), looker.getName(looker));
	}
}

package com.actions;

import com.entities.IEntity;

public class LookAt implements IAction{
	private Character looker;
	private IEntity target = null;
	
	public LookAt(Character looker) {
		this.looker = looker;
	}
	
	public LookAt(Character looker, IEntity target) {
		this.looker = looker;
		this.target = target;
	}
	
	public String getName() {
		return "LookAt";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s, %s)", getName(), looker, target.toString());
	}
}

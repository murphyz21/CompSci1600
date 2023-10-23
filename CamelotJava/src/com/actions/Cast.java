package com.actions;

public abstract class Cast implements IAction{
	private Character caster;
	private Character target = null;
	private String color = "red";
	
	public Cast(Character caster) {
		this.caster = caster;
	}
	
	public Cast(Character caster, Character target) {
		this.caster = caster;
		this.target = target;
	}
	
	public Cast(Character caster, Character target, String color) {
		this.caster = caster;
		this.target = target;
		this.color = color;
	}
	
	public String getName() {
		return "Cast";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s, %s, %s)", getName(), caster, target, color.toString());
	}
}
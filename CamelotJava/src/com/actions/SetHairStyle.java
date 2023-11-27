package com.actions;

import com.entities.Character;
import com.entities.Character.Clothing;
import com.entities.Character.HairStyle;

public class SetHairStyle implements IAction {
	public boolean getShouldWait() {
		return false;
	}
	public String getName() {
		return "SetHairStyle";
	}
	
	private Character character;
	
	public SetHairStyle(Character character) {
		this.character=character;
		this.hairStyle = character.getHairStyle();
	}
	private HairStyle hairStyle;
	
	public SetHairStyle(Character character, HairStyle hairStyle) {
		this.character=character;
		this.hairStyle=hairStyle;
	}
	public String toString() {
		return String.format("%s(%s, %s)", getName(), character.getName(), hairStyle.toString());
	}
}

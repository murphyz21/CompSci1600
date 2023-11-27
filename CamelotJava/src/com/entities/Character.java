package com.entities;

import com.entities.Things.ThingNames;

public class Character implements IEntity, IThing<com.entities.Character.BodyTypes> {
	private String characterName;
	private BodyTypes bodyType;
	private Clothing clothing;
	private HairStyle hairStyle;
	
	
	public enum BodyTypes {
		A, 
		B, 
		C, 
		D, 
		E, 
		F, 
		G, 
		H;
	}
	public enum Clothing {
		Bandit, 
		Beggar, 
		LightArmour, 
		HeavyArmour, 
		Merchant, 
		Noble, 
		Peasant, 
		Priest,
		King,
		Warlock;
	}
	
	public enum HairStyle {
		Long, 
		Spiky, 
		Short;
	}
	
	public Character(String characterName) {
		this(characterName, BodyTypes.C, Clothing.Peasant, HairStyle.Long);
	}
	
	public Character(String characterName, BodyTypes bodyType) {
		this(characterName, bodyType, Clothing.Peasant, HairStyle.Long);
	}
	
	public Character(String characterName, BodyTypes bodyType, Clothing clothing) {
		this(characterName, bodyType, clothing, HairStyle.Long);
	}
	
	public Character(String characterName, BodyTypes bodyType, Clothing clothing, HairStyle hairStyle) {
		this.characterName = characterName;
		this.bodyType = bodyType;
		this.clothing = clothing;
		this.hairStyle = hairStyle;
	}
	
	
	public HairStyle getHairStyle() {
		return this.hairStyle;
	}
	
	public Clothing getClothing() {
		return this.clothing;
	}
	public String getName() {
		return characterName;
	}

	@Override
	public BodyTypes getTemplate() {
		// TODO Auto-generated method stub
		return bodyType;
	}

	
}

package com.entities;

public class Character<BodyTypes> implements IEntity {
	private String characterName;
	private BodyTypes bodyType;
	private Clothing clothing;
	private HairStyle hairStyle;
	
	
	enum BodyTypes {
		A, 
		B, 
		C, 
		D, 
		E, 
		F, 
		G, 
		H;
	}
	enum Clothing {
		Bandit, 
		Beggar, 
		LightArmour, 
		HeavyArmour, 
		Merchant, 
		Noble, 
		Peasant, 
		Priest;
	}
	
	enum HairStyle {
		Long, 
		Spiky, 
		Short;
	}
	
	public Character(String characterName) {
		this.characterName = characterName;
	}
	
	public Character(String characterName, BodyTypes bodyType) {
		this.characterName = characterName;
		this.bodyType = bodyType;
	}
	
	public Character(String characterName, BodyTypes bodyType, Clothing clothing) {
		this.characterName = characterName;
		this.bodyType = bodyType;
		this.clothing = clothing;
	}
	
	public Character(String characterName, BodyTypes bodyType, Clothing clothing, HairStyle hairStyle) {
		this.characterName = characterName;
		this.bodyType = bodyType;
		this.clothing = clothing;
		this.hairStyle = hairStyle;
	}
	
	public HairStyle getHairStyle() {
		return hairStyle;
	}
	
	public Clothing getClothing() {
		return clothing;
	}
	public String getName() {
		return characterName;
	}
}

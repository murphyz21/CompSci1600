package com.entities;

public class Place implements IThing<com.entities.Place.Places> {
	private String placeName;
	private Places template;
	
	public enum Places {
		AlchemyShop, 
		Blacksmith, 
		Bridge, 
		Camp, 
		CastleBedroom, 
		CastleCrossroads, 
		City, 
		Cottage, 
		Courtyard, 
		DiningRoom, 
		Dungeon, 
		Farm, 
		ForestPath, 
		GreatHall, 
		Hallway, 
		Library, 
		Port, 
		Ruins, 
		SpookyPath, 
		Storage, 
		Tavern
	}
	
	public Place(String placeName, Places template) {
		this.placeName = placeName;
		this.template = template;
	}
	
	
	public String getName() {
		return placeName;
		
	}
	public Places getTemplate() {
		return template;
	}
	public Furniture getFurniture(String name) {
		return new Furniture(placeName + "." + name);
	}
}

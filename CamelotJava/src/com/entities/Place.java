package com.entities;

public class Place<Places> implements IThing {
	private String placeName;
	private Places template;
	
	enum Places {
		AlchemyShop, 
		BlackSmith, 
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
	
}

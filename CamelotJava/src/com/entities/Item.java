package com.entities;

public class Item implements IEntity, IThing<com.entities.Item.Items> {
	private String itemName;
	private Items template;
	
	public enum Items {
		Apple, 
		Bag, 
		BlueBook, 
		BlueCloth, 
		BlueKey, 
		BluePotion, 
		Bottle, 
		Bread, 
		ChickenLeg, 
		Coin, 
		Compass, 
		Cup, 
		EvilBook, 
		GoldCup, 
		GreenBook, 
		GreenKey, 
		GreenPotion,
		Hammer, 
		Helmet, 
		InkandQuill, 
		JewelKey, 
		LitTorch, 
		Lock, 
		MagnifyingGlass, 
		OpenScroll, 
		PurpleBook, 
		PurpleCloth, 
		PurpleKey, 
		PurplePotion, 
		Rags, 
		RedBook, 
		RedCloth, 
		RedKey, 
		RedPotion, 
		Scroll, 
		Skull, 
		SpellBook, 
		Sword, 
		Torch
	}
	
	public Item(String itemName, Items template) {
		this.itemName = itemName;
		this.template = template;
	}
	
	public String getName() {
		return itemName;
	}
	
	public Items getTemplate() {
		return template;
	}
}

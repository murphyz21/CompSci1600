package com.entities;

import java.util.Hashtable;
import java.util.Optional;
public class Things {
	public enum ThingNames{ Tom, Home, Sword, Edith, startCyard, greenbook, guard3, campBegger1, campBegger2, campBegger3, spellBook, Courtyard, 
		camp, cYard2, Helmet, Torch, king, cYard3, cYard4, Guard, evilbook, alchemyShop, poison, cYard5, guard2, cYard6, 
		bluePotion, greenPotion, cYard7, cYard8, King, Blacksmith, Warlock, FortuneTeller, ArmourEdith, Alchemist} 
	private static Hashtable<ThingNames, IThing<?>> list=new Hashtable<>();
	public static boolean add(ThingNames name, IThing<?> thing) {
		if(list.containsKey(name))
			return false;
		list.put(name, thing);
		return true;
	}
	
	public static Optional<IThing<?>> get(ThingNames name) {
		return Optional.ofNullable(list.get(name));
	}
}

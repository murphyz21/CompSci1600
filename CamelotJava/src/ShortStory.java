import com.entities.Things.ThingNames;

public class ShortStory implements IStory{
	private Character edith, king, guard1, guard2, guard3, alchemist, campBegger1, campBegger2, campBegger3;
	private Place startCyard,camp, cYard1, cYard2, cYrad3, cYard4, alchemyShop,cYard5, cYard6, cYard7, cYard8;
	private Item greenbook, spellBook, sword, helmet, torch, evilbook, poison, bluePotion, greenPotion;
	
	private enum ActionNames {
		
	}
	
	private enum NodeLabels {
		
	}
	
	public INode getRoot() {
		return new Node("root");
	}
	
	public void getThings() {
		//Start
		edith = new Character(ThingNames.Edith);
		startCyard = new Place(ThingNames.startCyard, Places.Courtyard);
		greenbook = new Item(ThingNames.greenbook, Items.GreenBook);
		king = new Character(ThingNames.king);
		
		//Left Side
		camp = new Place(ThingNames.camp, Places.Camp);
		spellBook = new Item(ThingNames.spellBook, Items.SpellBook);
		cYard1 = new Place(ThingNames.Courtyard, Places.Courtyard);
		campBegger1 = new Character(ThingNames.campBegger1);
		campbegger2 = new Character(ThingNames.campBegger2);
		campBegger3 = new Character(ThingNames.campBegger3);
		
		cYard2 = new Place(ThingNames.cYard2, Places.Courtyard);
		
		sword = new Item(ThingNames.sword, Items.Sword);
		helmet = new Item(ThingNames.helmet, Items.Helmet);
		torch = new Item(ThingNames.torch, Items.LitTorch);
		
		cYard3 = new Place(ThingNames.cYard3, Places.Courtyard);
		youDieKing = new Character(ThingNames.youdieKing);
		
		
		cYard4 = new Place(ThingNames.cYard4, Places.Courtyard);
		guard1 = new Character(ThingNames.guard1);
		
		//Right Side
		evilbook = new Item(ThingNames.evilbook, Items.EvilBook);
		alchemyShop = new Place(Thingnames.alchemyShop, Places.AlchemyShop);
		alchemist - new Character(ThingNames.alchemist);
		poison = new Item(ThingNames.poison, Items.GreenPotion);
		
		cYard5 = new Place(ThingNames.cYard5, Places.Courtyard);
		
		cYard6 = new Place(ThingNames.cYard6, Places.Courtyard);
		guard2 = new Character(ThingNames.guard2);
		
		bluePotion = new Item(ThingNames.bluePotion, Items.BluePotion);
		greenPotion = new Item(ThingNames.greenPotion, Items.GreenPotion);
		cYard7 = new Place(ThingNames.cYard7, Places.Courtyard);
		
		cYard8 = new Place(ThingNames.cYard8, Places.Courtyard);
		guard3 = new Character(ThingNames.guard3);
	}
}

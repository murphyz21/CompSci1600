import com.entities.Things.ThingNames;

public class ShortStory implements IStory{
	
	public INode getRoot() {
		return new Node("root");
	}
	
	public void getThings() {
		//Start
		var edith = new Character(ThingNames.Edith);
		var startCyard = new Place(ThingNames.startCyard, Places.Courtyard);
		var greenbook = new Item(ThingNames.greenbook, Items.GreenBook);
		
		//Left Side
		var camp = new Place(ThingNames.camp, Places.Camp);
		var spellBook = new Item(ThingNames.spellBook, Items.SpellBook);
		var cYard1 = new Place(ThingNames.Courtyard, Places.Courtyard);
		var friendKing = new Character(ThingNames.friendKing);
		var badTalkKing = new Character(ThingNames.badTalkKing);
		
		var cYard2 = new Place(ThingNames.cYard2, Places.Courtyard);
		var hurtKing = new Character(ThingNames.hurtKing);
		var goodSpellKing = new Character(ThingNames.goodSpellKing);
		
		var sword = new Item(ThingNames.sword, Items.Sword);
		var helmet = new Item(ThingNames.helmet, Items.Helmet);
		var torch = new Item(ThingNames.torch, Items.LitTorch);
		
		var cYard3 = new Place(ThingNames.cYard3, Places.Courtyard);
		var youDieKing = new Character(ThingNames.youdieKing);
		var swordBecomesKing = new Character(ThingNames.swordBecomesKing);
		
		var cYard4 = new Place(ThingNames.cYard4, Places.Courtyard);
		var torchBecomesKing = new Character(ThingNames.torchBecomesKing);
		var guardArrestYou = new Character(ThingNames.guardArrestYou);
		
		//Right Side
		var evilbook = new Item(ThingNames.evilbook, Items.EvilBook);
		var alchemyShop = new Place(Thingnames.alchemyShop, Places.AlchemyShop);
		var poison = new Item(ThingNames.poison, Items.GreenPotion);
		
		var cYard5 = new Place(ThingNames.cYard5, Places.Courtyard);
		var drinksPoisonKing = new Character(ThingNames.drinksPoisonKing);
		var killsyouKing = new Character(ThingNames.killsyouKing);
		
		var cYard6 = new Place(ThingNames.cYard6, Places.Courtyard);
		var weakPoisonKing = new Character(ThingNames.weakPoisonKing);
		var guard2 = new Character(ThingNames.guard2);
		
		var bluePotion = new Item(ThingNames.bluePotion, Items.BluePotion);
		var greenPotion = new Item(ThingNames.greenPotion, Items.GreenPotion);
		var cYard6 = new Place(ThingNames.cYard6, Places.Courtyard);
		var noPowersArrestKing = new Character(Thingnames.noPowerArrestKing);
		var noPowersKillsKing = new Character(ThingNames.noPowersKillsKing);
		
		var cYard7 = new Place(ThingNames.cYard7, Places.Courtyard);
		var powersArrestKing = new Character(ThingNames.powersArrestKing);
		var guard3 = new Character(ThingNames.guard3);
		var powersBecomeKing = new Character(ThingNames.powersBecomeKing);	
	}
}

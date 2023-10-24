import com.actions.ActionSequence;
import com.actions.AddToList;
import com.actions.Attack;
import com.actions.Cast;
import com.actions.Create;
import com.actions.Dance;
import com.actions.Die;
import com.actions.Draw;
import com.actions.Drink;
import com.actions.Exit;
import com.actions.Give;
import com.actions.IAction;
import com.actions.Kneel;
import com.actions.LookAt;
import com.actions.Pickup;
import com.actions.Position;
import com.actions.PutDown;
import com.actions.SetCameraFocus;
import com.actions.SetDialog;
import com.actions.ShowMenu;
import com.actions.Take;
import com.entities.Item.Items;
import com.entities.Place.Places;
import com.entities.Things.ThingNames;
import com.sequences.CharacterCreation;
import com.storygraph.ActionMap;
import com.storygraph.INode;
import com.storygraph.Node;
import com.entities.*;
import com.entities.Character;

public class ShortStory implements IStory, IAction, IThing, IEntity{
	com.entities.Character edith;
	private Character king, guard1, guard2, guard3, alchemist, campBegger1, campBegger2, campBegger3;
	private Place startCyard,camp, cYard1, cYard2, cYard3, cYard4, alchemyShop,cYard5, cYard6, cYard7, cYard8, courtYard;
	private Item greenbook, spellBook, sword, helmet, torch, evilbook, poison, bluePotion, greenPotion;
	
	private enum ActionNames {
		
	}
	
	private enum NodeLabels {
		Init, Start, CourtYard, EvilBook, GoToAlchemyShop, BuyPoison, StudyEvilBook, DrinkMakesWeak, GoToCourtYard1A, KingDrinksPoison,
		KingKillsYou, GoToCourtYard2A, WeakFromPoisonDie, WeakGetArrested, BuyPotion, DrinkGivesPowers, GoToCourtYard4A, PowersNotUsedGetArrested, 
		PowersBecomeKing, GreenBook, GoToCamp, TakeSword, TakeTorch, GoToCourtYard4C, TorchBecomeKing, GuardsArrestYou, GetArmour, GoToCourtYard3C, YouDie, 
		SwordBecomeKing, TakeSpellBook, ReadSpellBook, GoToCourtYard2C, GoodSpellsKingDies, NoSpellsGetArrested
	}
	
	public INode getRoot() {
		return new Node("root");
	}
	
	public void getThings() {
		//Start
		edith = new Character(ThingNames.Edith.toString());
		startCyard = new Place(ThingNames.startCyard.toString(), Places.Courtyard);
		greenbook = new Item(ThingNames.greenbook.toString(), Items.GreenBook);
		king = new Character(ThingNames.king.toString());
		
		//Left Side
		camp = new Place(ThingNames.camp.toString(), Places.Camp);
		spellBook = new Item(ThingNames.spellBook.toString(), Items.SpellBook);
		cYard1 = new Place(ThingNames.Courtyard.toString(), Places.Courtyard);
		campBegger1 = new Character(ThingNames.campBegger1.toString());
		campBegger2 = new Character(ThingNames.campBegger2.toString());
		campBegger3 = new Character(ThingNames.campBegger3.toString());
		
		cYard2 = new Place(ThingNames.cYard2.toString(), Places.Courtyard);
		
		sword = new Item(ThingNames.Sword.toString(), Items.Sword);
		helmet = new Item(ThingNames.Helmet.toString(), Items.Helmet);
		torch = new Item(ThingNames.Torch.toString(), Items.LitTorch);
		
		cYard3 = new Place(ThingNames.cYard3.toString(), Places.Courtyard);
		
		cYard4 = new Place(ThingNames.cYard4.toString(), Places.Courtyard);
		guard1 = new Character(ThingNames.guard1.toString());
		
		//Right Side
		evilbook = new Item(ThingNames.evilbook.toString(), Items.EvilBook);
		alchemyShop = new Place(ThingNames.alchemyShop.toString(), Places.AlchemyShop);
		alchemist = new Character(ThingNames.alchemist.toString());
		poison = new Item(ThingNames.poison.toString(), Items.GreenPotion);
		
		cYard5 = new Place(ThingNames.cYard5.toString(), Places.Courtyard);
		
		cYard6 = new Place(ThingNames.cYard6.toString(), Places.Courtyard);
		guard2 = new Character(ThingNames.guard2.toString());
		
		bluePotion = new Item(ThingNames.bluePotion.toString(), Items.BluePotion);
		greenPotion = new Item(ThingNames.greenPotion.toString(), Items.GreenPotion);
		cYard7 = new Place(ThingNames.cYard7.toString(), Places.Courtyard);
		
		cYard8 = new Place(ThingNames.cYard8.toString(), Places.Courtyard);
		guard3 = new Character(ThingNames.guard3.toString());
	}
	
	private ActionSequence getInit() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Position(edith, courtYard));
		sequence.add(new SetCameraFocus(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	private ActionSequence getStart() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Position(edith, courtYard));
		return sequence;
	}
	private ActionSequence getCourtYard() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.combineWith(new CharacterCreation(guard1));
		sequence.combineWith(new CharacterCreation(guard2));
		sequence.combineWith(new CharacterCreation(guard3));
		sequence.combineWith(new CharacterCreation(king));
		sequence.add(new Position(guard1, courtYard));
		sequence.add(new Position(guard2, courtYard));
		sequence.add(new Position(guard3, courtYard));
		sequence.add(new Position(edith, courtYard));
		sequence.add(new Create<Item>(greenbook));
		sequence.add(new Position(greenbook, courtYard, "BigStall.Right"));
		sequence.add(new Create<Item>(evilbook));
		sequence.add(new Position(evilbook, courtYard, "BigStall.Left"));
		return sequence;
	}
	private ActionSequence getGreenBook() {
		var sequence = new ActionSequence();
		sequence.add(new Take(edith, greenbook));
		sequence.add(new AddToList(greenbook, "this is the greenbook!"));
		sequence.add(new Exit(edith, courtYard.getFurniture("gate"), true));
		return sequence;
	}
	
	private ActionSequence getGoToCamp() {
		var sequence = new ActionSequence();
		sequence.add(new Create<Place>(camp));
		sequence.add(new Position(edith, camp));
		sequence.add(new Create<Item>(sword));
		sequence.add(new Position(sword, camp, "Log"));
		return sequence;
	}
	
	private ActionSequence getTakeSword() {
		var sequence = new ActionSequence();
		sequence.add(new Take(edith, sword));
		sequence.add(new AddToList(sword, "this is your amazing sword!"));
		sequence.add(new Create<Item>(helmet));
		sequence.add(new Create<Item>(torch));
		sequence.add(new Position(helmet, camp, "Barrel"));
		sequence.add(new Position(torch, camp, "Stall"));
		return sequence;
	}
	private ActionSequence getGetArmour() {
		var sequence = new ActionSequence();
		sequence.add(new Take(edith, helmet));
		sequence.add(new AddToList(helmet, "this is your helmet!"));
		sequence.add(new Exit(edith, camp.getFurniture("gate"), true));
		return sequence;
	}
	
	private ActionSequence getTakeTorch() {
		var sequence = new ActionSequence();
		sequence.add(new Take(edith, torch));
		sequence.add(new AddToList(torch, "this is your torch!"));
		sequence.add(new Exit(edith, camp.getFurniture("gate"), true));
		return sequence;
	}
	
	private ActionSequence getGoToCourtYard3C() {
		var sequence = new ActionSequence();
		sequence.add(new Create<Place>(courtYard));
		sequence.add(new Position(edith, courtYard));
		sequence.combineWith(new CharacterCreation(king));
		sequence.add(new Position(king, courtYard));
		sequence.add(new SetDialog("You've been treating the peasants unfairly!"));
		sequence.add(new SetDialog("I've come to kill you!"));
		sequence.add(new SetDialog("I will make things fair I promise! Don't kill me please!"));
		return sequence;
	}
	
	private ActionSequence getYouDie() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("Ok King Nikos, I will put down my sword..."));
		sequence.add(new PutDown(edith, sword));
		sequence.add(new Pickup(king, sword, ));
		sequence.add(new Attack(king, edith, false));
		sequence.add(new Die(edith));
		sequence.add(new SetDialog("Begon Peasant, now I will rull forever and ever! hahahaha!"));
		sequence.add(new Dance(king));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getSwordBecomeKing() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("Liar!!!!"));
		sequence.add(new Draw(edith, sword));
		sequence.add(new Attack(edith, king, false));
		sequence.add(new Die(king));
		sequence.add(new SetDialog("Begon King Nikos, I'm the Queen now! hahahaha!"));
		sequence.add(new Dance(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getGoToCourtYard4C() {
		var sequence = new ActionSequence();
		sequence.add(new Create<Place>(courtYard));
		sequence.add(new Position(edith, courtYard));
		sequence.combineWith(new CharacterCreation(king));
		sequence.add(new Position(king, courtYard));
		sequence.add(new SetDialog("You've been treating the peasants unfairly!"));
		sequence.add(new SetDialog("I've come to kill you and burn this dang castle to the ground!!!"));
		sequence.add(new SetDialog("I will make things fair I promise! Don't kill me please, I beg you!"));
		return sequence;
	}
	
	private ActionSequence getTorchBecomeKing() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("It's too late for apologies!"));
		sequence.add(new Draw(edith, torch));
		sequence.add(new Attack(edith, king, false));
		sequence.add(new Die(king));
		sequence.add(new SetDialog("Begon King Nikos, I'm the Queen now! hahahaha!"));
		sequence.add(new Dance(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getGuardsArrestYou() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("It's too late for apologies!"));
		sequence.add(new SetDialog("Guards come quick!"));
		sequence.add(new Draw(edith, torch));
		sequence.add(new Attack(edith, king, false));
		sequence.add(new Die(king));
		sequence.add(new SetDialog("Edith you are arrested for treason and are banished to the scary island!"));
		sequence.add(new Dance(guard1));
		sequence.add(new Dance(guard2));
		sequence.add(new Dance(guard3));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	//New Branch
	private ActionSequence getTakeSpellBook() {
		var sequence = new ActionSequence();
		sequence.add(new Create<Item>(spellBook));
		sequence.add(new Position(spellBook, camp, "Chest"));
		sequence.add(new Take(edith, spellBook));
		sequence.add(new AddToList(spellBook, "spellbook!"));
		return sequence;
	}
	
	private ActionSequence getReadSpellBook() {
		var sequence = new ActionSequence();
		sequence.add(new LookAt(edith, spellBook));
		sequence.add(new Exit(edith, camp.getFurniture("gate"), true));
		return sequence;
	}
	
	private ActionSequence getGoToCourtYard2C() {
		var sequence = new ActionSequence();
		sequence.add(new Create<Place>(courtYard));
		sequence.add(new Position(edith, courtYard));
		sequence.combineWith(new CharacterCreation(king));
		sequence.add(new Position(king, courtYard));
		sequence.add(new SetDialog("You've been treating the peasants unfairly!"));
		sequence.add(new SetDialog("I've come to kill you with my spells!!!"));
		sequence.add(new SetDialog("I will make things fair I promise! Don't cast a spell on me please, I beg you!"));
		return sequence;
	}
	
	private ActionSequence getNoSpellsGetArrested() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("It's too late for apologies! I cast you away King Nikos!"));
		sequence.add(new Cast(edith, king, "purple"));
		sequence.add(new Kneel(king));
		sequence.add(new SetDialog("Oww! Guards, arrest that heathen!!!"));
		sequence.add(new SetDialog("Edith you are arrested for treason and are banished to the scary island!"));
		sequence.add(new Dance(king));
		sequence.add(new Dance(guard1));
		sequence.add(new Dance(guard2));
		sequence.add(new Dance(guard3));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getGoodSpellsKingDies() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("It's too late for apologies! I cast you away King Nikos!"));
		sequence.add(new Cast(edith, king, "red"));
		sequence.add(new Die(king));
		sequence.add(new SetDialog("Begon King Nikos, I'm the Queen now! hahahaha!"));
		sequence.add(new Dance(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getEvilBook() {
		var sequence = new ActionSequence();
		sequence.add(new Take(edith, evilbook));
		sequence.add(new AddToList(evilbook, "this is your evil book!"));
		sequence.add(new Exit(edith, courtYard.getFurniture("gate"), true));
		return sequence;
	}

	private ActionSequence getGoToAlchemyShop() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(alchemist));
		sequence.add(new Create<Place>(alchemyShop));
		sequence.add(new Position(alchemist, alchemyShop));
		sequence.add(new Position(edith, alchemyShop));
		sequence.add(new Create<Item>(greenPotion));
		sequence.add(new Position(greenPotion, alchemyShop, "Bar.Left"));
		sequence.add(new Create<Item>(bluePotion));
		sequence.add(new Position(bluePotion, alchemyShop, "Bar.Right"));
		return sequence;
	}

	private ActionSequence getBuyPoison() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("Mr. Alchemist I'm on a revolution to kill the king, what potion should I choose?"));
		sequence.add(new SetDialog("Ayyy hurrah, Take the green one little lassy."));
		sequence.add(new Take(edith, greenPotion, alchemyShop.getFurniture("Bar.Left")));
		sequence.add(new AddToList(greenPotion, "this is the green potion!"));
		return sequence;
	}

	private ActionSequence getStudyEvilBook() {
		var sequence = new ActionSequence();
		sequence.add(new LookAt(edith, evilbook));

		return sequence;
	}

	private ActionSequence getGoToCourtYard1A() {
		var sequence = new ActionSequence();
		sequence.add(new Position(edith, courtYard));
		return sequence;
	}
		
	private ActionSequence getKingDrinksPoison() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("King Nikos, we got you a special potion to make you live forever! Drink up!"));
		sequence.add(new Give(edith, greenPotion, king));
		sequence.add(new Drink(king));
		sequence.add(new SetDialog("Begon King Nikos, I'm the Queen now! hahahaha!"));
		sequence.add(new Dance(edith));
		return sequence;
	}

	private ActionSequence getKingKillsYou() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("I've come to kill you with my spells!!!"));
		sequence.add(new Cast(edith, king, "purple"));
		sequence.add(new SetDialog("I'm not going down without a fight!"));
		sequence.add(new Cast(edith, king, "blue"));)
		sequence.add(new Die(edith));
		sequence.add(new SetDialog("Begon Peasant, now I will rull forever and ever! hahahaha!"));
		sequence.add(new Dance(king));
		sequence.add(new Dance(guard1));
		sequence.add(new Dance(guard2));
		sequence.add(new Dance(guard3));
		return sequence;
	}

	private ActionSequence getDrinkMakesWeak() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("I hope this potion makes me strong so I can defear the evil King Nikos!"));
		sequence.add(new Drink(edith));
		sequence.add(new Exit());
		return sequence;
	}

	private ActionSequence getGoToCourtYard2A() {
		var sequence = new ActionSequence();
		sequence.add(new Position(edith, courtYard));
		return sequence;
	}

	private ActionSequence getWeakFromPoisonDie() {
		var sequence = new ActionSequence();
		sequence.add(new Attack(edith, king, false));
		sequence.add(new Die(edith));
		return sequence;
	}

	private ActionSequence getWeakGetArrested() {
		var sequence = new ActionSequence();
		
		return sequence;
	}

	private ActionSequence getBuyPotion() {
		var sequence = new ActionSequence();
		sequence.add(new Take(edith, bluePotion, alchemyShop.getFurniture("Bar.Right")));
		return sequence;
	}
	 
	private ActionSequence getDrinkGivesPowers() {
		var sequence = new ActionSequence();
		sequence.add(new Drink(edith));
		return sequence;
	}

	private ActionSequence getGoToCourtYard4A() {
		var sequence = new ActionSequence();
		sequence.add(new Position(edith, courtYard));
		return sequence;
	}

	private ActionSequence getPowersNotUsedGetArrested() {
		var sequence = new ActionSequence();
		sequence.add(new Attack(edith, king, false));
		return sequence;
	}

	private ActionSequence getPowersBecomeKing() { 
		var sequence = new ActionSequence();
		sequence.add(new Cast(edith, king, "blue"));
		sequence.add(new Die(king));
		sequence.add(new Dance(edith));
		return sequence;
	}

	public ActionMap getMap() {
		var map = new ActionMap();
		map.add(NodeLabels.GreenBook.toString(), getGreenBook());
		map.add(NodeLabels.GoToCamp.toString(), getGoToCamp());
		map.add(NodeLabels.TakeSword.toString(), getTakeSword());
		map.add(NodeLabels.GetArmour.toString(), getGetArmour());
		map.add(NodeLabels.TakeTorch.toString(), getTakeTorch());
		map.add(NodeLabels.GoToCourtYard3C.toString(), getGoToCourtYard3C());
		map.add(NodeLabels.YouDie.toString(), getYouDie());
		map.add(NodeLabels.SwordBecomeKing.toString(), getSwordBecomeKing());
		map.add(NodeLabels.GoToCourtYard4C.toString(), getGoToCourtYard4C());
		map.add(NodeLabels.TorchBecomeKing.toString(), getTorchBecomeKing());
		map.add(NodeLabels.GuardsArrestYou.toString(), getGuardsArrestYou());
		map.add(NodeLabels.TakeSpellBook.toString(), getTakeSpellBook());
		map.add(NodeLabels.ReadSpellBook.toString(), getReadSpellBook());
		map.add(NodeLabels.GoToCourtYard2C.toString(), getGoToCourtYard2C());
		map.add(NodeLabels.NoSpellsGetArrested.toString(), getNoSpellsGetArrested());
		map.add(NodeLabels.GoodSpellsKingDies.toString(), getGoodSpellsKingDies());
		map.add(NodeLabels.EvilBook.toString(), getEvilBook());
		map.add(NodeLabels.GoToAlchemyShop.toString(), getGoToAlchemyShop());
		map.add(NodeLabels.BuyPoison.toString(), getBuyPoison());
		map.add(NodeLabels.StudyEvilBook.toString(), getStudyEvilBook());
		map.add(NodeLabels.GoToCourtYard1A.toString(), getGoToCourtYard1A());
		map.add(NodeLabels.KingDrinksPoison.toString(), getKingDrinksPoison());
		map.add(NodeLabels.KingKillsYou.toString(), getKingKillsYou());
		map.add(NodeLabels.DrinkMakesWeak.toString(), getDrinkMakesWeak());
		map.add(NodeLabels.GoToCourtYard2A.toString(), getGoToCourtYard2A());
		map.add(NodeLabels.WeakFromPoisonDie.toString(), getWeakFromPoisonDie());
		map.add(NodeLabels.WeakGetArrested.toString(), getWeakGetArrested());
		map.add(NodeLabels.BuyPotion.toString(), getBuyPotion());
		map.add(NodeLabels.DrinkGivesPowers.toString(), getDrinkGivesPowers());
		map.add(NodeLabels.GoToCourtYard4A.toString(), getGoToCourtYard4A());
		map.add(NodeLabels.PowersNotUsedGetArrested.toString(), getPowersNotUsedGetArrested());
		map.add(NodeLabels.PowersBecomeKing.toString(), getPowersBecomeKing());
		return map;
	}
}

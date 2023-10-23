import com.actions.ActionSequence;
import com.actions.Create;
import com.actions.IAction;
import com.actions.Position;
import com.actions.SetCameraFocus;
import com.actions.ShowMenu;
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
		
		cYard2 = new Place(ThingNames.cYard2, Places.Courtyard);
		
		sword = new Item(ThingNames.sword, Items.Sword);
		helmet = new Item(ThingNames.helmet, Items.Helmet);
		torch = new Item(ThingNames.torch, Items.LitTorch);
		
		cYard3 = new Place(ThingNames.cYard3, Places.Courtyard);
		
		
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
		//Kathryn test comment
		cYard8 = new Place(ThingNames.cYard8, Places.Courtyard);
		guard3 = new Character(guard3);
	}
	
	private ActionSequence getInitSequence() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Position(edith, courtYard));
		sequence.add(new SetCameraFocus(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
		}
	private ActionSequence getGreenBook() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Create<Place>(courtYard));
		sequence.add(new Position(edith, courtYard));
		sequence.add(new Create<Item>(greenbook));
		sequence.add(new Position(greenbook, courtYard, "Ground"));
		return sequence;
	}
	
	private ActionSequence getGoToCamp() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Create<Place>(camp));
		sequence.add(new Position(edith, camp));
		sequence.add(new Create<Item>(sword));
		sequence.add(new Position(sword, camp, "Ground"));
		sequence.add(new SetCameraFocus(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getTakeSword() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Create<Place>(camp));
		sequence.add(new Position(edith, camp));
		sequence.add(new Create<Item>(helmet));
		sequence.add(new Create<Item>(torch));
		sequence.add(new Position(helmet, camp, "Ground"));
		sequence.add(new Position(torch, camp, "Ground"));
		sequence.add(new SetCameraFocus(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	private ActionSequence getGetArmour() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Create<Place>(camp));
		sequence.add(new Position(edith, camp));
		sequence.add(new Create<Item>(sword));
		sequence.add(new Position(sword, camp, "InHand"));
		sequence.add(new SetCameraFocus(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getTakeTorch() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Create<Place>(camp));
		sequence.add(new Position(edith, camp));
		sequence.add(new Create<Item>(torch));
		sequence.add(new Position(torch, camp, "InHand"));
		sequence.add(new SetCameraFocus(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getGoToCourtYard3C() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.combineWith(new CharacterCreation(king));
		sequence.add(new Create<Place>(cYard2));
		sequence.add(new Position(edith, cYard2));
		sequence.add(new Create<Item>(helmet));
		sequence.add(new Create<Item>(sword));
		sequence.add(new Position(helmet, edith));
		sequence.add(new Position(sword, edith));
		sequence.add(new SetCameraFocus(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getYouDie() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.combineWith(new CharacterCreation(king));
		sequence.add(new Create<Place>(cYard2));
		sequence.add(new Position(edith, cYard2));
		sequence.add(new Create<Item>(helmet));
		sequence.add(new Create<Item>(sword));
		sequence.add(new Position(helmet, edith));
		sequence.add(new Position(sword, edith));
		sequence.add(new SetCameraFocus(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getSwordBecomeKing() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.combineWith(new CharacterCreation(king));
		sequence.add(new Create<Place>(cYard2));
		sequence.add(new Position(edith, cYard2));
		sequence.add(new Create<Item>(helmet));
		sequence.add(new Create<Item>(sword));
		sequence.add(new Position(helmet, edith));
		sequence.add(new Position(sword, edith));
		sequence.add(new SetCameraFocus(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getGoToCourtYard4C() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.combineWith(new CharacterCreation(king));
		sequence.add(new Create<Place>(cYard3));
		sequence.add(new Position(edith, cYard3));
		sequence.add(new Create<Item>(torch));
		sequence.add(new Create<Item>(sword));
		sequence.add(new Position(torch, edith));
		sequence.add(new Position(sword, edith));
		sequence.add(new SetCameraFocus(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getTorchBecomeKing() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.combineWith(new CharacterCreation(king));
		sequence.add(new Create<Place>(cYard3));
		sequence.add(new Position(edith, cYard3));
		sequence.add(new Create<Item>(torch));
		sequence.add(new Create<Item>(sword));
		sequence.add(new Position(torch, edith));
		sequence.add(new Position(sword, edith));
		sequence.add(new SetCameraFocus(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getGuardsArrestYou() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.combineWith(new CharacterCreation(king));
		sequence.add(new Create<Place>(cYard3));
		sequence.add(new Position(edith, cYard3));
		sequence.add(new Create<Item>(torch));
		sequence.add(new Create<Item>(sword));
		sequence.add(new Position(torch, edith));
		sequence.add(new Position(sword, edith));
		sequence.add(new SetCameraFocus(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	//New Branch
	private ActionSequence getTakeSpellBook() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Create<Place>(camp));
		sequence.add(new Position(edith, camp));
		sequence.add(new Create<Item>(spellBook));
		sequence.add(new Position(spellBook, camp, "HiddenBook"));
		sequence.add(new SetCameraFocus(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getReadSpellBook() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Create<Place>(camp));
		sequence.add(new Position(edith, camp));
		sequence.add(new Create<Item>(spellBook));
		sequence.add(new Position(spellBook, edith));
		sequence.add(new SetCameraFocus(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getGoToCourtYard2C() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.combineWith(new CharacterCreation(king));
		sequence.add(new Create<Place>(cYard1));
		sequence.add(new Position(edith, cYard1));
		sequence.add(new Position(king, cYard1));
		sequence.add(new Create<Item>(spellBook));
		sequence.add(new Position(spellBook, edith));
		sequence.add(new SetCameraFocus(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getNoSpellsGetArrested() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.combineWith(new CharacterCreation(king));
		sequence.add(new Create<Place>(cYard1));
		sequence.add(new Position(edith, cYard1));
		sequence.add(new Position(king, cYard1));
		sequence.add(new Create<Item>(spellBook));
		sequence.add(new Position(spellBook, edith));
		sequence.add(new SetCameraFocus(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getGoodSpellsKingDies() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.combineWith(new CharacterCreation(king));
		sequence.add(new Create<Place>(cYard1));
		sequence.add(new Position(edith, cYard1));
		sequence.add(new Position(king, cYard1));
		sequence.add(new Create<Item>(spellBook));
		sequence.add(new Position(spellBook, edith));
		sequence.add(new SetCameraFocus(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getEvilBook() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Create<Place>(courtYard));
		sequence.add(new Position(edith, courtYard));
		sequence.add(new Create<Item>(evilbook));
		sequence.add(new Position(evilbook, courtYard, "Big Stall"));
		sequence.add(new SetCameraFocus(edith));
		return sequence;
	}


	private ActionSequence getGoToAlchemyShop() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Create<Place>(alchemyShop));
		sequence.add(new Position(edith, alchemyShop));
		sequence.add(new SetCameraFocus(edith));
		return sequence;
	}

	private ActionSequence getBuyPoison() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Create<Place>(alchemyShop));
		sequence.add(new Position(edith, alchemyShop));
		sequence.add(new Create<Item>(greenPotion));
		sequence.add(new Position(greenPotion, alchemyShop, "Bar"));
		sequence.add(new SetCameraFocus(edith));
		return sequence;
	}

	private ActionSequence getStudyEvilBook() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Create<Place>(alchemyShop));
		sequence.add(new Position(edith, alchemyShop));
		sequence.add(new SetCameraFocus(edith));
		return sequence;
	}

	private ActionSequence getGoToCourtYard1A() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Create<Place>(cYard5));
		sequence.add(new Position(edith, cYard5));
		sequence.add(new SetCameraFocus(edith));
		return sequence;
	}
		
	private ActionSequence getKingDrinksPoison() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Create<Place>(cYard5));
		sequence.add(new Position(edith, cYard5));
		sequence.add(new SetCameraFocus(edith));
		return sequence;
	}

	private ActionSequence getKingKillsYou() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Create<Place>(cYard5));
		sequence.add(new Position(edith, cYard5));
		sequence.add(new SetCameraFocus(edith));
		return sequence;
	}

	private ActionSequence getDrinkMakesWeak() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Create<Place>(alchemyShop));
		sequence.add(new Position(edith, alchemyShop));
		sequence.add(new SetCameraFocus(edith));
		return sequence;
	}

	private ActionSequence getGoToCourtYard2A() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Create<Place>(cYard6));
		sequence.add(new Position(edith, cYard6));
		sequence.add(new SetCameraFocus(edith));
		return sequence;
	}

	private ActionSequence getWeakFromPoisonDie() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Create<Place>(cYard6));
		sequence.add(new Position(edith, cYard6));
		sequence.add(new SetCameraFocus(edith));
		return sequence;
	}

	private ActionSequence getWeakGetArrested() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Create<Place>(cYard6));
		sequence.add(new Position(edith, cYard6));
		sequence.add(new SetCameraFocus(edith));
		return sequence;
	}

	private ActionSequence getBuyPotion() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Create<Place>(alchemyShop));
		sequence.add(new Position(edith, alchemyShop));
		sequence.add(new Create<Item>(bluePotion));
		sequence.add(new Position(bluePotion, alchemyShop, "Bar"));
		sequence.add(new SetCameraFocus(edith));
		return sequence;
	}
	 
	private ActionSequence getDrinkGivesPowers() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Create<Place>(alchemyShop));
		sequence.add(new Position(edith, alchemyShop));
		sequence.add(new SetCameraFocus(edith));
		return sequence;
	}

	private ActionSequence getGoToCourtYard4A() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Create<Place>(cYard8));
		sequence.add(new Position(edith, cYard8));
		sequence.add(new SetCameraFocus(edith));
		return sequence;
	}

	private ActionSequence getPowersNotUsedGetArrested() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Create<Place>(cYard8));
		sequence.add(new Position(edith, cYard8));
		sequence.add(new SetCameraFocus(edith));
		return sequence;
	}

	private ActionSequence getPowersBecomeKing() { 
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Create<Place>(cYard8));
		sequence.add(new Position(edith, cYard8));
		sequence.add(new SetCameraFocus(edith));
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

	// testing1
}

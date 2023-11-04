
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
import com.actions.HideDialog;
import com.actions.IAction;
import com.actions.Kneel;
import com.actions.LookAt;
import com.actions.Pickup;
import com.actions.Pocket;
import com.actions.Position;
import com.actions.PutDown;
import com.actions.SetCameraFocus;
import com.actions.SetDialog;
import com.actions.ShowMenu;
import com.actions.Take;
import com.entities.Item.Items;
import com.entities.Place.Places;
import com.entities.Things.ThingNames;
import com.playerInput.ActionChoice;
import com.playerInput.ActionChoice.Icons;
import com.playerInput.SelectionChoice;
import com.sequences.CharacterCreation;
import com.storygraph.ActionMap;
import com.storygraph.INode;
import com.storygraph.Node;
import com.entities.*;
import com.entities.Character;

public class ShortStory implements IStory, IAction, IThing, IEntity{
	private Character edith, king, guard1, guard2, guard3, alchemist, campBegger1, campBegger2, campBegger3;
	private Place camp, alchemyShop, courtYard;
	private Item greenbook, sword, helmet, torch, evilbook, bluePotion, greenPotion, spellBook;
	
	public enum NodeLabels {
		Init, Start, CourtYard, EvilBook, GoToAlchemyShop, BuyPoison, StudyEvilBook, DrinkMakesWeak, GoToCourtYard1A, KingDrinksPoison,
		KingKillsYou, GoToCourtYard2A, WeakFromPoisonDie, WeakGetArrested, BuyPotion, DrinkGivesPowers, GoToCourtYard4A, PowersNotUsedGetArrested, 
		PowersBecomeKing, GreenBook, GoToCamp, TakeSword, TakeTorch, GoToCourtYard4C, TorchBecomeKing, GuardsArrestYou, GetArmour, GoToCourtYard3C, YouDie, 
		SwordBecomeKing, TakeSpellBook, ReadSpellBook, GoToCourtYard2C, GoodSpellsKingDies, NoSpellsGetArrested
	}
	
	public enum ActionNames {Take, Start, Exit, LookAt, Drink, Give, Cast, Attack, ShowDialog}
	
		public INode getRoot() {
		var root = new Node(NodeLabels.Init.toString());
		var CourtYardNode = new Node(NodeLabels.CourtYard.toString());
		var EvilBookNode = new Node(NodeLabels.EvilBook.toString());
		var GoToAlchemyShopNode = new Node(NodeLabels.GoToAlchemyShop.toString());
		var BuyPoisonNode = new Node(NodeLabels.BuyPoison.toString());
		var StudyEvilBookNode = new Node(NodeLabels.StudyEvilBook.toString());
		var DrinkMakesWeakNode = new Node(NodeLabels.DrinkMakesWeak.toString());
		var GoToCourtYard1ANode = new Node(NodeLabels.GoToCourtYard1A.toString());
		var KingDrinksPoisonNode = new Node(NodeLabels.KingDrinksPoison.toString());
		var KingKillsYouNode = new Node(NodeLabels.KingKillsYou.toString());
		var GoToCourtYard2ANode = new Node(NodeLabels.GoToCourtYard2A.toString());
		var WeakFromPoisonDieNode = new Node(NodeLabels.WeakFromPoisonDie.toString());
		var WeakGetArrestedNode = new Node(NodeLabels.WeakGetArrested.toString());
		var BuyPotionNode = new Node(NodeLabels.BuyPotion.toString());
		var DrinkGivesPowersNode = new Node(NodeLabels.DrinkGivesPowers.toString());
		var GoToCourtYard4ANode = new Node(NodeLabels.GoToCourtYard4A.toString());
		var PowersNotUsedGetArrestedNode = new Node(NodeLabels.PowersNotUsedGetArrested.toString());
		var PowersBecomeKingNode = new Node(NodeLabels.PowersBecomeKing.toString());
		var GreenBookNode = new Node(NodeLabels.GreenBook.toString());
		var GoToCampNode = new Node(NodeLabels.GoToCamp.toString());
		var TakeSwordNode = new Node(NodeLabels.TakeSword.toString());
		var TakeTorchNode = new Node(NodeLabels.TakeTorch.toString());
		var GoToCourtYard4CNode = new Node(NodeLabels.GoToCourtYard4C.toString());
		var TorchBecomeKingNode = new Node(NodeLabels.TorchBecomeKing.toString());
		var GuardsArrestYouNode = new Node(NodeLabels.GuardsArrestYou.toString());
		var GetArmourNode = new Node(NodeLabels.GetArmour.toString());
		var GoToCourtYard3CNode = new Node(NodeLabels.GoToCourtYard3C.toString());
		var YouDieNode = new Node(NodeLabels.YouDie.toString());
		var SwordBecomeKingNode = new Node(NodeLabels.SwordBecomeKing.toString());
		var TakeSpellBookNode = new Node(NodeLabels.TakeSpellBook.toString());
		var ReadSpellBookNode = new Node(NodeLabels.ReadSpellBook.toString());
		var GoToCourtYard2CNode = new Node(NodeLabels.GoToCourtYard2C.toString());
		var GoodSpellsKingDiesNode = new Node(NodeLabels.GoodSpellsKingDies.toString());
		var NoSpellsGetArrestedNode = new Node(NodeLabels.NoSpellsGetArrested.toString());
		
		root.addChild(
				new SelectionChoice("Start"), 
				CourtYardNode);
		
		CourtYardNode.addChild(new ActionChoice(ActionNames.Take.toString(),
				courtYard.getFurniture("BigStall.Left"), 
				ActionChoice.Icons.evilbook,
				"Take Evil Book", 
				true), 
				EvilBookNode);
		
		CourtYardNode.addChild(new ActionChoice(ActionNames.Take.toString(),
				courtYard.getFurniture("BigStall.Right"), 
				ActionChoice.Icons.book,
				"Take Green Book", 
				true), 
				GreenBookNode);;
		
		
		// right side of story
		
		EvilBookNode.addChild(new ActionChoice(ActionNames.Exit.toString(),
				courtYard.getFurniture("Gate"), 
				ActionChoice.Icons.exit,
				"Got To The Alchemy Shop", 
				true), 
				GoToAlchemyShopNode);
		
		GoToAlchemyShopNode.addChild(new ActionChoice(ActionNames.Take.toString(),
				courtYard.getFurniture("Bar.Right"), 
				ActionChoice.Icons.potion,
				"Take the Blue Potion", 
				true), 
				BuyPotionNode);
		
		GoToAlchemyShopNode.addChild(new ActionChoice(ActionNames.Take.toString(),
				courtYard.getFurniture("Bar.Left"), 
				ActionChoice.Icons.poison,
				"Take the Poison", 
				true), 
				BuyPoisonNode);
		
		BuyPoisonNode.addChild(new ActionChoice(ActionNames.LookAt.toString(),
				evilbook, 
				ActionChoice.Icons.research,
				"Study the Evil Book", 
				true), 
				StudyEvilBookNode);
		
		BuyPoisonNode.addChild(new ActionChoice(ActionNames.Drink.toString(),
				greenPotion, 
				ActionChoice.Icons.poison,
				"Drink the Poison", 
				true), 
				DrinkMakesWeakNode);
		
		StudyEvilBookNode.addChild(new ActionChoice(ActionNames.Exit.toString(),
				alchemyShop.getFurniture("Door"), 
				ActionChoice.Icons.exit,
				"Go Back to the Courtyard", 
				true), 
				GoToCourtYard1ANode);
		
		GoToCourtYard1ANode.addChild(new ActionChoice(ActionNames.Give.toString(),
				king, 
				ActionChoice.Icons.poison,
				"Take the Blue Potion", 
				true), 
				KingDrinksPoisonNode);
		
		GoToCourtYard1ANode.addChild(new ActionChoice(ActionNames.Cast.toString(),
				king, 
				ActionChoice.Icons.firespell,
				"Cast Spells on the King", 
				true), 
				KingKillsYouNode);
		
		DrinkMakesWeakNode.addChild(new ActionChoice(ActionNames.Exit.toString(),
				alchemyShop.getFurniture("Door"), 
				ActionChoice.Icons.exit,
				"Go Back to the CourtYard", 
				true), 
				GoToCourtYard2ANode);
		
		GoToCourtYard2ANode.addChild(new ActionChoice(ActionNames.Attack.toString(),
				king, 
				ActionChoice.Icons.hurt,
				"Attack the King", 
				true), 
				WeakFromPoisonDieNode);
		
		GoToCourtYard2ANode.addChild(new ActionChoice(ActionNames.Cast.toString(),
				king, 
				ActionChoice.Icons.firespell,
				"Take the Blue Potion", 
				true), 
				WeakGetArrestedNode);
		
		BuyPotionNode.addChild(new ActionChoice(ActionNames.Drink.toString(),
				bluePotion, 
				ActionChoice.Icons.drink,
				"Drink the potion", 
				true), 
				DrinkGivesPowersNode);
		
		DrinkGivesPowersNode.addChild(new ActionChoice(ActionNames.Exit.toString(),
				alchemyShop.getFurniture("Door"), 
				ActionChoice.Icons.exit,
				"Go Back to the CourtYard", 
				true), 
				GoToCourtYard4ANode);
		
		GoToCourtYard4ANode.addChild(new ActionChoice(ActionNames.Cast.toString(),
				king, 
				ActionChoice.Icons.firespell,
				"Cast Spells on the King", 
				true), 
				PowersBecomeKingNode);
		GoToCourtYard4ANode.addChild(new ActionChoice(ActionNames.Attack.toString(),
				king, 
				ActionChoice.Icons.hurt,
				"Attack the King", 
				true), 
				PowersNotUsedGetArrestedNode);
	
		
		// left side of story
		GreenBookNode.addChild(new ActionChoice(ActionNames.Exit.toString(),
				courtYard.getFurniture("Gate"),
				ActionChoice.Icons.exit,
				"Go to the camp!",
				true), 
				GoToCampNode);
		
		GoToCampNode.addChild(new ActionChoice(ActionNames.Take.toString(),
				camp.getFurniture("BigStall.Right"),
				ActionChoice.Icons.book,
				"Go to the camp!",
				true), 
				GoToCampNode);
		
		GoToCampNode.addChild(new ActionChoice(ActionNames.Take.toString(), 
				camp.getFurniture("Chest"),
				ActionChoice.Icons.sword, 
				"Take the sword!", 
				true), 
				TakeSwordNode);
		
		TakeSwordNode.addChild(new ActionChoice(ActionNames.Take.toString(),
				camp.getFurniture("Barrel"),
				ActionChoice.Icons.torch, 
				"Grab the torch!", 
				true), 
				TakeTorchNode);
		
		TakeSwordNode.addChild(new ActionChoice(ActionNames.Take.toString(),
				camp.getFurniture("Stall"),
				ActionChoice.Icons.armour, 
				"Get your Armour!", 
				true), 
				GetArmourNode);
		
		TakeTorchNode.addChild(new ActionChoice(ActionNames.Exit.toString(),
				camp.getFurniture("Exit"),
				ActionChoice.Icons.door, 
				"Go Back to CourtYard to kill the King!", 
				true), 
				GoToCourtYard4CNode);
		
		GoToCourtYard4CNode.addChild(new ActionChoice(ActionNames.Attack.toString(),
				king,
				ActionChoice.Icons.sword, 
				"Attack the King with your Sword!", 
				true), 
				GuardsArrestYouNode);
		
		GoToCourtYard4CNode.addChild(new ActionChoice(ActionNames.Attack.toString(),
				king,
				ActionChoice.Icons.torch, 
				"Attack the King with your Torch!", 
				true), 
				TorchBecomeKingNode);
		
		GetArmourNode.addChild(new ActionChoice(ActionNames.Exit.toString(),
				camp.getFurniture("Exit"),
				ActionChoice.Icons.door, 
				"Go Back To CourtYard to kill the King!", 
				true), 
				GoToCourtYard3CNode);
		
		GoToCourtYard3CNode.addChild(new ActionChoice(ActionNames.Attack.toString(),
				king,
				ActionChoice.Icons.draw, 
				"Attack the King!", 
				true), 
				SwordBecomeKingNode);
		
		GoToCourtYard3CNode.addChild(new ActionChoice(ActionNames.ShowDialog.toString(),
				king,
				ActionChoice.Icons.talk, 
				"Talk it out with King", 
				true), 
				YouDieNode);
		
		TakeSpellBookNode.addChild(new ActionChoice(ActionNames.LookAt.toString(), 
				spellBook,
				ActionChoice.Icons.research,
				"Read the new spell book to learn how to cast spells!", 
				true), 
				ReadSpellBookNode);
		
		ReadSpellBookNode.addChild(new ActionChoice(ActionNames.Exit.toString(),
				camp.getFurniture("Exit"),
				ActionChoice.Icons.door, 
				"Go Back to Courtyard to kill the King!", 
				true), 
				GoToCourtYard2CNode);
		
		GoToCourtYard2CNode.addChild(new ActionChoice(ActionNames.Cast.toString(),
				king,
				ActionChoice.Icons.firespell, 
				"Cast a spell on the king!", 
				true), 
				GoodSpellsKingDiesNode);
		
		GoToCourtYard2CNode.addChild(new ActionChoice(ActionNames.Attack.toString(),
				king,
				ActionChoice.Icons.hurt, 
				"Fight the King!", 
				true), 
				NoSpellsGetArrestedNode);
		
		return root;
	}
	
	public void getThings() {
		edith = new Character(ThingNames.Edith.toString(), Character.BodyTypes.C, Character.Clothing.Peasant);
		king = new Character(ThingNames.king.toString(), Character.BodyTypes.H, Character.Clothing.King);
		guard1 = new Character(ThingNames.guard1.toString(), Character.BodyTypes.D, Character.Clothing.HeavyArmour);
		guard2 = new Character(ThingNames.guard2.toString(), Character.BodyTypes.D, Character.Clothing.HeavyArmour);
		guard3 = new Character(ThingNames.guard3.toString(), Character.BodyTypes.D, Character.Clothing.HeavyArmour);
		alchemist = new Character(ThingNames.alchemist.toString(), Character.BodyTypes.B, Character.Clothing.Priest);
		campBegger1 = new Character(ThingNames.campBegger1.toString(), Character.BodyTypes.B, Character.Clothing.Beggar);
		campBegger2 = new Character(ThingNames.campBegger1.toString(), Character.BodyTypes.E, Character.Clothing.Beggar);
		campBegger3 =  new Character(ThingNames.campBegger3.toString(), Character.BodyTypes.G, Character.Clothing.Beggar);
		
		camp = new Place(ThingNames.camp.toString(), Place.Places.Camp);
		alchemyShop = new Place(ThingNames.alchemyShop.toString(), Place.Places.AlchemyShop);
		courtYard = new Place(ThingNames.Courtyard.toString(), Place.Places.Courtyard);
		
		sword = new Item(ThingNames.Sword.toString(), Item.Items.Sword);
		greenbook = new Item(ThingNames.greenbook.toString(), Item.Items.GreenBook);
		spellBook = new Item(ThingNames.spellBook.toString(), Item.Items.SpellBook);
		helmet = new Item(ThingNames.Helmet.toString(), Item.Items.Helmet);
		torch = new Item(ThingNames.Torch.toString(), Item.Items.Torch);
		evilbook = new Item(ThingNames.evilbook.toString(), Item.Items.EvilBook);
		bluePotion = new Item(ThingNames.bluePotion.toString(), Item.Items.BluePotion);
		greenPotion = new Item(ThingNames.greenPotion.toString(), Item.Items.GreenPotion);
		
		//Start
		edith = new Character(ThingNames.Edith.toString());
		greenbook = new Item(ThingNames.greenbook.toString(), Items.GreenBook);
		king = new Character(ThingNames.king.toString());
		
		//Left Side
		camp = new Place(ThingNames.camp.toString(), Places.Camp);
		spellBook = new Item(ThingNames.spellBook.toString(), Items.SpellBook);
		
		
		sword = new Item(ThingNames.Sword.toString(), Items.Sword);
		helmet = new Item(ThingNames.Helmet.toString(), Items.Helmet);
		torch = new Item(ThingNames.Torch.toString(), Items.LitTorch);
		
		
		//Right Side
		evilbook = new Item(ThingNames.evilbook.toString(), Items.EvilBook);
		alchemyShop = new Place(ThingNames.alchemyShop.toString(), Places.AlchemyShop);

		guard2 = new Character(ThingNames.guard2.toString());
		
		bluePotion = new Item(ThingNames.bluePotion.toString(), Items.BluePotion);
		greenPotion = new Item(ThingNames.greenPotion.toString(), Items.GreenPotion);

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
	
	private ActionSequence getCourtYard() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.combineWith(new CharacterCreation(guard1));
		sequence.combineWith(new CharacterCreation(guard2));
		sequence.combineWith(new CharacterCreation(guard3));
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
		sequence.add(new LookAt(edith, greenbook));
		sequence.add(new SetDialog("This is a Fortune Book! Go to the camp Edith for your next adventure!"));
		sequence.add(new HideDialog());
		sequence.add(new LookAt());
		sequence.add(new Pocket(edith, greenbook));
		sequence.add(new Exit(edith, courtYard.getFurniture("Gate"), true));
		return sequence;
	}
	
	private ActionSequence getGoToCamp() {
		var sequence = new ActionSequence();
		sequence.add(new Create<Place>(camp));
		sequence.combineWith(new CharacterCreation(campBegger1));
		sequence.combineWith(new CharacterCreation(campBegger2));
		sequence.combineWith(new CharacterCreation(campBegger3));
		sequence.add(new Position(campBegger1, camp));
		sequence.add(new Position(campBegger2, camp));
		sequence.add(new Position(campBegger3, camp));
		sequence.add(new Position(edith, camp));
		sequence.add(new Create<Item>(sword));
		sequence.add(new Position(sword, camp, "Log"));
		return sequence;
	}
	
	private ActionSequence getTakeSword() {
		var sequence = new ActionSequence();
		sequence.add(new Take(edith, sword));
		sequence.add(new Create<Item>(helmet));
		sequence.add(new Create<Item>(torch));
		sequence.add(new Position(helmet, camp, "Barrel"));
		sequence.add(new Position(torch, camp, "Stall"));
		return sequence;
	}
	private ActionSequence getGetArmour() {
		var sequence = new ActionSequence();
		sequence.add(new Take(edith, helmet));
		sequence.add(new Exit(edith, camp.getFurniture("gate"), true));
		return sequence;
	}
	
	private ActionSequence getTakeTorch() {
		var sequence = new ActionSequence();
		sequence.add(new Take(edith, torch));
		sequence.add(new Exit(edith, camp.getFurniture("Gate"), true));
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
		sequence.add(new Pickup(king, sword, camp.getFurniture("Log")));
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
		sequence.add(new SetDialog("Ayyy hurrah, Take the green one or the blue one little lassy."));
		sequence.add(new Take(edith, greenPotion, alchemyShop.getFurniture("Bar.Left")));
		sequence.add(new AddToList(greenPotion, "this is the green potion!"));
		return sequence;
	}

	private ActionSequence getStudyEvilBook() {
		var sequence = new ActionSequence();
		sequence.add(new LookAt(edith, evilbook));
		sequence.add(new Exit(edith, alchemyShop.getFurniture("Door"), true));
		return sequence;
	}

	private ActionSequence getGoToCourtYard1A() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(king));
		sequence.add(new Position(king, courtYard));
		sequence.add(new Position(edith, courtYard));
		return sequence;
	}
		
	private ActionSequence getKingDrinksPoison() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("King Nikos, we got you a special potion to make you live forever! Drink up!"));
		sequence.add(new Give(edith, greenPotion, king));
		sequence.add(new Drink(king));
		sequence.add(new SetDialog("Begon King Nikos, I'm the Queen now! hahahaha!"));
		sequence.add(new Die(king));
		sequence.add(new Dance(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
	}

	private ActionSequence getKingKillsYou() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("I've come to kill you with my spells!!!"));
		sequence.add(new Cast(edith, king, "purple"));
		sequence.add(new SetDialog("I'm not going down without a fight!"));
		sequence.add(new Cast(edith, king, "blue"));
		sequence.add(new Die(edith));
		sequence.add(new SetDialog("Begon Peasant, now I will rull forever and ever! hahahaha!"));
		sequence.add(new Dance(king));
		sequence.add(new Dance(guard1));
		sequence.add(new Dance(guard2));
		sequence.add(new Dance(guard3));
		sequence.add(new ShowMenu(true));
		return sequence;
	}

	private ActionSequence getDrinkMakesWeak() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("I hope this potion makes me strong so I can defeat the evil King Nikos!"));
		sequence.add(new Drink(edith));
		sequence.add(new Exit(edith, alchemyShop.getFurniture("Door"), true));
		return sequence;
	}

	private ActionSequence getGoToCourtYard2A() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(king));
		sequence.add(new Position(king, courtYard));
		sequence.add(new Position(edith, courtYard));
		return sequence;
	}

	private ActionSequence getWeakFromPoisonDie() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("King Nikos, I've come to take the throne!"));
		sequence.add(new Attack(edith, king, false));
		sequence.add(new SetDialog("Oh dear, I'm feeling rather weak"));
		sequence.add(new Die(edith));
		sequence.add(new Dance(king));
		sequence.add(new ShowMenu(true));
		return sequence;
	}

	private ActionSequence getWeakGetArrested() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("King Nikos, watch out! I've come to kill you with my spells"));
		sequence.add(new Cast(edith, king, "red"));
		sequence.add(new SetDialog("Nice try peasant, your spells don't work! Arrest her immediately guards!"));
		sequence.add(new Dance(king));
		sequence.add(new Dance(guard1));
		sequence.add(new Dance(guard2));
		sequence.add(new Dance(guard3));
		sequence.add(new ShowMenu(true));
		return sequence;
	}

	private ActionSequence getBuyPotion() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("Mr. Alchemist I'm on a revolution to kill the king, what potion should I choose?"));
		sequence.add(new SetDialog("Ayyy hurrah, Take the green one or the blue one little lassy."));
		sequence.add(new Take(edith, bluePotion, alchemyShop.getFurniture("Bar.Right")));
		sequence.add(new AddToList(bluePotion, "this is the blue potion!"));
		return sequence;
	}
	 
	private ActionSequence getDrinkGivesPowers() {
		var sequence = new ActionSequence();
		sequence.add(new Drink(edith));
		sequence.add(new SetDialog("Wow, this potion gave me so many new powers!"));
		sequence.add(new Exit(edith, alchemyShop.getFurniture("Door"), true));
		return sequence;
	}

	private ActionSequence getGoToCourtYard4A() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(king));
		sequence.add(new Position(king, courtYard));
		sequence.add(new Position(edith, courtYard));
		return sequence;
	}

	private ActionSequence getPowersNotUsedGetArrested() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("King Nikos, I don't want to kill you with my powers, you must surrender your throne!"));
		sequence.add(new SetDialog("I will never back down!"));
		sequence.add(new Attack(edith, king, false));
		sequence.add(new SetDialog("You should've used your powers! Arrest her immediately guards!"));
		sequence.add(new Dance(guard1));
		sequence.add(new Dance(guard2));
		sequence.add(new Dance(guard3));
		sequence.add(new Dance(king));
		sequence.add(new ShowMenu(true));
		return sequence;
	}

	private ActionSequence getPowersBecomeKing() { 
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("This is revenge King Nikos!"));
		sequence.add(new Cast(edith, king, "blue"));
		sequence.add(new Die(king));
		sequence.add(new Dance(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
	}

	public ActionMap getMap() {
		var map = new ActionMap();
		map.add(NodeLabels.Init.toString(), getInit());
		map.add(NodeLabels.CourtYard.toString(), getCourtYard());
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

	@Override
	public Object getTemplate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return false;
	}
}

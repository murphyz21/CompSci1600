
import com.actions.ActionSequence;
import com.actions.AddToList;
import com.actions.Attack;
import com.actions.Cast;
import com.actions.Create;
import com.actions.Dance;
import com.actions.Die;
import com.actions.Draw;
import com.actions.Drink;
import com.actions.EnableInput;
import com.actions.Enter;
import com.actions.Exit;
import com.actions.Give;
import com.actions.HideDialog;
import com.actions.HideMenu;
import com.actions.IAction;
import com.actions.Kneel;
import com.actions.LookAt;
import com.actions.Pickup;
import com.actions.Pocket;
import com.actions.Position;
import com.actions.PutDown;
import com.actions.SetCameraFocus;
import com.actions.SetDialog;
import com.actions.SetLeft;
import com.actions.SetRight;
import com.actions.ShowDialog;
import com.actions.ShowMenu;
import com.actions.Take;
import com.actions.Unpocket;
import com.actions.Wait;
import com.actions.WalkTo;
import com.entities.Item.Items;
import com.entities.Place.Places;
import com.entities.Things.ThingNames;
import com.playerInput.ActionChoice;
import com.playerInput.ActionChoice.Icons;
import com.playerInput.PositionChoice;
import com.playerInput.SelectionChoice;
import com.sequences.CharacterCreation;
import com.storygraph.ActionMap;
import com.storygraph.INode;
import com.storygraph.Node;
import com.entities.*;
import com.entities.Character;
import com.actions.ClearDialog;


public class ShortStory implements IStory, IAction, IThing, IEntity{
	private Character edith, king, guard1, guard2, guard3, alchemist, warlock, fortuneteller, edith2;
	private Place BlackSmith, alchemyShop, Courtyard;
	private Item greenbook, sword, helmet, torch, evilbook, bluePotion, greenPotion, spellBook;
	
	public enum NodeLabels {
		Init, FortuneTeller, CourtYard, EvilBook, GoToAlchemyShop, BuyPoison, StudyEvilBook, DrinkMakesWeak, GoToCourtYard1A, KingDrinksPoison,
		KingKillsYou, GoToCourtYard2A, WeakFromPoisonDie, WeakGetArrested, BuyPotion, DrinkGivesPowers, GoToCourtYard4A, PowersNotUsedGetArrested, 
		PowersBecomeKing, GreenBook, GoToCamp, TakeSword, TakeTorch, GoToCourtYard4C, TorchBecomeKing, GuardsArrestYou, GetArmour, GoToCourtYard3C, YouDie, 
		SwordBecomeKing, TakeSpellBook, ReadSpellBook, GoToCourtYard2C, GoodSpellsKingDies, NoSpellsGetArrested, GoToCourtYard1C, ReadGreenBook, BadTalkYouDie, BeFriendKing,
		WarlockTalk, KingTalk1, KingTalk2, KingTalk3, KingTalk4, AlchemistTalk, KingTalk5, KingTalk6
	}
	public enum ChoiceLabels {
		DrinkMakesWeak, StudyEvilBook, ReadSpellBook, ReadGreenBook
	}
	//lol
	
	// comment
	
	public enum ActionNames {Take, Start, exit, LookAt, Drink, Give, Cast, Attack, ShowDialog, Unpocket}
	
	public ShortStory() {
		getThings();
	}
		public INode getRoot() {
		var root = new Node(NodeLabels.Init.toString());
		var FortuneTellerNode = new Node(NodeLabels.FortuneTeller.toString());
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
		var ReadGreenBookNode = new Node(NodeLabels.ReadGreenBook.toString());
		var GoToCourtYard1CNode = new Node(NodeLabels.GoToCourtYard1C.toString());
		var BeFriendKingNode = new Node(NodeLabels.BeFriendKing.toString());
		var BadTalkYouDieNode = new Node(NodeLabels.BadTalkYouDie.toString());
		var WarlockTalkNode = new Node(NodeLabels.WarlockTalk.toString());
		var KingTalk1Node = new Node(NodeLabels.KingTalk1.toString());
		var KingTalk2Node = new Node(NodeLabels.KingTalk2.toString());
		var KingTalk3Node = new Node(NodeLabels.KingTalk3.toString());
		var KingTalk4Node = new Node(NodeLabels.KingTalk4.toString());
		var AlchemistTalkNode = new Node(NodeLabels.AlchemistTalk.toString());
		var KingTalk5Node = new Node(NodeLabels.KingTalk5.toString());
		var KingTalk6Node = new Node(NodeLabels.KingTalk6.toString());
		
		root.addChild(
				new SelectionChoice("Start"), 
				FortuneTellerNode);
		
		FortuneTellerNode.addChild(new ActionChoice(ActionNames.ShowDialog.toString(),
				fortuneteller, 
				ActionChoice.Icons.talk, 
				"Talk to Fortune Teller", 
				false), 
				CourtYardNode);
		
		CourtYardNode.addChild(new ActionChoice(ActionNames.Take.toString(),
				evilbook, 
				ActionChoice.Icons.evilbook,
				"Take Evil Book", 
				false), 
				EvilBookNode);
		
		CourtYardNode.addChild(new ActionChoice(ActionNames.Take.toString(),
				greenbook, 
				ActionChoice.Icons.book,
				"Take Green Book", 
				false), 
				GreenBookNode);;
		
		
		// right side of story
		
		EvilBookNode.addChild(new ActionChoice(ActionNames.exit.toString(),
				Courtyard.getFurniture("Gate"), 
				ActionChoice.Icons.exit,
				"Got To The Alchemy Shop", 
				false), 
				AlchemistTalkNode);
		
		AlchemistTalkNode.addChild(new ActionChoice(ActionNames.ShowDialog.toString(), 
				alchemist, 
				ActionChoice.Icons.talk, 
				"Talk to the Alchemist", 
				false),
				GoToAlchemyShopNode);
		
		GoToAlchemyShopNode.addChild(new ActionChoice(ActionNames.Take.toString(),
				bluePotion, 
				ActionChoice.Icons.potion,
				"Take the Blue Potion", 
				false), 
				BuyPotionNode);
		
		GoToAlchemyShopNode.addChild(new ActionChoice(ActionNames.Take.toString(),
				greenPotion, 
				ActionChoice.Icons.poison,
				"Take the Poison", 
				false), 
				BuyPoisonNode);
		
		BuyPoisonNode.addChild(new SelectionChoice(ChoiceLabels.StudyEvilBook.toString()), StudyEvilBookNode);
		
		BuyPoisonNode.addChild(new SelectionChoice(ChoiceLabels.DrinkMakesWeak.toString()), DrinkMakesWeakNode);
		
		StudyEvilBookNode.addChild(new ActionChoice(ActionNames.exit.toString(),
				alchemyShop.getFurniture("Door"), 
				ActionChoice.Icons.exit,
				"Go Back to the Courtyard", 
				false), 
				KingTalk6Node);
		
		KingTalk6Node.addChild(new ActionChoice(ActionNames.ShowDialog.toString(), 
				king, 
				ActionChoice.Icons.talk,
				"Speak with the King", 
				false), 
				GoToCourtYard1ANode);
		
		
		GoToCourtYard1ANode.addChild(new ActionChoice(ActionNames.Give.toString(),
				king, 
				ActionChoice.Icons.poison,
				"Give the Green Potion", 
				false), 
				KingDrinksPoisonNode);
		
		GoToCourtYard1ANode.addChild(new ActionChoice(ActionNames.Cast.toString(),
				king, 
				ActionChoice.Icons.firespell,
				"Cast Spells on the King", 
				false), 
				KingKillsYouNode);
		
		DrinkMakesWeakNode.addChild(new ActionChoice(ActionNames.exit.toString(),
				alchemyShop.getFurniture("Door"), 
				ActionChoice.Icons.exit,
				"Go Back to the CourtYard", 
				false), 
				KingTalk5Node);
		
		KingTalk5Node.addChild(new ActionChoice(ActionNames.ShowDialog.toString(), 
				king, 
				ActionChoice.Icons.talk,
				"Speak with the King", 
				false), 
				GoToCourtYard2ANode);
		
		GoToCourtYard2ANode.addChild(new ActionChoice(ActionNames.Attack.toString(),
				king, 
				ActionChoice.Icons.hurt,
				"Fight the King", 
				false), 
				WeakFromPoisonDieNode);
		
		GoToCourtYard2ANode.addChild(new ActionChoice(ActionNames.Cast.toString(),
				king, 
				ActionChoice.Icons.firespell,
				"Cast Spells on the King", 
				false), 
				WeakGetArrestedNode);
		
		BuyPotionNode.addChild(new ActionChoice(ActionNames.Drink.toString(),
				bluePotion, 
				ActionChoice.Icons.drink,
				"Drink the potion", 
				false), 
				DrinkGivesPowersNode);
		
		DrinkGivesPowersNode.addChild(new ActionChoice(ActionNames.exit.toString(),
				alchemyShop.getFurniture("Door"), 
				ActionChoice.Icons.exit,
				"Go Back to the CourtYard", 
				false), 
				GoToCourtYard4ANode);
		
		GoToCourtYard4ANode.addChild(new ActionChoice(ActionNames.Cast.toString(),
				king, 
				ActionChoice.Icons.firespell,
				"Cast Spells on the King", 
				false), 
				PowersBecomeKingNode);
		GoToCourtYard4ANode.addChild(new ActionChoice(ActionNames.Attack.toString(),
				king, 
				ActionChoice.Icons.hurt,
				"Attack the King", 
				false), 
				PowersNotUsedGetArrestedNode);
	
		
		// left side of story
		GreenBookNode.addChild(new PositionChoice(edith, 
				Courtyard.getFurniture("Exit"), 
				PositionChoice.Condition.arrived),  
				WarlockTalkNode);
		
		WarlockTalkNode.addChild(new ActionChoice(ActionNames.ShowDialog.toString(),
				warlock, 
				ActionChoice.Icons.talk, 
				"Talk to the Warlock", 
				false), 
				GoToCampNode);
		
		
		GoToCampNode.addChild(new ActionChoice(ActionNames.Take.toString(),
				spellBook, 
				ActionChoice.Icons.book,
				"Take the Spell Book!",
				false), 
				TakeSpellBookNode);
		
		GoToCampNode.addChild(new ActionChoice(ActionNames.Take.toString(), 
				sword, 
				ActionChoice.Icons.sword, 
				"Take the sword!", 
				false), 
				TakeSwordNode);
		
		
		TakeSwordNode.addChild(new ActionChoice(ActionNames.Take.toString(),
				torch, 
				ActionChoice.Icons.torch, 
				"Grab the torch!", 
				false), 
				TakeTorchNode);
		
		TakeSwordNode.addChild(new ActionChoice(ActionNames.Take.toString(),
				helmet, 
				ActionChoice.Icons.armour, 
				"Get your Armour!", 
				false), 
				GetArmourNode);
		
		TakeTorchNode.addChild(new ActionChoice(ActionNames.exit.toString(),
				BlackSmith.getFurniture("Door"),
				ActionChoice.Icons.door, 
				"Go Back to CourtYard to kill the King!", 
				false), 
				KingTalk4Node);

		KingTalk4Node.addChild(new ActionChoice(ActionNames.ShowDialog.toString(), 
				king, 
				ActionChoice.Icons.talk, 
				"Speak with the king", 
				false), 
				GoToCourtYard4CNode);
		
		GoToCourtYard4CNode.addChild(new ActionChoice(ActionNames.Unpocket.toString(),
				king,
				ActionChoice.Icons.sword, 
				"Attack the King with your Sword!", 
				false), 
				GuardsArrestYouNode);
		
		GoToCourtYard4CNode.addChild(new ActionChoice(ActionNames.Attack.toString(),
				king,
				ActionChoice.Icons.torch, 
				"Attack the King with your Torch!", 
				false), 
				TorchBecomeKingNode);
		
		GetArmourNode.addChild(new ActionChoice(ActionNames.exit.toString(),
				BlackSmith.getFurniture("Door"),
				ActionChoice.Icons.door, 
				"Go Back To CourtYard to kill the King!", 
				false), 
				KingTalk1Node);
		
		KingTalk1Node.addChild(new ActionChoice(ActionNames.ShowDialog.toString(),
				king, 
				ActionChoice.Icons.talk, 
				"Speak with the King", 
				false), 
				GoToCourtYard3CNode);
		
		GoToCourtYard3CNode.addChild(new ActionChoice(ActionNames.Attack.toString(),
				king,
				ActionChoice.Icons.draw, 
				"Attack the King!", 
				false), 
				SwordBecomeKingNode);
		
		GoToCourtYard3CNode.addChild(new ActionChoice(ActionNames.ShowDialog.toString(),
				king,
				ActionChoice.Icons.talk, 
				"Talk it out with King", 
				false), 
				YouDieNode);
		
		TakeSpellBookNode.addChild(new ActionChoice(ActionNames.LookAt.toString(), 
				spellBook,
				ActionChoice.Icons.research,
				"Read the new spell book to learn how to cast spells!", 
				false), 
				ReadSpellBookNode);
		TakeSpellBookNode.addChild(new SelectionChoice(ChoiceLabels.ReadGreenBook.toString()), ReadGreenBookNode);
		
		TakeSpellBookNode.addChild(new SelectionChoice(ChoiceLabels.ReadSpellBook.toString()), ReadSpellBookNode);
		
		ReadSpellBookNode.addChild(new ActionChoice(ActionNames.exit.toString(),
				BlackSmith.getFurniture("Door"),
				ActionChoice.Icons.door, 
				"Go Back to Courtyard to kill the King!", 
				false), 
				KingTalk2Node);
		
		KingTalk2Node.addChild(new ActionChoice(ActionNames.ShowDialog.toString(), 
				king, 
				ActionChoice.Icons.talk, 
				"Speak with the King", 
				false), 
				GoToCourtYard2CNode);
		
		GoToCourtYard2CNode.addChild(new ActionChoice(ActionNames.Cast.toString(),
				king,
				ActionChoice.Icons.firespell, 
				"Cast a spell on the king!", 
				false), 
				GoodSpellsKingDiesNode);
		
		GoToCourtYard2CNode.addChild(new ActionChoice(ActionNames.Attack.toString(),
				king,
				ActionChoice.Icons.fist, 
				"Fight the King!", 
				false), 
				NoSpellsGetArrestedNode);
		
		ReadGreenBookNode.addChild(new ActionChoice(ActionNames.exit.toString(), 
				BlackSmith.getFurniture("Door"), 
				ActionChoice.Icons.door, 
				"Go Back to CourtYard!", 
				false), 
				KingTalk3Node);
		
		KingTalk3Node.addChild(new ActionChoice(ActionNames.ShowDialog.toString(), 
				king, 
				ActionChoice.Icons.talk, 
				"Speak with the king", 
				false), 
				GoToCourtYard1CNode);
		
		GoToCourtYard1CNode.addChild(new ActionChoice(ActionNames.Give.toString(),
				king,
				ActionChoice.Icons.book, 
				"Show the King the Laws!", 
				false), 
				BeFriendKingNode);
		
		GoToCourtYard1CNode.addChild(new ActionChoice(ActionNames.ShowDialog.toString(),
				king,
				ActionChoice.Icons.talk, 
				"Listen to King's Response", 
				false), 
				BadTalkYouDieNode);
		
		return root;
	}
	
	public void getThings() {
		edith = new Character(ThingNames.Edith.toString(), Character.BodyTypes.C, Character.Clothing.Peasant, Character.HairStyle.Long);
		edith2 = new Character(ThingNames.ArmourEdith.toString(), Character.BodyTypes.C, Character.Clothing.LightArmour, Character.HairStyle.Long);
		king = new Character(ThingNames.King.toString(), Character.BodyTypes.H, Character.Clothing.King);
		guard1 = new Character(ThingNames.Guard.toString(), Character.BodyTypes.D, Character.Clothing.HeavyArmour);
		guard2 = new Character(ThingNames.guard2.toString(), Character.BodyTypes.D, Character.Clothing.HeavyArmour);
		guard3 = new Character(ThingNames.guard3.toString(), Character.BodyTypes.D, Character.Clothing.HeavyArmour);
		alchemist = new Character(ThingNames.Alchemist.toString(), Character.BodyTypes.B, Character.Clothing.Priest);
		fortuneteller = new Character(ThingNames.FortuneTeller.toString(), Character.BodyTypes.B, Character.Clothing.Priest);
		warlock =  new Character(ThingNames.Warlock.toString(), Character.BodyTypes.D, Character.Clothing.Warlock);
		
		BlackSmith = new Place(ThingNames.Blacksmith.toString(), Places.Blacksmith);
		alchemyShop = new Place(ThingNames.alchemyShop.toString(), Places.AlchemyShop);
		Courtyard = new Place(ThingNames.Courtyard.toString(), Places.Courtyard);
		
		sword = new Item(ThingNames.Sword.toString(), Item.Items.Sword);
		greenbook = new Item(ThingNames.greenbook.toString(), Item.Items.GreenBook);
		spellBook = new Item(ThingNames.spellBook.toString(), Item.Items.SpellBook);
		helmet = new Item(ThingNames.Helmet.toString(), Item.Items.Helmet);
		torch = new Item(ThingNames.Torch.toString(), Item.Items.Torch);
		evilbook = new Item(ThingNames.evilbook.toString(), Item.Items.EvilBook);
		bluePotion = new Item(ThingNames.bluePotion.toString(), Item.Items.BluePotion);
		greenPotion = new Item(ThingNames.greenPotion.toString(), Item.Items.GreenPotion);
		
		//Start
		greenbook = new Item(ThingNames.greenbook.toString(), Items.GreenBook);
		
		//Left Side
		spellBook = new Item(ThingNames.spellBook.toString(), Items.SpellBook);
		
		
		sword = new Item(ThingNames.Sword.toString(), Items.Sword);
		helmet = new Item(ThingNames.Helmet.toString(), Items.Helmet);
		torch = new Item(ThingNames.Torch.toString(), Items.LitTorch);
		
		
		//Right Side
		evilbook = new Item(ThingNames.evilbook.toString(), Items.EvilBook);

		
		bluePotion = new Item(ThingNames.bluePotion.toString(), Items.BluePotion);
		greenPotion = new Item(ThingNames.greenPotion.toString(), Items.GreenPotion);

	}
	
	private ActionSequence getInit() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith));
		sequence.add(new Create<Place>(Courtyard));
		sequence.add(new Position(edith, Courtyard, "Gate"));
		sequence.add(new SetCameraFocus(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	private ActionSequence getFortuneTeller() {
		var sequence = new ActionSequence();
		sequence.add(new HideMenu());
		sequence.combineWith(new CharacterCreation(guard1));
		sequence.combineWith(new CharacterCreation(guard2));
		sequence.combineWith(new CharacterCreation(guard3));
		sequence.combineWith(new CharacterCreation(fortuneteller));
		sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(fortuneteller));
		sequence.add(new SetDialog("Greetings Edith! Thou hast returned to the ancient town of Ravenholm! You and the fellow serfs hath grown miserable under the tyrannical rule of King Nikos. His oppression and greed weigheth heavily upon the shoulders of the common folk and the time for change is upon us! Thou hast been chosen to lead the rebellion. The destiny of the town lies in your hands. Choose wisely to end the reign of King Nikos and restore righteousness to the land! "));
		sequence.add(new Wait(1));
		sequence.add(new ClearDialog());
		sequence.add(new SetDialog("For your first task you can talk to me by that old stall to see which fate you choose..."));
		sequence.add(new Wait(1));
		sequence.add(new Position(fortuneteller, Courtyard, "BigStall"));
		sequence.add(new Position(guard1, Courtyard, "Horse"));
		sequence.add(new Position(guard2, Courtyard, "LeftBench.Left"));
		sequence.add(new Position(guard3, Courtyard, "RightBench.Right"));
		sequence.add(new Position(edith, Courtyard, "Gate"));
		sequence.add(new Create<Item>(greenbook));
		sequence.add(new Position(greenbook, Courtyard, "BigStall.Right"));
		sequence.add(new Create<Item>(evilbook));
		sequence.add(new Position(evilbook, Courtyard, "BigStall.Left"));
		sequence.add(new HideDialog());
		
		return sequence;
	}
	
	private ActionSequence getCourtYard() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog());
		sequence.add(new SetDialog("Good Day Edith. It is time to make a choice for which path you shall take to bring justice to the land. You may either choose the evil book or the green book. Choose Wisely!"));
		sequence.add(new Wait(1));
		sequence.add(new HideDialog());
		return sequence;
	}
	private ActionSequence getGreenBook() {
		var sequence = new ActionSequence();
		sequence.add(new Take(edith, greenbook));
		sequence.add(new ShowDialog());
		sequence.add(new SetDialog("You have chosen the green book! This is a fortune book that shows your next task is at the Blacksmiths shop! Go there now to continue your quest!"));
		sequence.add(new Wait(6));
		sequence.add(new HideDialog());
		sequence.add(new Pocket(edith, greenbook));
		return sequence;
	}
	
	private ActionSequence getWarlockTalk() {
		var sequence = new ActionSequence();
		sequence.add(new Create<Place>(BlackSmith));
		sequence.add(new Position(edith, BlackSmith, "Door"));
		sequence.combineWith(new CharacterCreation(warlock));
		sequence.add(new Position(warlock, BlackSmith, "Target"));
		sequence.add(new Create<Item>(sword));
		sequence.add(new Create<Item>(helmet));
		sequence.add(new Create<Item>(torch));
		sequence.add(new Create<Item>(spellBook));
		sequence.add(new Position(sword, BlackSmith, "Table.Right"));
		sequence.add(new Position(helmet, BlackSmith, "Table.Left"));;
		sequence.add(new Position(torch, BlackSmith, "Anvil"));
		sequence.add(new Position(spellBook, BlackSmith, "Table.FrontLeft"));
		return sequence;
	}
	
	private ActionSequence getGoToCamp() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(warlock));	
		sequence.add(new SetDialog("Greetings Edith! I am very glad the green book has sent you to my shop. I have crafted some equipment and supplies for you to battle the king with. Choose either a sword or the spellbook as your weapon."));
		sequence.add(new Wait(6));
		sequence.add(new HideDialog());
		return sequence;
	}
	
	private ActionSequence getTakeSword() {
		var sequence = new ActionSequence();
		sequence.add(new Take(edith, sword));
		sequence.add(new Pocket(edith, sword));
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(warlock));
		sequence.add(new SetDialog("The mighty sword...Good Choice Edith! You are getting ready for battle! For some extra protection against King Nikos and his guards choose either the helmet or torch"));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		return sequence;
	}
	private ActionSequence getGetArmour() {
		var sequence = new ActionSequence();
		sequence.add(new Take(edith, helmet));
		sequence.add(new Pocket(edith, helmet));
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(warlock));
		sequence.add(new SetDialog("Aye the helmet! I think I have the rest of the armour in the back of the shop. Let me get you the rest of the suit and then Edith you are ready for battle at the Kings Courtyard! Good luck we serfs are counting on you!"));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		return sequence;
	}
	
	private ActionSequence getTakeTorch() {
		var sequence = new ActionSequence();
		sequence.add(new Take(edith, torch));
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(warlock));
		sequence.add(new SetDialog("Aye the torch! You shall hopefully burn the king to the ground. You are ready for battle Edith at the Kings Courtyard. Good luck we serfs are counting on you!"));
		sequence.add(new Wait(6));
		sequence.add(new HideDialog());
		return sequence;
	}
	private ActionSequence getKingTalk1() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(edith2));
		sequence.add(new SetCameraFocus(edith2));
		sequence.add(new Position(edith2, Courtyard, "Exit"));
		sequence.combineWith(new CharacterCreation(king));
		sequence.add(new Position(king, Courtyard));
		return sequence;
	}
	
	private ActionSequence getGoToCourtYard3C() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(edith2));
		sequence.add(new SetRight(king));
		sequence.add(new SetDialog("King Nikos...You have been trating the serfs unfairly! I have come to kill you and restore the greatness of this land!"));
		sequence.add(new Wait(4));
		sequence.add(new ClearDialog());
		sequence.add(new SetLeft(king));
		sequence.add(new SetRight(edith2));
		sequence.add(new SetDialog("Edith. You are right. I have been cruel. But I promise I will make things fair! Do not kill me please!"));
		sequence.add(new Wait(4));
		sequence.add(new HideDialog());
		return sequence;
	}
	
	private ActionSequence getYouDie() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(edith2));
		sequence.add(new SetRight(king));
		sequence.add(new SetDialog("Ok King Nikos I will put down my sword..."));
		sequence.add(new Wait(4));
		sequence.add(new HideDialog());
		sequence.add(new PutDown(edith2, sword));
		sequence.add(new Unpocket(king, sword));
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(king));
		sequence.add(new SetRight(edith2));
		sequence.add(new SetDialog("Begon you peasant! I have tricked you! I will rule forever and ever! You are standing in my way so you must die!"));
		sequence.add(new Wait(4));
		sequence.add(new HideDialog());
		sequence.add(new Attack(king, edith2, true));
		sequence.add(new Die(edith2));
		sequence.add(new SetCameraFocus(king));
		sequence.add(new Dance(king));
		sequence.add(new ShowMenu(true));
		
		return sequence;
	}
	
	private ActionSequence getSwordBecomeKing() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(edith2));
		sequence.add(new SetRight(king));
		sequence.add(new SetDialog("Begon King Nikos! You must die for the good of the town! I will be the Queen now!"));
		sequence.add(new Wait(4));
		sequence.add(new HideDialog());
		sequence.add(new Draw(edith2, sword));
		sequence.add(new Attack(edith2, king, true));
		sequence.add(new Die(king));
		sequence.add(new SetLeft(edith2));
		sequence.add(new SetDialog("Begon King Nikos! I am Queen now! The faith and goodness of the serfs and the kingdom is restored!"));
		sequence.add(new Dance(edith2));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getKingTalk4() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(king));
		sequence.add(new Position(king, Courtyard));
		sequence.add(new Position(edith, Courtyard, "Exit"));
		return sequence;
	}
	
	private ActionSequence getGoToCourtYard4C() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(edith));
		sequence.add(new SetRight(king));
		sequence.add(new SetDialog("King Nikos...You've been treating the peasants unfairly. I've come to kill you and burn this castle to the ground!!!"));
		sequence.add(new Wait(4));
		sequence.add(new ClearDialog());
		sequence.add(new SetLeft(king));
		sequence.add(new SetRight(edith));
		sequence.add(new SetDialog("Dear Edith..I will make things fair I promise! Don't kill me please, I beg you!"));
		sequence.add(new Wait(4));
		sequence.add(new HideDialog());
		return sequence;
	}
	
	private ActionSequence getTorchBecomeKing() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(edith));
		sequence.add(new SetRight(king));
		sequence.add(new SetDialog("It's too late for apologies! You must die King Nikos for the good of the town!"));
		sequence.add(new Wait(4));
		sequence.add(new HideDialog());
		sequence.add(new Attack(edith, king, false));
		sequence.add(new Die(king));
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(edith));
		sequence.add(new SetDialog("Begone King Nikos! I'm the Queen now! hahahaha!"));
		sequence.add(new Wait(4));
		sequence.add(new HideDialog());
		sequence.add(new Dance(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getGuardsArrestYou() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(edith));
		sequence.add(new SetRight(king));
		sequence.add(new SetDialog("It's too late for apologies King Nikos! You must die for the good of the land!"));
		sequence.add(new Wait(4));
		sequence.add(new HideDialog());
		sequence.add(new PutDown(edith, torch));
		sequence.add(new Draw(edith, sword));
		sequence.add(new Attack(edith, king, false));;
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(king));
		sequence.add(new SetRight(edith));
		sequence.add(new SetDialog("Guards come quick arrest that heathen!!!"));
		sequence.add(new Wait(4));
		sequence.add(new HideDialog());
		sequence.add(new WalkTo(guard1, edith));
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(guard1));
		sequence.add(new SetRight(edith));
		sequence.add(new SetDialog("Edith you are arrested for treason and are banished to the scary island!"));
		sequence.add(new Wait(4));
		sequence.add(new ClearDialog());
		sequence.add(new SetLeft(edith));
		sequence.add(new SetRight(guard1));
		sequence.add(new SetDialog("Noooo I have failed the serfs! King Nikos will reign forever and ever now!!!"));
		sequence.add(new Wait(4));
		sequence.add(new HideDialog());
		sequence.add(new Dance(guard1));
		sequence.add(new Dance(king));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	//New Branch
	private ActionSequence getTakeSpellBook() {
		var sequence = new ActionSequence();
		sequence.add(new Take(edith, spellBook));
		sequence.add(new Pocket(edith, spellBook));
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(warlock));
		sequence.add(new SetDialog("Now you have two books of wisdom. You now can choose to either read the greenbook from the courtyard or the spellbook you just took. Which would you like to read Edith?"));
		sequence.add(new SetDialog("[ReadGreenBook|Read the Green Book!]"));
		sequence.add(new SetDialog("[ReadSpellBook|Read the Spell Book!]"));
		return sequence;
	}
	
	private ActionSequence getReadSpellBook() {
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(warlock));
		sequence.add(new SetDialog("Spellbook... Good Choice Edith! You now must study this spellbook to gain knowledge of spells that will help you defeat the evil king!"));
		sequence.add(new Wait(1));
		sequence.add(new HideDialog());
		sequence.add(new Unpocket(edith, spellBook));
		sequence.add(new LookAt(edith, spellBook));
		sequence.add(new Wait(1));
		sequence.add(new Pocket(edith, spellBook));
		sequence.add(new ShowDialog());
		sequence.add(new SetDialog("Aye you have learned the firespell! This will help you greatly to defeat the King. Go now to the Courtyard! Good Luck Edith the faith of our freedom is in your hands!"));
		sequence.add(new Wait(1));
		sequence.add(new HideDialog());
		
		return sequence;
	}
	private ActionSequence getKingTalk2() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(king));
		sequence.add(new Position(king, Courtyard));
		sequence.add(new Position(edith, Courtyard, "Exit"));
		return sequence;
	}
	
	private ActionSequence getGoToCourtYard2C() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(edith));
		sequence.add(new SetRight(king));
		sequence.add(new SetDialog("King Nikos...You have been trating the serfs unfairly! I have come to kill you and restore the greatness of this land!"));
		sequence.add(new Wait(1));
		sequence.add(new ClearDialog());
		sequence.add(new SetLeft(king));
		sequence.add(new SetRight(edith));
		sequence.add(new SetDialog("Edith. You are right. I have been cruel. But I promise I will make things fair! Do not kill me please!"));
		sequence.add(new Wait(1));
		sequence.add(new HideDialog());
		return sequence;
	}
	
	private ActionSequence getNoSpellsGetArrested() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(edith));
		sequence.add(new SetRight(king));
		sequence.add(new SetDialog("It's too late for apologies! It is time to battle to the death!"));
		sequence.add(new Wait(4));
		sequence.add(new HideDialog());
		sequence.add(new Attack(edith, king, false));
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(king));
		sequence.add(new SetRight(guard1));
		sequence.add(new SetDialog("Oww! Guards arrest that heathen!!!"));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		sequence.add(new WalkTo(guard1, edith));
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(guard1));
		sequence.add(new SetRight(edith));
		sequence.add(new SetDialog("Edith you are arrested for treason and are banished to the scary island!"));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		sequence.add(new Dance(king));
		sequence.add(new Dance(guard1));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getGoodSpellsKingDies() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(edith));
		sequence.add(new SetRight(king));
		sequence.add(new SetDialog("It's too late for apologies! I cast you away King Nikos!"));
		sequence.add(new Wait(4));
		sequence.add(new ClearDialog());		
		sequence.add(new HideDialog());
		sequence.add(new Cast(edith, king, "red"));
		sequence.add(new Die(king));
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(edith));
		sequence.add(new SetDialog("Begon King Nikos I am the Queen now! hahahaha!"));
		sequence.add(new Wait(4));
		sequence.add(new HideDialog());
		sequence.add(new Dance(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getReadGreenBook() {
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(warlock));
		sequence.add(new SetDialog("Good Choice Edith! You now must study the greenbook to gain knowledge of the laws of the land that will help you overthrow the evil king!"));
		sequence.add(new Wait(1));
		sequence.add(new HideDialog());
		sequence.add(new Unpocket(edith, greenbook));
		sequence.add(new LookAt(edith, greenbook));
		sequence.add(new Wait(1));
		sequence.add(new Pocket(edith, greenbook));
		sequence.add(new ShowDialog());
		sequence.add(new SetDialog("Aye you have read the laws of the land in the greenbook! You have learned the Law of Dinglesh that states that a King who has reigned for more than 10 years must give up his throne. King Nikos has reigned for nearly 20 years! Present this law to the king and hopefully it will help end his reign! Go now to the Courtyard! Good Luck Edith the faith of our freedom is in your hands!"));
		sequence.add(new Wait(1));
		sequence.add(new HideDialog());
		
		return sequence;
	}
	
	private ActionSequence getKingTalk3() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(king));
		sequence.add(new Position(king, Courtyard));
		sequence.add(new Position(edith, Courtyard, "Exit"));
		
		return sequence;
	}
	
	private ActionSequence getGoToCourtYard1C() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(edith));
		sequence.add(new SetRight(king));
		sequence.add(new SetDialog("King Nikos...you have been treating the serfs unfairly for too long. It is time for your reign to end. I have read the laws of the land and have knowledge of the Law of Dinglesh! Give up your crown now and will spare your life!"));
		sequence.add(new Wait(1));
		sequence.add(new HideDialog());
		return sequence;
	}
	
	private ActionSequence getBeFriendKing() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(king));
		sequence.add(new SetRight(edith));
		sequence.add(new SetDialog("Here...Read the green book yourself to see the laws of the land."));
		sequence.add(new Wait(1));
		sequence.add(new HideDialog());
		sequence.add(new Give(edith, greenbook, king));
		sequence.add(new LookAt(king, greenbook));
		sequence.add(new Wait(5));
		sequence.add(new Pocket(king, greenbook));
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(king));
		sequence.add(new SetRight(edith));
		sequence.add(new SetDialog("Edith you are right. I cannot go against the law of the land. My reign should have ended a decade ago. I will give up my crown. I apologize to all the serfs of the land I have treated unfairly. You must rule now Edith! I give up my crown to you!"));
		sequence.add(new Wait(2));
		sequence.add(new ClearDialog());
		sequence.add(new SetLeft(edith));
		sequence.add(new SetRight(king));
		sequence.add(new SetDialog("Hurrah! There is peace restored to the town!"));
		sequence.add(new Wait(2));
		sequence.add(new HideDialog());
		sequence.add(new Dance(edith));
		sequence.add(new Dance(king));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getBadTalkYouDie() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(king));
		sequence.add(new SetRight(edith));
		sequence.add(new SetDialog("Edith how did you find the law of the land! That is supposed to be secure in my courtyard! Nevertheless I do not care about the law. I will reign forever and ever!"));
		sequence.add(new Wait(2));
		sequence.add(new ClearDialog());
		sequence.add(new SetLeft(king));
		sequence.add(new SetRight(edith));
		sequence.add(new SetDialog("Nikos you have left me no choice. I must kill you for the good of the town!"));
		sequence.add(new Wait(2));
		sequence.add(new HideDialog());
		sequence.add(new Attack(edith, king, false));
		sequence.add(new Die(king));
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(edith));
		sequence.add(new SetRight(king));
		sequence.add(new SetDialog("Hurrah! I have killed the king and peace is restored to the land!"));
		sequence.add(new Wait(2));
		sequence.add(new HideDialog());
		sequence.add(new Dance(edith));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	
	// EVIL BOOK SIDE
	private ActionSequence getEvilBook() {
		var sequence = new ActionSequence();
		sequence.add(new Take(edith, evilbook));
		sequence.add(new Pocket(edith, evilbook));
		return sequence;
	}
	
	private ActionSequence getAlchemistTalk() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(alchemist));
		sequence.add(new Create<Place>(alchemyShop));
		sequence.add(new Position(alchemist, alchemyShop, "Bar.Behind"));
		sequence.add(new Position(edith, alchemyShop));
		sequence.add(new Create<Item>(greenPotion));
		sequence.add(new Position(greenPotion, alchemyShop, "Bar.Left"));
		sequence.add(new Create<Item>(bluePotion));
		sequence.add(new Position(bluePotion, alchemyShop, "Bar.Right"));
		return sequence;
	}
	
	private ActionSequence getGoToAlchemyShop() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(alchemist));
		sequence.add(new SetRight(edith));
		sequence.add(new SetDialog("Good Day Edith! Welcome to my Alchemy Shop! I have brewed a couple potions just for you. I did not exactly write down my recipe for the potions so I am not sure the exact effects of them but go ahead and look around and pick one!"));
		sequence.add(new Wait(6));
		sequence.add(new HideDialog());
		return sequence;
	}

	private ActionSequence getBuyPoison() {
		var sequence = new ActionSequence();
		sequence.add(new Take(edith, greenPotion, alchemyShop.getFurniture("Bar.Left")));
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(alchemist));
		sequence.add(new SetRight(edith));
		sequence.add(new SetDialog("Oooo the green potion...Now would you like to drink that nice green potion or study the evil book you got from the Kings Courtyard?"));
		sequence.add(new SetDialog("[DrinkMakesWeak|Drink the Green Potion!]"));
		sequence.add(new SetDialog("[StudyEvilBook|Study the Book!]"));
		return sequence;
	}

	private ActionSequence getStudyEvilBook() {
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		sequence.add(new LookAt(edith, evilbook));
		sequence.add(new Wait(3));
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(alchemist));
		sequence.add(new SetRight(edith));
		sequence.add(new SetDialog("Aye the evil book....Good choice Edith. From reading this dark book you have learned the poisionous aqua spell. This should help you take down the King! You are ready now Edith. Good luck Edith we serfs are couting on you!"));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		return sequence;
	}
	
	private ActionSequence getKingTalk6() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(edith));
		sequence.add(new SetRight(king));
		sequence.add(new SetDialog("King Nikos...you have been treating the serfs unfairly. It is time for your reign to end!"));
		sequence.add(new Wait(4));
		sequence.add(new ClearDialog());
		sequence.add(new SetLeft(king));
		sequence.add(new SetRight(edith));
		sequence.add(new SetDialog("I will never give up my crown! I will reign forever and ever!"));
		sequence.add(new Wait(4));
		sequence.add(new HideDialog());
		return sequence;
		
	}
	
	private ActionSequence getGoToCourtYard1A() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(edith));
		sequence.add(new SetRight(king));
		sequence.add(new SetDialog("King Nikos...you have been treating the serfs unfairly for too long. It is time for your reign to end. I have read the laws of the land and have knowledge of the Law of Dinglesh! Give up your crown now and will spare your life!"));
		sequence.add(new Wait(1));
		sequence.add(new HideDialog());
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
		sequence.add(new HideDialog());
		sequence.add(new Drink(edith));
		sequence.add(new Pocket(edith, greenPotion));
		return sequence;
	}

	private ActionSequence getKingTalk5 () {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(king));
		sequence.add(new Position(king, Courtyard));
		sequence.add(new Position(edith, Courtyard, "Exit"));
		return sequence;
	}
	
	private ActionSequence getGoToCourtYard2A() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog());
		sequence.add(new SetLeft(edith));
		sequence.add(new SetRight(king));
		sequence.add(new SetDialog("King Nikos...you have been treating the serfs unfairly for too long. It is time for your reign to end. I have read the laws of the land and have knowledge of the Law of Dinglesh! Give up your crown now and will spare your life!"));
		sequence.add(new Wait(1));
		sequence.add(new HideDialog());
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
		sequence.add(new SetDialog("Mr. Alchemist Im on a revolution to kill the king, what potion should I choose?"));
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
		sequence.add(new Position(king, Courtyard));
		sequence.add(new Position(edith, Courtyard));
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
		map.add(NodeLabels.FortuneTeller.toString(), getFortuneTeller());
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
		map.add(NodeLabels.ReadGreenBook.toString(), getReadGreenBook());
		map.add(NodeLabels.GoToCourtYard1C.toString(), getGoToCourtYard1C());
		map.add(NodeLabels.BadTalkYouDie.toString(), getBadTalkYouDie());
		map.add(NodeLabels.BeFriendKing.toString(), getBeFriendKing());
		map.add(NodeLabels.WarlockTalk.toString(), getWarlockTalk());
		map.add(NodeLabels.KingTalk1.toString(), getKingTalk1());
		map.add(NodeLabels.KingTalk2.toString(), getKingTalk2());
		map.add(NodeLabels.KingTalk3.toString(), getKingTalk3());
		map.add(NodeLabels.KingTalk4.toString(), getKingTalk4());
		map.add(NodeLabels.AlchemistTalk.toString(),  getAlchemistTalk());
		map.add(NodeLabels.KingTalk5.toString(), getKingTalk5());
		map.add(NodeLabels.KingTalk6.toString(), getKingTalk5());
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

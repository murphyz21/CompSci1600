package com.entities;

public class PositionChoice implements IEntity {
	enum Condition{
		arrived,
		exited
	}
	
	private IEntity entity;
	private Character character;
	private Condition condition;
	
	public PositionChoice(Character character, IEntity entity, Condition condition) {
		this.character = character;
		this.entity = entity;
		this.condition = condition;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}

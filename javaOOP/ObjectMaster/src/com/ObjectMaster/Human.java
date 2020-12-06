package com.ObjectMaster;

public class Human {
	
	public int strength = 3;
	public int intelligence = 3;
	public int stealth = 3;
	public int health = 100;
	
//	targeting something to attack. Human is attacking another "human victim"
	public Integer attackHuman(Human victim) {
		
		//this is a self-referential key word
		victim.health -= this.strength;
		return health;
	}
	
	public Integer displayHealth() {
		return health;
	}
	
}

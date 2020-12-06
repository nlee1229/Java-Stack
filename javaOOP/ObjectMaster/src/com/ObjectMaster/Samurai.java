package com.ObjectMaster;

public class Samurai extends Human{
	
	public int health = 200;
//	put in static in order to increase total # of samurais
	public static int samu = 0;
	
	//constructor for howMany
	public Samurai() {
		samu += 1;
	}
	
	public Integer deathBlow(Human victim) {
		
		//kills the other Human
		victim.health -= victim.health;
		
		//samurai's health is cut in half
		health -= health/2;
		
		return health;
	}
	//don't need to return therefore we put void
	public void meditate() {
		this.health += this.health/2;
		System.out.println("Samurai healed itself: " + health);
	}
	
	public Integer howMany() {
		return (samu);
		
	}

}

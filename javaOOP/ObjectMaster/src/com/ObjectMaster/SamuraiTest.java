package com.ObjectMaster;

public class SamuraiTest {
	
	public static void main(String[] args) {
		
		Samurai s = new Samurai();
		Samurai u = new Samurai();
		Samurai c = new Samurai();
		Samurai k = new Samurai();
		
		Human h = new Human();
		
		s.deathBlow(h);
		System.out.println("Samurai Health: " + s.displayHealth());
		System.out.println("Human Health: " + h.displayHealth());
		
		s.meditate();
		
		//howMany
		System.out.println("Total current number of Samurai: " + s.howMany());
	}
}

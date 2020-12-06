package com.Nicholas;

public class Bat extends Mammal {

	public Integer fly() {
		this.energyLevel -= 50;
		System.out.println("sksksksks");
		return energyLevel;
	}
	
	public Integer eatHumans() {
		this.energyLevel += 25;
		return energyLevel;
	}
	
	public Integer attackTown() {
		this.energyLevel -= 100;
		System.out.println("FIREE, THERE'S A FIRE!");
		return energyLevel;
	}
}
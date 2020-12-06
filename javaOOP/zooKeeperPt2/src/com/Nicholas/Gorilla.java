package com.Nicholas;

public class Gorilla extends Mammal{
	
	
	public Integer throwSomething() {
//		subtracting 5 from energyLevel
		energyLevel -= 5;
		return energyLevel;
	}
	
	public Integer eatBananas() {
		energyLevel += 10;
		return energyLevel;
	}
	
	public Integer climb() {
		energyLevel -= 10;
		return energyLevel;
	}
}


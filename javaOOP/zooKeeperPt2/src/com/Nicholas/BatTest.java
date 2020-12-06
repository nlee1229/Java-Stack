package com.Nicholas;

public class BatTest {

	public static void main(String[] args) {
		
		Bat b = new Bat();
		// For Fly Class
		b.attackTown();
		b.attackTown();
		b.attackTown();
		
		b.eatHumans();
		b.eatHumans();

		b.fly();
		b.fly();
		
		System.out.println(b.displayEnergy());

	}

}

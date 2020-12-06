package com.ObjectMaster;

public class WizardTest {

	public static void main(String[] args) {
		
		Wizard w = new Wizard();
		
		Human h = new Human();
		
		//instantiating the method(w), activating the method (.heal), passing in the argument (h) that grabs it from the Wizard.java
		w.heal(h);
		System.out.println(h.displayHealth());
		
		w.fireball(h);
		System.out.println(h.displayHealth());
			

	}

}

package com.BankAccount;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class BankAccount {
	
//	Users should not be able to set any of the attributes from the class.
	
	private String acntNum;
	private double chkBal;
	private double savBal;
	
	public static int allAcnts = 0;
	public static double totalMoney = 0;
	
	public BankAccount() {
		ArrayList <Integer> RandActNum = new ArrayList <Integer>();
		RandActNum = randomActNum();
		//convert from ArrayList of integers into an integer array that is the size of the array list
	    Integer[] convert = RandActNum.toArray(new Integer[RandActNum.size()]);
	    //convert from Integer array into String
	    String conv = Arrays.toString(convert);
	    //give line 9 a value. Setting the account num variable to conv
	    acntNum = conv;
	    //incrementing account count
	    allAcnts += 1;
	    
		
	}

//	 Create a private method that returns a random ten digit account number (randomActNum)
	private ArrayList <Integer> randomActNum() {
		//creating an instance of random 
	    Random r = new Random(); 
	    //---------------------------------
	    ArrayList <Integer> RandActNum = new ArrayList <Integer>();
	    for (int i=0; i < 10; i++) {
	        RandActNum.add(r.nextInt(10));
	    }
	    return(RandActNum);
	}
	
	//getter
	public String getAccountNumber() {
		return(acntNum);
	}
	
	public int getTotalAct() {
		return(allAcnts);
	}
	
	public double getCheckBalance() {
		return(chkBal);
	}
	
	public double getSavBalance() {
		return(savBal);
	}
	
//	Create a method that will allow a user to deposit money 
//	into either the checking or saving, be sure to add to total 
//	amount stored
	
	public void chkDepositMoney(double caching) {
		chkBal += caching;
		//adding to the totalMoney so that we can use in totalChk method later to see total $
		totalMoney += caching;
	}
	
	public void savDepositMoney(double caching) {
		savBal += caching;
		totalMoney += caching;
	}
	
//	Create a method to withdraw money from one balance. Do not allow them to
//	withdraw money if there are insufficient funds.
	
	public void withdrawChecking(double caching) {
		if (chkBal > 0 && caching <= chkBal) {
			chkBal -= caching;
			totalMoney -= caching;
		}
		else {
			System.out.println("Insufficient funds!!! Congrats, you're poor af.");
		}
	}
	
	public void withdrawSavings(double caching) {
		if (savBal > 0 && caching <= savBal) {
			savBal -= caching;
			totalMoney -= caching;
		}
		else {
			System.out.println("Insufficient funds!!! Congrats, you're poor af.");
		}
	}
		
//	Create a method to see the total money from the checking and saving.
	
	public double getTotalMoney() {
		return(totalMoney);
	}
	
}

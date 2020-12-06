package com.BankAccount;

public class BankAccountTest {

	public static void main(String[] args) {
	
		//testing
		BankAccount ba = new BankAccount();
		BankAccount bb = new BankAccount();
		
		
		System.out.println(ba.getAccountNumber());
		System.out.println(bb.getAccountNumber());
		
		System.out.println(ba.getTotalAct());
		
		System.out.println(ba.getCheckBalance());
		
		System.out.println(ba.getSavBalance());
		
		//testing for chkDepositMoney & savDepositMoney
		
		ba.chkDepositMoney(250);
		System.out.println("Checking balance: " + ba.getCheckBalance());
		
		ba.savDepositMoney(69);
		System.out.println("Savings balance: " + ba.getSavBalance());
		
		//testing withdraw methods for checking and savings
		ba.withdrawChecking(290);
		System.out.println("Balance after withdraw for checking: " + ba.getCheckBalance());
		
		ba.withdrawSavings(27);
		System.out.println("Balance after withdraw for savings: " + ba.getSavBalance());
		
//		bb.savDepositMoney(20);
		
		//testing for getTotalMoney
		System.out.println("Total balance: " + ba.getTotalMoney());
	}

}

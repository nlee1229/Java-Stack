package com.Nicholas.Phone;

public class IPhone extends Phone implements Ringable {
	
	//constructor
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    
    @Override
    public String ring() {
        // your code here
    }
    
    @Override
    public String unlock() {
        // your code here
    }
    
    @Override
    public void displayInfo() {
        // your code here            
    }
}

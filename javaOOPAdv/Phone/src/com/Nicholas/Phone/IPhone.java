package com.Nicholas.Phone;

public class IPhone extends Phone implements Ringable {
	
	//constructor
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    
    @Override
    public String ring() {
        // your code here
    	String irt = "iPhone x says" + getRingtone();
    	return irt;
    }
    
    @Override
    public String unlock() {
        // your code here
    	String u = "Unlocking via facial recognition.";
    	return u;
    }
    
    @Override
    public void displayInfo() {
        // your code here   
    	String d = getDevice();
    	int bp = getBattPercent();
    	String c = getCarrier();
    	String rt = getRingtone();
    	System.out.println("Device: " + d + "Battery: " + bp + ", Carrier: " + c + " Ringtone: " + rt);
    }
}

package com.Nicholas.Phone;

public interface Ringable {

	default String ring() {
		String defaultRing = "Ringgggg";
		return defaultRing;
	}
	
	default String unlock() {
		String defaultUnlock = "iPhone unlocked, now what?";
		return defaultUnlock;
	}
}
	

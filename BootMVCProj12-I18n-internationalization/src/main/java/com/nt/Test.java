package com.nt;

import java.util.Locale;

public class Test {

	public static void main(String[] args) {
	
		Locale[] locale = Locale.getAvailableLocales(); 
		
		System.out.println(locale.length);
		
		for(Locale l : locale) {
			System.out.println(l);
		}
	}

}

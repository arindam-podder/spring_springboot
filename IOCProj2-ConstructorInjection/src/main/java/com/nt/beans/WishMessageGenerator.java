package com.nt.beans;

import java.util.Date;

public class WishMessageGenerator {
	//HAS-A property (composition)
	private Date date;

	//constructor
/*	public WishMessageGenerator(Date date) {
		System.out.println("WishMessageGenerator :-> 0-param constructor");
		this.date = date;
	}
*/
	//constructor with diiferent param name
	public WishMessageGenerator(Date d) {
		System.out.println("WishMessageGenerator :-> 0-param constructor");
		this.date = d;	
	}
	
	
	public String wishMessage(String name) {
		int hour = date.getHours();	//24 hour format (0 to 23)
		if(hour<11) {
			return "Good Morning : "+name;
		}else if(hour<16) {
			return "Good Afternoon : "+name;			
		}else if(hour<20) {
			return "Good Evening : "+name;			
		}
		else {
			return "Good Night : "+name;			
			
		}
	}
	
	
	
}//cls end

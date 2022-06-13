package com.nt.beans;

import java.util.Date;

public class WishMessageGenerator {
	//HAS-A property (composition)
	private Date date;

	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator :-> 0-param constructor");
	}

	//setter method 
/*	public void setDate(Date date) {
		System.out.println("WishMessageGenerator :-> Setter method"); 
		this.date = date; 
	}
*/	 
	
	//setter method with different name 
	public void setDate1(Date date) {
		System.out.println("WishMessageGenerator :-> Setter method");
		this.date = date;
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

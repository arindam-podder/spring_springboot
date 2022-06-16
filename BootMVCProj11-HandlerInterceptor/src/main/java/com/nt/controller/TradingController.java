package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TradingController {
	
	@GetMapping(path = "/")
	public String home() {
		return "home";
	}
	
	@GetMapping(path = "/trade")
	public String tradeNow() {
		return "trade_page";
	}
	
	@GetMapping(path = "/details")
	public String tradeDetails() {
		return "trade_details";
	}
	
}//class end

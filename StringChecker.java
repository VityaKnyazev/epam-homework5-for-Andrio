package com.kniazeu.homework05;


public class StringChecker {
	private String str;
	private final String regExp1 = "^[a-zA-Z]{1}:/[a-zA-z0-9-_]{1,18}$";
	private final String regExp2 = "^[a-zA-Z]{1}:/[a-zA-z0-9-_]{1,18}/[a-zA-z0-9-_]{1,18}$";
	private final String regExp3 = "^[a-zA-Z]{1}:/[a-zA-z0-9-_]{1,18}/[a-zA-z0-9-_]{1,18}/[a-zA-z0-9-_]{1,18}$";
	
	private final String regExp4 = "^[a-zA-Z]{1}:/[a-zA-z0-9-_]{1,12}.[a-zA-z0-9-_]{1,3}$";	
	private final String regExp5 = "^[a-zA-Z]{1}:/[a-zA-z0-9-_]{1,18}/[a-zA-z0-9-_]{1,12}.[a-zA-z0-9-_]{1,3}$";
	private final String regExp6 = "^[a-zA-Z]{1}:/[a-zA-z0-9-_]{1,18}/[a-zA-z0-9-_]{1,18}/[a-zA-z0-9-_]{1,12}.[a-zA-z0-9-_]{1,3}$";
	private final String regExp7 = "^[a-zA-Z]{1}:/[a-zA-z0-9-_]{1,18}/[a-zA-z0-9-_]{1,18}/[a-zA-z0-9-_]{1,18}/[a-zA-z0-9-_]{1,12}.[a-zA-z0-9-_]{1,3}$"; 
				
	public StringChecker(String str) {
		this.str = str;
	}
	
	public String checkAndReturnPath() throws PathException {		
		if (!(str.matches(regExp1) || str.matches(regExp2) || str.matches(regExp3) || str.matches(regExp4) || str.matches(regExp5) || str.matches(regExp6) || str.matches(regExp7))) {
			throw new PathException("Input path can have only three folders and one file!");
		}
		
		return str;
	}
}

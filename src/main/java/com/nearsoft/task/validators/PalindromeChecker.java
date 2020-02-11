package com.nearsoft.task.validators;

import com.sun.media.sound.InvalidDataException;

public class PalindromeChecker {
	
	@SuppressWarnings("null")
	public static boolean check(String palidrome) { 
		
		if(palidrome == null ) {
			return false;
		}
		
		palidrome = palidrome.replaceAll("[^a-zA-Z]+", "");
		
		StringBuilder reversed = new StringBuilder(palidrome).reverse();
		
		if( palidrome.equalsIgnoreCase(reversed.toString()) )
		{
			return true;
		}
		return false;
	}
}

package com.isbnumber_verifier;

import static org.junit.Assert.*;

import org.junit.Test;

import com.isbnumber_verifier.ISBookNumber_VERIFIER;

public class ISBookNumber_VERIFIER_Test {
	/*
	 * Harry Potter And The Sorcerer's Stone Hardcover
	 * ISBN-10: 0590353403
       ISBN-13: 978-0590353403
       
       The Lord of the Rings: One Volume
       ISBN-10: 0618645616
       
	 */
	
	@Test
	public void check_A_Valid_ISBN_with_10Digits() {
		ISBookNumber_VERIFIER validator = new ISBookNumber_VERIFIER();
		boolean result = validator.checkISBN("0590353403");
		assertTrue("first value", result);
		
		result = validator.checkISBN("0618645616");
		assertTrue("second value",result);
	}
	
	/*
	 * Alice's Adventures in Wonderland & Through the Looking-Glass
	 * ISBN-10: 9780553213454
       ISBN-13: 978-0553213454
	 * 
	 * Pride and Prejudice 
	 * ISBN-10: 0199535566
       ISBN-13: 978-0199535569
	 */
	
	@Test
	public  void check_A_Valid_ISBN_with_13Digits( ) {
		ISBookNumber_VERIFIER validator = new ISBookNumber_VERIFIER();
		boolean result = validator.checkISBN("9780553213454");
		assertTrue("first value", result);
		
		result = validator.checkISBN("9780199535569");
		assertTrue("second value",result);
		
		
	}
	
	/*
	 * The Thief Lord
       by Cornelia Funke
	 */
	
	@Test
	public void  TenDigitISBNNumbersEndingInAnXAreValid() {
		ISBookNumber_VERIFIER validator = new ISBookNumber_VERIFIER();
		boolean result = validator.checkISBN("043942089X");
		assertTrue(result);
	}
	


	@Test
	public void check_An_InValid_ISBN_with_10Digits() {
		ISBookNumber_VERIFIER validator = new ISBookNumber_VERIFIER();
		boolean result = validator.checkISBN("0590353404");
		assertFalse(result);
	}
	
	@Test
	public void  check_an_InvalidISBN_with_13Digidts() {
		ISBookNumber_VERIFIER validator = new ISBookNumber_VERIFIER();
		boolean result = validator.checkISBN("9780553213455");
		assertFalse(result);
	}
	
	
	
	
	@Test(expected = NumberFormatException.class)
	public  void  nineDigitISBNsAreNotAllowed() {
		ISBookNumber_VERIFIER validator = new ISBookNumber_VERIFIER();
		 validator.checkISBN("987654321");
	}
	
	@Test(expected = NumberFormatException.class)
	public void  nonNumericISBNAreNotAllowed() {
		ISBookNumber_VERIFIER validator = new ISBookNumber_VERIFIER();
		 validator.checkISBN("hellothere");
	}
	
	
	
}

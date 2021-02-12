package com.shankar.TDDExample;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**@author 
 * ShankarI
 * Unit test for simple App.
 */
public class StringCalculatorTest {
	
	StringCalculator sc=new StringCalculator();
	
	//1.Checking for null/blank input
	@Test
	public void CheckingBlankInput(){
		assertTrue(sc.Add("")==0);
	}
	
	//2.Checking for single input
	@Test
	public void checkingForSingleInput() {
		assertTrue(sc.Add("1")==1);
	}
		
	//3.Checking for allowd separated by , and \n  delimeter
	@Test
	public void checkingForDelimeter() {
		assertTrue(sc.Add("1,2\n3")==6);
	}
		
	//4.Checking for ignore number < 1000
	@Test
	public void ignoreInputAfter1000() {
		assertTrue(sc.Add("1,2\n1000")==1003);
	}
	
	//5.Checking for starts input with // and then default delimeter is ';'
	@Test
	public void supportDifferentDelimeter() {
		assertTrue(sc.Add("//;\n1;2")==3);
	}

	//6.Checking for single negative number
	@Test(expected=IllegalArgumentException.class)
	public void handleExceptionForNegativeNumber() throws IllegalArgumentException {
		
		sc.Add("-1");
	}
	
	//7.Checking for multiple negative numbers
	@Test(expected=IllegalArgumentException.class)
	public void handleExceptionForMultipleNegativeNumber() throws IllegalArgumentException {
	
		sc.Add("-1\n-2,-3");
	}
	

}

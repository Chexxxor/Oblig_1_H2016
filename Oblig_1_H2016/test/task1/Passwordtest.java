package task1;

import static org.junit.Assert.*;

import org.junit.Test;

public class Passwordtest {
	static public String passwordShort = "a1";
	static public String passwordOnlyLetters = "abcde";
	static public String passwordOnlyNumbers = "12345";
	static public String passwordWithMixedLettersAndNumbers = "a2b3c4d5";
	static public String passwordWithSpecialChars = "$bcde%&/1234";
	static public String passwordWithNumbersFirst = "12345abcde";
	static public String passwordWithLettersFirst = "abcde12345";
	
	@Test
	public void checkLengthtest() {
		assertEquals(true, Password.checkForOnlyDigitsAndLetters(passwordShort));
		assertEquals(true, Password.checkForOnlyDigitsAndLetters(passwordOnlyLetters));
		assertEquals(true, Password.checkForOnlyDigitsAndLetters(passwordOnlyNumbers));
		assertEquals(true, Password.checkForOnlyDigitsAndLetters(passwordWithMixedLettersAndNumbers));
		assertEquals(false, Password.checkForOnlyDigitsAndLetters(passwordWithSpecialChars));
		assertEquals(true, Password.checkForOnlyDigitsAndLetters(passwordWithNumbersFirst));
		assertEquals(true, Password.checkForOnlyDigitsAndLetters(passwordWithLettersFirst));
	}
	
	@Test
	public void checkForOnlyDigitsAndLetterstest() {
		assertEquals(true, Password.checkForOnlyDigitsAndLetters(passwordShort));
		assertEquals(true, Password.checkForOnlyDigitsAndLetters(passwordOnlyLetters));
		assertEquals(true, Password.checkForOnlyDigitsAndLetters(passwordOnlyNumbers));
		assertEquals(true, Password.checkForOnlyDigitsAndLetters(passwordWithMixedLettersAndNumbers));
		assertEquals(false, Password.checkForOnlyDigitsAndLetters(passwordWithSpecialChars));
		assertEquals(true, Password.checkForOnlyDigitsAndLetters(passwordWithNumbersFirst));
		assertEquals(true, Password.checkForOnlyDigitsAndLetters(passwordWithLettersFirst));
	}
	
	@Test
	public void checkThatContainsAtLeastThreeDigitstest(){
		assertEquals(false, Password.checkThatContainsAtLeastThreeDigits(passwordShort));
		assertEquals(false, Password.checkThatContainsAtLeastThreeDigits(passwordOnlyLetters));
		assertEquals(true, Password.checkThatContainsAtLeastThreeDigits(passwordOnlyNumbers));
		assertEquals(false, Password.checkThatContainsAtLeastThreeDigits(passwordWithMixedLettersAndNumbers));
		assertEquals(false, Password.checkThatContainsAtLeastThreeDigits(passwordWithSpecialChars));
		assertEquals(true, Password.checkForOnlyDigitsAndLetters(passwordWithNumbersFirst));
		assertEquals(true, Password.checkForOnlyDigitsAndLetters(passwordWithLettersFirst));
	}
	
	@Test
	public void checkPasswordtest(){
		assertEquals(false, Password.checkThatContainsAtLeastThreeDigits(passwordShort));
		assertEquals(false, Password.checkThatContainsAtLeastThreeDigits(passwordOnlyLetters));
		assertEquals(true, Password.checkThatContainsAtLeastThreeDigits(passwordOnlyNumbers));
		assertEquals(false, Password.checkThatContainsAtLeastThreeDigits(passwordWithMixedLettersAndNumbers));
		assertEquals(false, Password.checkThatContainsAtLeastThreeDigits(passwordWithSpecialChars));
		assertEquals(true, Password.checkForOnlyDigitsAndLetters(passwordWithNumbersFirst));
		assertEquals(true, Password.checkForOnlyDigitsAndLetters(passwordWithLettersFirst));
	}

}

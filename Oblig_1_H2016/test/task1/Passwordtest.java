package task1;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class Passwordtest {
	private String passwordShort = "a1";
	private String passwordOnlyLetters = "abcde";
	private String passwordOnlyNumbers = "12345";
	private String passwordWithMixedLettersAndNumbers = "a222b322c4d";
	private String passwordWithSpecialChars = "$bcde%&/1234";
	private String passwordWithNumbersFirst = "123AbcdeFGh";
	private String passwordWithLettersFirst = "abCdefgJH12345";
	private Password password;
	
	@Before
	public void initialize(){
		password = new Password();
	}
	
	@Test
	public void checkLengthtest() {
		assertEquals(false, password.checkLength(passwordShort));
		assertEquals(false, password.checkLength(passwordOnlyLetters));
		assertEquals(false, password.checkLength(passwordOnlyNumbers));
		assertEquals(true, password.checkLength(passwordWithMixedLettersAndNumbers));
		assertEquals(true, password.checkLength(passwordWithSpecialChars));
		assertEquals(true, password.checkLength(passwordWithNumbersFirst));
		assertEquals(true, password.checkLength(passwordWithLettersFirst));
	}
	
	@Test
	public void checkForOnlyDigitsAndLetterstest() {
		assertEquals(true, password.checkForOnlyDigitsAndLetters(passwordShort));
		assertEquals(true, password.checkForOnlyDigitsAndLetters(passwordOnlyLetters));
		assertEquals(true, password.checkForOnlyDigitsAndLetters(passwordOnlyNumbers));
		assertEquals(true, password.checkForOnlyDigitsAndLetters(passwordWithMixedLettersAndNumbers));
		assertEquals(false, password.checkForOnlyDigitsAndLetters(passwordWithSpecialChars));
		assertEquals(true, password.checkForOnlyDigitsAndLetters(passwordWithNumbersFirst));
		assertEquals(true, password.checkForOnlyDigitsAndLetters(passwordWithLettersFirst));
	}
	
	@Test
	public void checkThatContainsAtLeastThreeDigitstest(){
		assertEquals(false, password.checkThatContainsAtLeastThreeDigits(passwordShort));
		assertEquals(false, password.checkThatContainsAtLeastThreeDigits(passwordOnlyLetters));
		assertEquals(true, password.checkThatContainsAtLeastThreeDigits(passwordOnlyNumbers));
		assertEquals(false, password.checkThatContainsAtLeastThreeDigits(passwordWithMixedLettersAndNumbers));
		assertEquals(false, password.checkThatContainsAtLeastThreeDigits(passwordWithSpecialChars));
		assertEquals(true, password.checkThatContainsAtLeastThreeDigits(passwordWithNumbersFirst));
		assertEquals(false, password.checkThatContainsAtLeastThreeDigits(passwordWithLettersFirst));
	}
	
	@Test
	public void checkPasswordtest(){
		assertEquals(false, password.checkPassword(passwordShort));
		assertEquals(false, password.checkPassword(passwordOnlyLetters));
		assertEquals(false, password.checkPassword(passwordOnlyNumbers));
		assertEquals(false, password.checkPassword(passwordWithMixedLettersAndNumbers));
		assertEquals(false, password.checkPassword(passwordWithSpecialChars));
		assertEquals(true, password.checkPassword(passwordWithNumbersFirst));
		assertEquals(false, password.checkPassword(passwordWithLettersFirst));
		
	}

}

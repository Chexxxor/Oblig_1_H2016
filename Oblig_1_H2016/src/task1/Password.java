package task1;

//Exercise 6.18 i Liang
public class Password {
	boolean checkLength(String theWord) {
		return theWord.length() >= 10;
	}
	boolean checkForOnlyDigitsAndLetters(String theWord) {
		String OnlyDigitsAndLettersPattern = "^[a-zA-Z0-9]*$";
		if(theWord.matches(OnlyDigitsAndLettersPattern)){
			return true;
		}
		return false;
	}
	boolean checkThatContainsAtLeastThreeDigits(String theWord) {
		// Added a little here so this code actually works!
		String AtLeastThreeDigitsPattern = ".*\\d{3,}.*";
		if(theWord.matches(AtLeastThreeDigitsPattern)){
			return true;
		}
		return false;
	}
	boolean checkPassword(String theWord) {
		return (checkLength(theWord) &&
				checkForOnlyDigitsAndLetters(theWord) &&
				checkThatContainsAtLeastThreeDigits(theWord)
				);
	}
}

package task2;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)

public class FormatIntegertest {
	
	private int inputNumber;
	private int inputWidth;
	private int inputLength;
	private int length_recived;
	private String expectedResult;
	private int actual_length;
	private FormatInteger formatinteger;
	
	@Before
	public void initialize(){
		formatinteger = new FormatInteger();
	}
	
	public FormatIntegertest(int inputNumber,int inputWidth, String expectedResult, int inputLength){
		this.inputNumber = inputNumber;
		this.inputWidth = inputWidth;
		this.expectedResult = expectedResult;
		this.inputLength = inputLength;
		
	}
	
	@Parameterized.Parameters
	public static Collection formatNumberOK(){
		return Arrays.asList(new Object[][] {
				{2,2,"02", 1},//ok
				{6,2,"06", 1},//ok
				{19,2,"19", 2},//ok
				{22,2,"22", 2},//ok
				{23,4,"0023", 2},//ok
				{23,5,"00023", 2},//ok
				{23,6,"000023", 2},//ok
				{23,7,"0000023", 2},//ok
				{23,8,"00000023", 2},//ok
		});
	}
	
	
	
	@Test
	public void testFormat(){
		assertEquals(expectedResult, formatinteger.format(inputNumber, inputWidth));
		
		actual_length = inputLength;
		length_recived = formatinteger.len(inputNumber);
		
		System.out.println("Input is: " + inputNumber + " "
							+ "Width is: " + inputWidth + " "
							+ "Return is: " + formatinteger.format(inputNumber, inputWidth) + " "
							+ "Length the same: " + (length_recived == actual_length));
	}

}

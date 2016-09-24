package task4;

import static org.junit.Assert.*;
import static task4.EvaluateExpression.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import task2.FormatInteger;

@RunWith(Parameterized.class)
public class EvaluateExpressiontest {
	private String input;
	private int expected;
	
	@Parameters
	public static List<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{"1 2 + 3 *", 9},
			{"3 3 + 3 *", 18},
			{"2 2 * 3 +", 7},
			{"5 5 * 4 *", 100},
			{"10 10 * 10 %", 0},
			{"10 10 * 5 /", 20},
			{"126 6 % 6 +", 6}
		});
	}
	
	public EvaluateExpressiontest(String input, int expected){
		this.input = input;
		this.expected = expected;
	}
	

	@Test
	public void test() {
		assertEquals(expected, evaluateExpression(input));
		// All of these tests need to be written in a OK manor. USE @Parameterized tests
		// And test for blank lines, to many spaces and so on - See the exercise papers
		
		/*
		// Just simple runs of the program to test underway. More testing is needed. 
		// These should ALL be deleted
		System.out.println(evaluateExpression("1 2 + 3 *"));
		// Should be 9 if I understand the exercise correctly
		System.out.println(evaluateExpression("3 3 + 3 *"));
		//Should be 18
		System.out.println(evaluateExpression("2 2 * 3 +"));
		//Should be 7
		System.out.println(evaluateExpression("5 5 * 4 *"));
		// should be 100
		System.out.println(evaluateExpression("10 10 * 10 %"));
		// Should be 0
		System.out.println(evaluateExpression("10 10 * 5 /"));
		// Should be 20
		System.out.println(evaluateExpression("126 6 % 6 +"));
		// Should be 6*/
		
	}

}

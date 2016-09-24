package task4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import task2.FormatInteger;

public class EvaluateExpressiontest {
	private EvaluateExpression evaluate;
	@Before
	public void initialize(){
		evaluate = new EvaluateExpression();
	}

	@Test
	public void test() {
		// All of these tests need to be written in a OK manor. USE @Parameterized tests
		// And test for blank lines, to many spaces and so on - See the exercise papers
		
		
		// Just simple runs of the program to test underway. More testing is needed. 
		// These should ALL be deleted
		System.out.println(evaluate.evaluateExpression("1 2 + 3 *"));
		// Should be 9 if I understand the exercise correctly
		System.out.println(evaluate.evaluateExpression("3 3 + 3 *"));
		//Should be 18
		System.out.println(evaluate.evaluateExpression("2 2 * 3 +"));
		//Should be 7
		System.out.println(evaluate.evaluateExpression("5 5 * 4 *"));
		// should be 100
		System.out.println(evaluate.evaluateExpression("10 10 * 10 %"));
		// Should be 0
		System.out.println(evaluate.evaluateExpression("10 10 * 5 /"));
		// Should be 20
		System.out.println(evaluate.evaluateExpression("126 6 % 6 +"));
		// Should be 6
		
	}

}

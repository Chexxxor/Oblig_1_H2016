package task4;

import static org.junit.Assert.*;

import org.junit.Test;

public class EvaluateExpressiontest {

	@Test
	public void test() {
		System.out.println(EvaluateExpression.evaluateExpression("1 2 + 3 *"));
		// Should be 9 if I understand the exercise correctly
	}

}

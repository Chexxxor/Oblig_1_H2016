package task4;

import static task4.EvaluateExpression.evaluateExpression;

import org.junit.Test;

public class EvaluateExpressiontestExceptions {

	@Test(expected=IllegalArgumentException.class)
	public void testIllegalArgumentException() {
		evaluateExpression("5 5*4-3/5 5 5 5++ 2*");
		evaluateExpression("+ 5 5*4-3/5 5++ 2*");
	}

}

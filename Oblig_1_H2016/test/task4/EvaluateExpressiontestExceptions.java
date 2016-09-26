package task4;

import static org.junit.Assert.*;
import static task4.EvaluateExpression.evaluateExpression;

import org.junit.Test;

public class EvaluateExpressiontestExceptions {

	@Test(expected=IllegalArgumentException.class)
	public void testIndexOutOfBoundsException() {
		assertEquals(999, evaluateExpression("5 5*4-3/5 5 5 5++ 2*"));
		assertEquals(999, evaluateExpression("+ 5 5*4-3/5 5++ 2*"));
	}

}

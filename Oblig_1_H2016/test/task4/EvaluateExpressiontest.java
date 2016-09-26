package task4;

import static org.junit.Assert.assertEquals;
import static task4.EvaluateExpression.evaluateExpression;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

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
			{"10 10 * 5 /", 20},
			{"126 6 / 6 +", 27},
			{"5 5*4-3/5 5++ 2*", 34},
			{" ", 0}
		});
	}
	
	public EvaluateExpressiontest(String input, int expected){
		this.input = input;
		this.expected = expected;
	}
	
	@Test
	public void test() {
		assertEquals(expected, evaluateExpression(input));
	}
}

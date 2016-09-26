package task4;

import java.util.ArrayDeque;
// Listing 20.9 in Liang is used as blueprint
// Input in form: 5 5 * 4 - 4 4 + -
// In normal form: (5*5 - 4) - (4 + 4)
public class EvaluateExpression{
	public static void main(String[] args) {
		try{
			System.out.println(evaluateExpression(args[0]));
		}
		catch (Exception ex){
			System.out.println("Wrong expression " + args[0]);
		}
	}

	public static int evaluateExpression(String expression){
		ArrayDeque<Integer> operandDeque = new ArrayDeque<Integer>();

		expression = expression.trim();
		if(expression.length() > 0){
			String[] tokens = insertBlanks(expression).trim().split(" ");
			System.out.println();
		
			// Sorting the tokens - operands and operators
			for(String token: tokens){
				if(token.length() == 0){
					continue;
				}
				else if(token.matches("[+*/-]")){
					processOperator(operandDeque, token.charAt(0));
				}
				else operandDeque.push(new Integer(token));
			}
		
		Integer result = operandDeque.pop();
		System.out.println("RESULT: " + result);
		return result;
		}
		else return 0;
	}

	public static void processOperator(ArrayDeque<Integer> operandDeque,
			ArrayDeque<Character> operatorDeque) {
		
		char operator = operatorDeque.pop();
		int operandOne = operandDeque.pop();
		int operandTwo = operandDeque.pop();
		int result = 0;
		
		switch(operator){
		case '+':
			result = operandTwo + operandOne;
			break;
		case '-':
			result = operandTwo - operandOne;
			break;
		case '*':
			result = operandTwo * operandOne;
			break;
		case '/':
			result = operandTwo / operandOne;
			break;
		}
		operandDeque.push(result);
	}
	public static void processOperator(ArrayDeque<Integer> operandDeque,
			char operator) {
		
		int operandOne = operandDeque.pop();
		int operandTwo = operandDeque.pop();
		int result = 0;
		
		switch(operator){
		case '+':
			result = operandTwo + operandOne;
			break;
		case '-':
			result = operandTwo - operandOne;
			break;
		case '*':
			result = operandTwo * operandOne;
			break;
		case '/':
			result = operandTwo / operandOne;
			break;
		}
		operandDeque.push(result);
	}
	public static String insertBlanks(String s) {
		String result = "";
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '+' ||s.charAt(i) == '-' || s.charAt(i) == '*'
					|| s.charAt(i) == '/' || s.charAt(i) == '%'){
				result += " " + s.charAt(i) + " ";
			}
			else result += s.charAt(i);
		}
		return result;
	}
}

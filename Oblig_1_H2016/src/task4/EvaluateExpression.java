package task4;

import java.util.Stack;
// Listing 20.9 in Liang is used as blueprint
// Should come out quite similar to the method described in the exercise.

public class EvaluateExpression {
	public static void main(String[] args) {
		try{
			System.out.println(evaluateExpression(args[0]));
		}
		catch (Exception ex){
			System.out.println("Wrong expression " + args[0]);
		}
	}

	public static int evaluateExpression(String expression){
		// Holders for operands, operators and tokens
		Stack<Integer> operandStack = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();
		//expression = insertBlanks(expression);
		String[] tokens = insertBlanks(expression).split(" ");
		
		System.out.println();
		
		// Sorting the tokens - operands and operators
		for(String token: tokens){
			if(token.length() == 0){
				continue;
			}
			else if(token.charAt(0) == '+' ||
					token.charAt(0) == '-' ||
					token.charAt(0) == '*' ||
					token.charAt(0) == '/' ||
					token.charAt(0) == '%')
			{
				operatorStack.push(token.charAt(0));
				processOperator(operandStack, operatorStack);
			}
			else { operandStack.push(new Integer(token));}
		}
		
		while(!operatorStack.isEmpty()){
			processOperator(operandStack, operatorStack);
		}
		
		Integer result = operandStack.pop();
		System.out.println("RESULT: " + result); 
		return result;
	}

	public static void processOperator(Stack<Integer> operandStack,
			Stack<Character> operatorStack)
	{
		
		char operator = operatorStack.pop();
		int operandOne = operandStack.pop();
		int operandTwo = operandStack.pop();
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
		case '%':
			result = operandTwo % operandOne;
			break;
		}
		operandStack.push(result);
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

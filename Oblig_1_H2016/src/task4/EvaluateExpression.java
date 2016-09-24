package task4;

import java.util.Stack;
// Listing 20.9 in Liang is used as blueprint

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
		expression = insertBlanks(expression);
		String[] tokens = insertBlanks(expression).split(" ");
		
		// Sorting the tokens
		for(String token: tokens){
			if(token.length() == 0){
				continue;
			}
			else if(token.charAt(0) == '+' || token.charAt(0) == '-'){
				while(!operatorStack.isEmpty() && (
						operatorStack.peek() == '+' ||
						operatorStack.peek() == '-' ||
						operatorStack.peek() == '*' ||
						operatorStack.peek() == '/' ||
						operatorStack.peek() == '%')){
					processOperator(operandStack, operatorStack);
				}
				operatorStack.push(token.charAt(0));
			}
			else if(token.charAt(0) == '*' || token.charAt(0) == '/' || token.charAt(0) == '%'){
				while(!operatorStack.isEmpty() && (
						operatorStack.peek() == '*' ||
						operatorStack.peek() == '/') ||
						operatorStack.peek() == '%'){
						processOperator(operandStack, operatorStack);
				}
				operatorStack.push(token.charAt(0));
			}
			else { operandStack.push(new Integer(token));}
		}
		
		while(!operatorStack.isEmpty()){
			processOperator(operandStack, operatorStack);
		}
		
		/*// Debugging purposes only
		System.out.println("Tokens:");
		System.out.println(tokens);
		System.out.println("Operands:");
		System.out.println(operandStack);
		System.out.println("Operators:");
		System.out.println(operatorStack);
		// Debugging stops
		*/
		
		
		System.out.println("RESULT:"); // Just for debugging purposes
		return operandStack.pop();
	}


	public static void processOperator(Stack<Integer> operandStack,
			Stack<Character> operatorStack) {
		
		char operator = operatorStack.pop();
		int operandOne = operandStack.pop();
		int operandTwo = operandStack.pop();
		
		// Debugging purposes only
		System.out.println("Operator: " + operator);
		System.out.println("Operand 1: " + operandOne);
		System.out.println("Operand 2: " + operandTwo);
		// Debugging stops
		
		if(operator == '+')
			operandStack.push(operandTwo + operandOne);
		else if(operator == '-')
			operandStack.push(operandTwo - operandOne);
		else if(operator == '*')
			operandStack.push(operandTwo * operandOne);
		else if(operator == '/')
			operandStack.push(operandTwo / operandOne);
		else if(operator == '%')
			operandStack.push(operandTwo % operandOne);
		
		
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

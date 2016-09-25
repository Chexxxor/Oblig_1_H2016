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
		// Holders for operands, operators and tokens
		ArrayDeque<Integer> operandStack = new ArrayDeque<Integer>();
		ArrayDeque<Character> operatorStack = new ArrayDeque<Character>();
		//Stack<Integer> operandStack = new Stack<>();
		//Stack<Character> operatorStack = new Stack<>();
		expression = expression.trim();
		if(expression.length() > 0){
			String[] tokens = insertBlanks(expression).trim().split(" ");;
		
			// Sorting the tokens - operands and operators
			for(String token: tokens){
				if(token.length() == 0){
					continue;
				}
				else if(token.charAt(0) == '+' || token.charAt(0) == '-'){
					operatorStack.push(token.charAt(0));
					processOperator(operandStack, operatorStack);
				}
				else if(token.charAt(0) == '*' || token.charAt(0) == '/'){
					operatorStack.push(token.charAt(0));
					processOperator(operandStack, operatorStack);
				}
				else {operandStack.push(new Integer(token));}
			}
			
			while(!operatorStack.isEmpty()){
			processOperator(operandStack, operatorStack);
			}
			
		return operandStack.pop();
		}
		else return 0;
	}


	public static void processOperator(ArrayDeque<Integer> operandStack,
			ArrayDeque<Character> operatorStack) {
		
		char operator = operatorStack.pop();
		int operandOne = operandStack.pop();
		int operandTwo = operandStack.pop();
		
		if(operator == '+')
			operandStack.push(operandTwo + operandOne);
		else if(operator == '-')
			operandStack.push(operandTwo - operandOne);
		else if(operator == '*')
			operandStack.push(operandTwo * operandOne);
		else if(operator == '/')
			operandStack.push(operandTwo / operandOne);	
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

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
		ArrayDeque<Integer> operandDeque = new ArrayDeque<Integer>();
		ArrayDeque<Character> operatorDeque = new ArrayDeque<Character>();
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
					while(operandDeque.size() >= 2){
					operatorDeque.push(token.charAt(0));
					processOperator(operandDeque, operatorDeque);
					}
				}
				else if(token.charAt(0) == '*' || token.charAt(0) == '/'){
					while(operandDeque.size() >= 2){
						operatorDeque.push(token.charAt(0));
						processOperator(operandDeque, operatorDeque);
						}
				}
				else {operandDeque.push(new Integer(token));}
			}
			
			while(!operatorDeque.isEmpty()){
			processOperator(operandDeque, operatorDeque);
			}
			
		return operandDeque.pop();
		}
		else return 0;
	}


	public static void processOperator(ArrayDeque<Integer> operandDeque,
			ArrayDeque<Character> operatorDeque) {
		
		char operator = operatorDeque.pop();
		int operandOne = operandDeque.pop();
		int operandTwo = operandDeque.pop();
		
		if(operator == '+')
			operandDeque.push(operandTwo + operandOne);
		else if(operator == '-')
			operandDeque.push(operandTwo - operandOne);
		else if(operator == '*')
			operandDeque.push(operandTwo * operandOne);
		else if(operator == '/')
			operandDeque.push(operandTwo / operandOne);	
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

package task4;

import java.util.ArrayDeque;

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
		
			for(String token: tokens){
				if(token.length() == 0){
					continue;
				}
				else if(token.matches("[+*/-]")){
					if(operandDeque.size() < 2){
						throw new IllegalArgumentException("Too many operators!");
					}
					processOperator(operandDeque, token.charAt(0));
				}
				else operandDeque.push(new Integer(token));
			}
			
			Integer result = operandDeque.pop();
			if(!operandDeque.isEmpty())
				throw new IllegalArgumentException("Too many numbers!");
			return result;
		}
		else return 0;
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
			if(("" + s.charAt(i)).matches("[+*/-]")){
				result += " " + s.charAt(i) + " ";
			}
			else result += s.charAt(i);
		}
		return result;
	}
}

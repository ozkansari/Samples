package hackerrank.specialtest.t1q1;
import java.util.Stack;

import hackerrank.SolutionHelper;

/**
 * Special Test - Question 1
 * 
 * @author ozkansari
 *
 */
public class Solution {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SolutionHelper.start();
		
		// GET INPUT
		String input = SolutionHelper.getIn().nextLine();

		// DISPLAY OUTPUT
		SolutionHelper.getOut().print(isBalanced(input));
		
		SolutionHelper.end();
	}
	
	/*
	 * Complete the function below.
	 */

	static boolean isBalanced(String input) {

		if(input==null) return true;
		
		char [] tokens = input.trim().toCharArray();

		Stack<Character> stack = new Stack<Character>();
		for (char token: tokens) {
			
			if (token == ' ') continue;
					
			if (token == '(' || token == '[') {
				stack.push(token);
			}
			else if (token == ')') {
				
				if(stack.isEmpty())  {
					return false;
				}
				
				Character topToken = stack.pop();
				if (topToken==null || topToken.charValue() != '(') {
					return false;
				}
			}
			else if (token == ']') {
				if(stack.isEmpty())  {
					return false;
				}
				
				Character topToken = stack.pop();
				if (topToken==null || topToken.charValue() != '[' ) {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}
	
	// **************************************************************************** //
	
}

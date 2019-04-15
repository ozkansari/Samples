package practice;

/*--
Consider a string expression consisting of the characters < and > only. We consider the string to be balanced if each < always appears before (i.e., to the left of) a corresponding > character (they do not need to be adjacent). Moreover, each < and > act as a unique pair of symbols and neither symbol can be considered as part of any other pair of symbols. For example, the strings <<>>, <>, and <><> are all balanced, but the strings >>, <<>, and ><>< are unbalanced.

To balance a string, we can replace only > character with <> at most maxReplacement times. Given an expression and the value of maxReplacement, can you turn an unbalanced string into a balanced one?

Complete the balancedOrNot function in the editor below. It has the following parameters:

An array of n strings, expressions, denoting the list of expressions to check.
An array of n integers, maxReplacements, where maxReplacementsi denotes the maximum number of replacements allowed when attempting to balance expressionsi.
The function must return an array of integers where each index i (0 ≤ i < n) contains a 1 if expressionsi is balanced or a 0 if it is not.

Input Format:
----------------------
A set of internal unit tests will be on the code with input in the following format.

The first line contains an integer, n, denoting the size of expressions.

Each line i of the n subsequent lines (where 0 ≤ i < n) contains a string describing expressionsi.

The next line contains an integer, m, denoting the size of maxReplacements.

Each line i of the n subsequent lines (where 0 ≤ i < n) contains a string describing maxReplacementsi.

Constraints
1 ≤ n ≤ 10^2
1 ≤ length(expressionsi) ≤ 10^5
0 ≤ maxReplacementsi ≤ 10^5

Output Format:
----------------------
The function must return an array of integers where each index i (0 ≤ i < n) contains a 1 if expressionsi is balanced or a 0 if it is not.
 */
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BalancedOrNot {
  
  static int[] balancedOrNot(String[] expressions, int[] maxReplacements) {
  
    int[] result = new int[expressions.length];
    
    if (expressions.length != maxReplacements.length) {
      // TODO Throw exception or print error, incorrect input parameters
      // or return result with full of zeros
      return result;
    }
    
    // It is always suggested to make these characters constant to be able to change it easily
    final char START_CHAR = '<';
    final char END_CHAR = '>';

    // NOTE: We can also intuitively prefer using stack in this problem but
    // For the sake of performance, we prefer simple counting.
    
    for (int expNo = 0; expNo < expressions.length; expNo++) {
      String exp = expressions[expNo];
    
      int countSc = 0; // Start character count
      int countEc = 0; // End character count 
      
      // Find unbalanced start (countSc) and end character (countEc) counts
      for (int charNo = 0; charNo < exp.length(); charNo++) {
        char c = exp.charAt(charNo);
        if (c == START_CHAR) {
          countSc++;
        } else if (c == END_CHAR) {
          
          if (countSc>0) {
            countSc--;
          } else {
            countEc++;
          }
        } else {
          // TODO Throw exception or print error, expression contains char other than '<' and '>'
          return result;
        }
      }

      // we can only replace ec (>) with balanced pair (<>), that's why countSc must be 0 after removing balanced ones
      // or return result with full of zeros
      result[expNo] = countSc == 0 && countEc <= maxReplacements[expNo] ? 1 : 0;
    }
    return result;
  }
  
    /**
     * Complete the function below.
     * DO NOT MODIFY anything outside this method. 
     */
    static int[] balancedOrNot2(String[] expressions, int[] maxReplacements) {
      
      // It is always suggested to make these characters constant to be able to change it easily
      final char START_CHAR = '<';
      final char END_CHAR = '>';
      
      int[] result = new int[expressions.length];
      
      Stack<Integer> stack = new Stack<>();
      
      for (int expNo = 0; expNo < expressions.length; expNo++) {
        boolean check = true;
        String exp = expressions[expNo];
        
        // check 1
        stack.clear();
        int removedCount = 0;
        final StringBuilder sb = new StringBuilder(exp);
        
        for (int charNo = 0; charNo < exp.length(); charNo++) {
          char c = exp.charAt(charNo);
          if (c == START_CHAR) {
            stack.push(charNo);
          } else if (c == END_CHAR && !stack.isEmpty()) {
            // Remove already balanced characters
            sb.deleteCharAt(stack.pop() - removedCount++);    // index of start char
            sb.deleteCharAt(charNo - removedCount++);         // index of end char
          }
        }
        exp = sb.toString();
        
        // check 2 : if '<' (start char) is on the last, there is no way to balance it
        // To balance a string, we can replace only > end character with <> at most maxReplacement times
        if(check) {
          int lastSc = exp.lastIndexOf(START_CHAR);
          int lastEc = exp.lastIndexOf(END_CHAR);
          check = lastEc > lastSc;
        }
        
        // check 3 : count required replacement count and check with max replacements
        if(check) {
          long countSc = exp.chars().filter(ch -> ch == START_CHAR).count();
          long countEc = exp.chars().filter(ch -> ch == END_CHAR).count();
          check = countEc-countSc <= maxReplacements[expNo];
        }
        
        result[expNo] = check ? 1 : 0;
      }
      return result;
    }

    /**
     * DO NOT MODIFY THIS METHOD!
     */
     public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int[] res;
        
        int _expressions_size = 0;
        _expressions_size = Integer.parseInt(in.nextLine().trim());
        String[] _expressions = new String[_expressions_size];
        String _expressions_item;
        for (int _expressions_i = 0; _expressions_i < _expressions_size; _expressions_i++) {
            try {
                _expressions_item = in.nextLine();
            } catch (Exception e) {
                _expressions_item = null;
            }
            _expressions[_expressions_i] = _expressions_item;
        }
        
        int _maxReplacements_size = 0;
        _maxReplacements_size = Integer.parseInt(in.nextLine().trim());
        int[] _maxReplacements = new int[_maxReplacements_size];
        int _maxReplacements_item;
        for (int _maxReplacements_i = 0; _maxReplacements_i < _maxReplacements_size; _maxReplacements_i++) {
            _maxReplacements_item = Integer.parseInt(in.nextLine().trim());
            _maxReplacements[_maxReplacements_i] = _maxReplacements_item;
        }
        
        res = balancedOrNot(_expressions, _maxReplacements);
        for (int res_i = 0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }
    }
}

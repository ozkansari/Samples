package hackerrank.unicodesprint2;

import java.util.Scanner;

import hackerrank.SolutionHelper;

/**
 * https://www.hackerrank.com/contests/university-codesprint-2/challenges/separate-the-numbers
 * 
 * @author ozkansari
 *
 */
public class SeperateTheNumbers {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SolutionHelper.start();
		
		// GET INPUT
		// Scanner in = new Scanner(System.in);
		Scanner in = SolutionHelper.getIn();
		
        int q = in.nextInt(); // the number of strings to evaluate
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            SolutionHelper.getOut().println(calculate(s));
        }
		
        SolutionHelper.end();
	}
	
	/**
	 * 
	 * @param s 1 <= |s| <= 32
	 * @return
	 */
	protected static String calculate(String s) {
		boolean matches = false;			
		String minSeqNumStr = null;
		
		String curSeqNumStr = "";
		String prevSeqNumStr = null;
		// char prevChar = 0;
		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);

			// Init
			if (prevSeqNumStr==null) {
				prevSeqNumStr = "" + currentChar;
				curSeqNumStr = "";
				// prevChar = currentChar;
				continue;
			}
			
			curSeqNumStr = curSeqNumStr + currentChar;
			
			// check
			boolean check = checkSequence(prevSeqNumStr, curSeqNumStr);
			if (check) {
				
				if (prevSeqNumStr.length()>1 && prevSeqNumStr.charAt(0) == '0') {
					return "NO";
				}
				
				// matches
				matches = true;
				if (minSeqNumStr==null) {
					minSeqNumStr = prevSeqNumStr;
				}
				prevSeqNumStr = curSeqNumStr;
				curSeqNumStr = "";
			} else if (matches && curSeqNumStr.length()>=prevSeqNumStr.length()) {
				matches = false;
				prevSeqNumStr = s.substring(0, i);
				minSeqNumStr = prevSeqNumStr;
			} else {
				char prevSeqLastChar = prevSeqNumStr.charAt(prevSeqNumStr.length()-1);
				if(prevSeqLastChar=='9') {
					// not matches
					matches = false;
					
					if( prevSeqLastChar=='9' && currentChar=='9') {
						prevSeqNumStr = prevSeqNumStr + curSeqNumStr;
						curSeqNumStr = "";
					}
				}
				else {
					// not matches
					if( prevSeqLastChar!='9' && curSeqNumStr.length() == prevSeqNumStr.length()) {
						prevSeqNumStr = prevSeqNumStr + curSeqNumStr;
						curSeqNumStr = "";
					}
					matches = false;
				}
			}
			// prevChar = currentChar;
			
			
		}

		return ( matches ? "YES" : "NO" ) + ( matches ? " " + minSeqNumStr : "" );
	}

	protected static boolean checkSequence(String prev, String cur){
		
		int diff = cur.length() - prev.length();
		if (diff < 0 || diff>1) {
			return false;
		}
		
		if (prev.charAt(prev.length()-1) == '9') {
			
			for (int j = prev.length()-1; j >=0; j--) {
				
				char curChar = cur.charAt(j+diff);
				boolean check1 = curChar == '0';
				char prevChar = prev.charAt(j);
				boolean check2 = prevChar == '9';
				
				if (check1 && check2) {
					if (j==0) {
						return diff == 0 ? false : true ;
					}
					continue;
				} else {
					
					int curDigit = curChar - '0';
					int prevDigit = prevChar - '0';
					if (curDigit == prevDigit+1) {
						return prev.substring(0, j).equals(cur.substring(0, j+diff));
					}
					
				}
				
				if (j==0) {
					if (check1 && check2) {
						return true;
					}
				}
				
			}
			
		}
		else {
			
			if (prev.length() > 1 && !prev.substring(0, prev.length()-2).equals(cur.substring(0, cur.length()-2)) ) {
				return false;
			}
			
			int digitPrev = prev.charAt(prev.length()-1) - '0';
			int digitCurrent = cur.charAt(cur.length()-1) - '0';
			if( digitCurrent==digitPrev+1 ) {
				return true;
			}
		} 
		return false;
	}


	
}


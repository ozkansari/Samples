package hackerrank.wsprint3;

import java.util.Scanner;

public class ASCIIFlower {
	
	public static final String PATTERN [] = { "..O..", "O.o.O", "..O.." };
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        
        System.out.println(calculate(r,c));
        
        in.close();
    }

	/**
	 * 
	 * @param rowCount 1<= r <= 20
	 * @param colCount 1<= colCount <= 20
	 * @return
	 */
	private static String calculate(int rowCount, int colCount) {
		
		StringBuilder sb = new StringBuilder();
		
		for (int r = 0; r < rowCount; r++) {
			for (int p = 0; p < PATTERN.length; p++) {
				
				for (int c = 0; c < colCount; c++) {
					sb.append(PATTERN[p]);
				}
				sb.append("\n");
			}
		}
		
		return sb.toString();
	}
}

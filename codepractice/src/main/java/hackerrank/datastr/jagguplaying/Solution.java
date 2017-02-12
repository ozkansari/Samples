package hackerrank.datastr.jagguplaying;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	/**
	 * 0: no debug, 1: random, 2: file
	 */
	private static int DEBUG_MODE = 2;
	
	private static Scanner in = null;
	
	private static PrintWriter out = null;
	
	private static long startTime;
	
	private static long endTime;
	
	private static TreeMap<Integer,Integer> bucketsMap = new  TreeMap<Integer,Integer>();
	
	/**
	 * 1 million ( 10^6 ) empty buckets 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		start();
		
		// 1 ≤ Q ≤ 2 * 10^5
		int q = in.nextInt();
		
		// Next Q line follows , which can be either an Update Query or Report Query.
		// Each Update Query is followed by atleast 1 report query.
		for (int i = 0; i < q; i++) {
			
			String queryType = in.next();
			
			// Report query
			// R pos1 pos2: the total number of water balloons in the bucket from pos1 to pos2 (both included) ?
			// 1 ≤ pos1,pos2,pos ≤ 10^6
			// pos1 ≤ pos2
			if( queryType.equals("R")) {
				int pos1 = in.nextInt();
				int pos2 = in.nextInt();
				out.println( report(pos1, pos2) );
			} 
			// Update query
			// U pos M plus
			// Update(pos,M,plus)
			else if( queryType.equals("U")) {
				
				int pos = in.nextInt();
				int m = in.nextInt();
				int plus = in.nextInt();
				
				update(pos, m, plus);
			}
		}
		
		end();
	}
	
	/**
	 * Report query
	 * 
	 * @param pos1
	 * @param pos2
	 * @return
	 */
	private static int report(int pos1, int pos2) {
		int sum = 0;
		for (Integer bucket : bucketsMap.subMap(pos1, pos2).values()) {
			sum += bucket;
		}
		return sum;
	}

	/**
	 * Update query
	 * 
	 * @param pos Position: 1 ≤ pos ≤ 10^6
	 * @param M 1 ≤ M ≤ 10
	 * @param plus 1 ≤ plus ≤ 999999
	 */
	private static void update(int pos,int m,int plus)
	{
	    int N=1000000;  //1 million
	    for (int i=1;i<=50;i++)
	    {
	        int back = pos;
	        for(int j=1;j<=1000;j++)
	        {
	        	addWaterBalloons(m,pos);
	            int s,in=__builtin_popcount(pos);
	            for(int k=0;;k++)
	            {
	                s=(int) (pos+Math.pow(2,(double) k));
	                if( __builtin_popcount(s) <= in )
	                {
	                    in = __builtin_popcount(s);
	                    pos = s;
	                    if(pos>N) {
	                    	break;
	                    }
	                    addWaterBalloons(m,pos);
	                }
	            }
	            pos = pos - N;
	        }
	        pos = back+plus;
	        if(pos>N) pos-=N;
	    }
	}
	
	/**
	 * add M water ballons at bucket pos
	 * 
	 * @param m number of water balloons
	 * @param pos bucket position
	 */
	private static void addWaterBalloons(Integer m, Integer pos) {
		Integer bucketValue = bucketsMap.get(pos);
		int current = bucketValue==null ? 0 : bucketValue.intValue();
		bucketsMap.put(pos, m+current);
	}

	/**
	 * gives the number of set bits in binary representation of x.
	 * 
	 * @param pos
	 * @return
	 */
	private static int __builtin_popcount(int i) {
		/*
		i = i - ((i >> 1) & 0x55555555);
		i = (i & 0x33333333) + ((i >> 2) & 0x33333333);
		return (((i + (i >> 4)) & 0x0F0F0F0F) * 0x01010101) >> 24;
		*/
	    return Integer.bitCount(i);
	}
	
	// java.util.Arrays.fill(mul, 1);
	// **************************************************************************** //

	/**
	 * Should be called at start
	 */
	private static void start() {
		startTime = System.currentTimeMillis();
		initInput();
		initOutput();
	}
	
	/**
	 * Should be called at the end
	 */
	private static void end() {
		endTime = System.currentTimeMillis();
		if (DEBUG_MODE>0) {
			out.println("");
			out.println(endTime - startTime + " ms");
		}
		in.close();
		out.close();
	}

	/**
	 * Utility function to initialize input
	 */
	private static void initInput() {
		
		if (DEBUG_MODE>0) {
			
			// From input file
			if(DEBUG_MODE==2) {
				try {
					in = new Scanner( new BufferedReader( new FileReader("input.txt") ) );
				} catch (FileNotFoundException e) {
					DEBUG_MODE=1;
				}
			}
			
			// Random
			if(DEBUG_MODE==1) {
				Random gen = new Random();
				StringBuilder sb = new StringBuilder();
				// FIXME
				in = new Scanner(new ByteArrayInputStream(sb.toString().getBytes()));
			}

		} else {
			in = new Scanner(System.in);
		}
	}
	
	/**
	 * Utility function to initialize output
	 */
	private static void initOutput() {
		if (DEBUG_MODE>0) {
			try {
				out = new PrintWriter("output.txt", "UTF-8");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else {
			out = new PrintWriter(System.out);
		}
	}
	

}


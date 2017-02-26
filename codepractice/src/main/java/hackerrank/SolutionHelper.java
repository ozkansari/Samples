package hackerrank;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.Scanner;

/**
 * My utility function to use in hackerrank solutions. It basically helps me debug and input/output.
 * 
 * @author ozkansari
 *
 */
public final class SolutionHelper {
	
	private static DebugMode DEBUG_MODE = DebugMode.DEBUG_WITH_RANDOM_INPUT;
	
	private static Scanner in = null;
	
	private static PrintWriter out = null;
	
	private static long startTime = 0L;
	
	private static long endTime = 0L;

	/**
	 * Hidden utility class constructor
	 */
	private SolutionHelper(){
		
	}
	
	/**
	 * Should be called at start
	 */
	public static void start() {
		if (DEBUG_MODE.isDebugOn()) {
			startTime = System.currentTimeMillis();
		}
		initInput();
		initOutput();
	}
	
	/**
	 * Should be called at the end
	 */
	public static void end() {
		if (DEBUG_MODE.isDebugOn()) {
			endTime = System.currentTimeMillis();
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
		
		if (!DEBUG_MODE.isDebugOn()) {
			in = new Scanner(System.in);
		} else {
			
			// From input file
			if(DEBUG_MODE.isInputFile()) {
				try {
					in = new Scanner( new BufferedReader( new FileReader("input.txt") ) );
				} catch (FileNotFoundException e) {
					DEBUG_MODE=DebugMode.DEBUG_WITH_RANDOM_INPUT;
				}
			}
			
			// Random
			if(DEBUG_MODE.isRandomInput()) {
				int n = 50, m = 20;
				Random gen = new Random();
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < n; i++) {
					sb.append(gen.nextInt(m) + " ");
				}
				in = new Scanner(new ByteArrayInputStream(sb.toString().getBytes()));
			}

		}
	}
	
	/**
	 * Utility function to initialize output
	 */
	private static void initOutput() {
		if (DEBUG_MODE.isInputFile()) {
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
	
	public static Scanner getIn() {
		return in;
	}

	public static PrintWriter getOut() {
		return out;
	}

	/**
	 * Debug Mode values
	 * 
	 * @author ozkansari
	 *
	 */
	private enum DebugMode {
		
		/**
		 * When using stdin/stdout
		 */
		NO_DEBUG(0,false), 
		
		/**
		 * When using random input
		 */
		DEBUG_WITH_RANDOM_INPUT(1,true), 
		
		/**
		 * When reading input from file, and writing output to file
		 */
		DEBUG_WITH_INPUT_FILE(2,true);
		
		private int debugValue;
		
		private boolean debugOn;

		private DebugMode(int debugValue, boolean debugOn) {
			this.debugValue = debugValue;
			this.debugOn = debugOn;
		}
		
		public boolean isRandomInput() {
			return this.debugValue == DEBUG_WITH_RANDOM_INPUT.debugValue;
		}

		public boolean isInputFile() {
			return this.debugValue == DEBUG_WITH_INPUT_FILE.debugValue;
		}

		public boolean isDebugOn() {
			return debugOn;
		}
	}
	
}

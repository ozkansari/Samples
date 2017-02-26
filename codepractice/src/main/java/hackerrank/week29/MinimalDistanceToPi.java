package hackerrank.week29;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/w29/challenges/minimal-distance-to-pi
 * 
 * @author ozkansari
 *
 */
public class MinimalDistanceToPi {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long min = in.nextLong();
        long max = in.nextLong();
        
        System.out.println(calculate(min, max));
    }

	/**
	 * Common fraction n/d such that min <= d <= max and |n/d-PI| is minimal.
	 * If there are several fractions having minimal distance to PI, choose the one with the smallest denominator.
	 * @param min 1 <= min <= max <= 10^15
	 * @param max 1 <= min <= max <= 10^15
	 * @return common fraction
	 */
	public static String calculate(long min, long max) {
		CommonFractionCalculator calc = new CommonFractionCalculator(min,max);
		return calc.calculateFraction();
	}
	
	private static class CommonFractionCalculator {

		private long min;
		private long max;
		
		private Map<Double, Double> distanceMap;
		
		public CommonFractionCalculator(long min, long max) {
			this.min = min;
			this.max = max;
			this.distanceMap = new HashMap<Double, Double>();
		}

		public String calculateFraction() {
			
			String currentFraction = "";
			double minDistance = 1;
			for (long d = min; d < max; d++) {
				
				long lower = (long) (Math.PI*d);
				long higher = lower + 1;
				
				double lowerDistance = getDistance((lower+0D)/d);
				double higherDistance = getDistance((higher+0D)/d);

				if (lowerDistance <= higherDistance) {
					if (lowerDistance < minDistance) {
						currentFraction = lower + "/" + d;
						minDistance = lowerDistance;
					}
				} else {
					if (higherDistance < minDistance) {
						currentFraction = higher + "/" + d;
						minDistance = higherDistance;
					}
				}
				
			}
			
			return currentFraction;
		}

		/**
		 * @param l
		 * @return
		 */
		private double getDistance(double num) {
			
			Double dist = distanceMap.get(num);
			if (dist != null) {
				return dist.doubleValue();
			}
			
			dist = Math.abs(num - Math.PI);
			distanceMap.put(num, dist);
			
			return dist;
		}
		
		
	}
}

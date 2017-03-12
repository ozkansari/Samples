package shortestdistance;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

public class ShortestDistance {

	public static void main(String[] args) {

		// All direct connections between cities
		Map<String, TreeSet<Destination>> directConnections = 
				new HashMap<String, TreeSet<Destination>>();
				
		// Read input
		String startingPoint = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter direct connections between cities in \"city1 city2 distance\" format");
		while (scanner.hasNext()) {
			String userInput = scanner.nextLine();
			if (userInput.isEmpty()) {
				break;
			}
			
			String [] userInputSplitted = userInput.split(" ");
			
			String city1 = userInputSplitted[0];
			String city2 = userInputSplitted[1];
			int distance = Integer.valueOf( userInputSplitted[2] );
			
			if (startingPoint == null) {
				startingPoint = city1;
			}
			TreeSet<Destination> distanceToSet = directConnections.get(city1);
			if (distanceToSet == null ) {
				distanceToSet = new TreeSet<Destination>();
				directConnections.put(city1, distanceToSet);
			}
			distanceToSet.add(new Destination(city2, distance));
		}
		
		Map<String, Integer> shortestKnownDistance = calculate(startingPoint, directConnections);
		
		for (Entry<String, Integer>  entry: shortestKnownDistance.entrySet()) {
			System.out.println( startingPoint + " to " + entry.getKey()  + " = " + entry.getValue() );
		}
		
		scanner.close();
	}

	/**
	 * The algorithm now proceeds as follows:
	 * - Let from be the starting point.
	 * - Add DistanceTo(from, 0) to a priority queue.
	 * - Construct a map shortestKnownDistance from city names to distances.
	 * - While the priority queue is not empty
	 * ----> Get its smallest element.
	 * ----> If its target is not a key in shortestKnownDistance
	 * -------> Let d be the distance to that target.
	 * -------> Put (target, d) into shortestKnownDistance.
	 * -------> For all cities c that have a direct connection from target
	 * ----------> Add DistanceTo(c, d + distance from target to c) to the priority queue
	 * 
	 * When the algorithm has finished, shortestKnownDistance contains the
	 * shortest distance from the starting point to all reachable targets.
	 * 
	 * @param startingPoint
	 * @param directConnections 
	 * @return
	 */
	private static Map<String, Integer> calculate(String startingPoint, Map<String, TreeSet<Destination>> directConnections) {
		Queue<Destination> distancePriorityQueue = new PriorityQueue<Destination>();
		distancePriorityQueue.add(new Destination(startingPoint, 0));
		
		// from city names to distances.
		Map<String,Integer> shortestKnownDistance = new HashMap<String, Integer>();
		
		while (!distancePriorityQueue.isEmpty()) {
			
			Destination smallestElement = distancePriorityQueue.poll();
			
			Integer smallestDistanceTo = shortestKnownDistance.get(smallestElement.getTargetName());
			if (smallestDistanceTo == null ) {
				int d = smallestElement.getDistanceTo();
				shortestKnownDistance.put(smallestElement.getTargetName(), d);
				
				TreeSet<Destination> directCitiesFromTarget = directConnections.get(smallestElement.getTargetName());
				for (Destination c : directCitiesFromTarget) {
					distancePriorityQueue.add(new Destination(c.getTargetName(), d+c.getDistanceTo()));
				}
				
			}
			
		}
		return shortestKnownDistance;
	}

}

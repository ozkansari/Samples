package hackerrank.week29;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/w29/challenges/diameter-minimization
 * 
 * Given n and m, build a strongly-connected oriented graph with n vertices
 *  where each vertex has outdegree m and the graph's diameter is as small as possible.
 *  Then print the graph.
 * 
 * Strongly connected graph G=(V,E)
 * Diameter of G: min integer d such that 
 *  for each u,v of G is a path from u to v of length <= d
 * 
 * Note: path's length is its number of edges.
 * Note: Cycles and multiple edges between vertices are allowed.
 * 
 * @author ozkansari
 *
 */
public class DiameterMinimization {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 5; // in.nextInt();
        int m = 2; // in.nextInt();

        System.out.println(calculate(n, m));
    }

	/**
	 * 
	 * @param n number of vertices 2 <= n <= 1000
	 * @param m outdegree of vertex 2 <= m <= min(n,5)
	 * 
	 * @return graph output
	 */
	private static String calculate(int n, int m) {
		
		List<Node> nodes = createGraph(n,m);
		
		StringBuilder sb = new StringBuilder();
		
		// First, print an integer denoting the diameter of your graph on a new line.
		int diameterOfGraph = m;
		sb.append(diameterOfGraph);
		sb.append("\n");
		
		// Next, print n lines 
		// where each line i (0 <= i < n) contains m space-separated integers 
		// in the inclusive range from 0 to n-1 
		// describing the endpoints for each of vertex i's outbound edges
		for (int n_i = 0; n_i < n; n_i++) {
			
			for (int m_i = 0; m_i < m; m_i++) {
				sb.append( nodes.get(n_i).adjacencyList.get(m_i).label );
				sb.append(" ");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	private static List<Node> createGraph(int n, int m) {
		
		Node firstNode = null;
		List<Node> nodes = new ArrayList<Node>();
		for (int n_i = 0; n_i < n; n_i++) {
			Node currentNode = new Node(n_i);
			nodes.add(currentNode);
			
			if (n_i == 0) {
				firstNode = currentNode;
			} else if (n_i != 0) {
				Node preNode = nodes.get(n_i - 1);
				currentNode.addFirst(preNode);
				preNode.addFirst(currentNode);
			}
			
			if (n_i == n-1) {
				currentNode.addFirst(firstNode);
				firstNode.addLast(currentNode);
			}
		}
		
		return nodes;
	}

	private static class Node {
	    protected int label;
	    protected ArrayList<Node> adjacencyList;
	    protected Node(int label) {
	    	this.label = label;
	    	adjacencyList = new ArrayList<>();
	    }
		public void addFirst(Node adjacentNode) {
			adjacencyList.add(0, adjacentNode);
		}
		public void addLast(Node adjacentNode) {
			adjacencyList.add(adjacentNode);
		}
	    
	}
}

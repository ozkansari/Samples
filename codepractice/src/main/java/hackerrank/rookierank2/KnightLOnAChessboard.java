package hackerrank.rookierank2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/rookierank-2/challenges/knightl-on-
 * chessboard
 * 
 * @author ozkansari
 *
 */
public class KnightLOnAChessboard {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		// your code goes here

		for (int a = 1; a < n; a++) {
			for (int b = 1; b < n; b++) {
				int minMoves = knightL(a, b, n);
				System.out.print(minMoves);
				System.out.print(b == n - 1 ? "" : " ");
			}
			System.out.println();
		}

		in.close();

	}

	protected static int knightL(int a, int b, int n) {

		// Set all positions on the board as single node
		final Node[][] allNodes = new Node[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				allNodes[i][j] = new Node(i, j);
			}
		}

		// Set adjacent nodes for each node
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Node currentNode = allNodes[i][j];
				if (currentNode.adjecentNodes.isEmpty()) {

					int newX, newY;

					// All possible 8 directions
					// +a,+b
					newX = i + a;
					newY = j + b;
					if (newX >= 0 && newY >= 0 && newX < n && newY < n && !(newX == 0 && newY == 0)) {
						currentNode.adjecentNodes.add(allNodes[newX][newY]);
					}
					// +a,-b
					newX = i + a;
					newY = j - b;
					if (newX >= 0 && newY >= 0 && newX < n && newY < n && !(newX == 0 && newY == 0)) {
						currentNode.adjecentNodes.add(allNodes[newX][newY]);
					}
					// -a,+b
					newX = i - a;
					newY = j + b;
					if (newX >= 0 && newY >= 0 && newX < n && newY < n && !(newX == 0 && newY == 0)) {
						currentNode.adjecentNodes.add(allNodes[newX][newY]);
					}
					// -a,-b
					newX = i - a;
					newY = j - b;
					if (newX >= 0 && newY >= 0 && newX < n && newY < n && !(newX == 0 && newY == 0)) {
						currentNode.adjecentNodes.add(allNodes[newX][newY]);
					}
					// +b,+a
					newX = i + b;
					newY = j + a;
					if (newX >= 0 && newY >= 0 && newX < n && newY < n && !(newX == 0 && newY == 0)) {
						currentNode.adjecentNodes.add(allNodes[newX][newY]);
					}
					// +b,-a
					newX = i + b;
					newY = j - a;
					if (newX >= 0 && newY >= 0 && newX < n && newY < n && !(newX == 0 && newY == 0)) {
						currentNode.adjecentNodes.add(allNodes[newX][newY]);
					}
					// -b,+a
					newX = i - b;
					newY = j + a;
					if (newX >= 0 && newY >= 0 && newX < n && newY < n && !(newX == 0 && newY == 0)) {
						currentNode.adjecentNodes.add(allNodes[newX][newY]);
					}
					// -b,-a
					newX = i - b;
					newY = j - a;
					if (newX >= 0 && newY >= 0 && newX < n && newY < n && !(newX == 0 && newY == 0)) {
						currentNode.adjecentNodes.add(allNodes[newX][newY]);
					}

				}
			}
		}

		// BFS
		Node rootNode = allNodes[0][0];

		Queue<Node> q = new LinkedList<Node>();
		q.add(rootNode);

		final HashMap<Node, Node> parentToChild = new HashMap<Node, Node>();

		boolean found = false;
		int minMoves = 0;
		while (!q.isEmpty()) {

			Node parent = q.poll();

			for (Node adj : parent.adjecentNodes) {

				if (!adj.visited) {
					adj.visited = true;
					parentToChild.put(adj, parent);
					q.add(adj);

					// Check if end node found
					if (adj.coordX == (n - 1) && adj.coordY == (n - 1)) {

						found = true;
						Node par = parentToChild.get(adj);
						while (par != null) {
							minMoves++;
							par = parentToChild.get(par);
						}

						q = new LinkedList<Node>();
						break;
					}
				}

			}
		}

		return found ? minMoves : -1;

	}

	/**
	 * Represents a graph node
	 */
	private static class Node {

		protected final int coordX;
		protected final int coordY;
		protected boolean visited;
		protected LinkedList<Node> adjecentNodes = new LinkedList<>();

		public Node(int x, int y) {
			coordX = x;
			coordY = y;
		}

	}
}

package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import practice.graph.bfs.s1.BfsAlgorithm;
import practice.graph.bfs.s1.Vertex;

/**
 * Chess knight shortest path problem
 * 
 * Problem Definition :
 * 
 * Knight is a chess piece , that is allowed to move to a square that is two
 * squares horizontally and one square vertically, or two squares vertically and
 * one square horizontally. The complete move therefore looks like the letter L.
 * 
 * Given an infinite NxN chessboard , find a number of turns required for a
 * knight to reach a destination square knowing that he is starting his path
 * form the origin (0,0).
 * 
 * Example : What is the minimal amount of turns it will take for a Knight to
 * reach (0,2) ? Answer : He will move from (0,0) to (2,1) , and then from (2,1)
 * to (0,2).
 * 
 * 3 steps : 
 * 1-) Imagine chessboard as a graph . Each square is a node . Each legit
 * knight move is an edge. 
 * 2-) Create an adjacency list starting from a root node (0,0). 
 * 3-) Use BFS algorithm to find a shortest path from origin node to destination node.
 * 
 * Modified from <a href=
 * "http://yanbraslavsky.blogspot.com.tr/2016/01/chess-knight-shortest-path-problem-java.html">
 * yan.braslavski code </a>.
 * 
 */
public class ChessKnightShortestPathProblem {

	
	private static final BfsAlgorithm bfs = new BfsAlgorithm();
	private final ProblemConditions PROBLEM_CONDITIONS;
	
	private Vertex root;
	
	private Vertex destinationVertex = new Vertex(0, 2);

	/**
	 * 
	 * @param sizeOfBoardNxN
	 *            standard board is 8x8 , but yours can be different
	 * @param nearestMove
	 *            the smaller part of knight step
	 * @param fareMostMove
	 *            the bigger part of knight step
	 * @param destX
	 * @param destY
	 */
	public ChessKnightShortestPathProblem(int sizeOfBoardNxN, int nearestMove, int fareMostMove, int destX, int destY) {
		PROBLEM_CONDITIONS = new ProblemConditions(sizeOfBoardNxN, nearestMove, fareMostMove);
		destinationVertex = new Vertex(destX, destY);
		// we are representing available moves on NxN chessboard
		// by vertex adjacency list
		root = createChessboardGraph();
	}
	
	/**
	 * MAIN METHOD - STARTING POINT
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ChessKnightShortestPathProblem c = new ChessKnightShortestPathProblem(8,1,2, 0, 2);

		// printing the graph for visualisation
		System.out.println("Graph adjacency list :\n");
		c.printGraphForRoot();
		
		// printing the solution
		List<Vertex> path = c.solveProblem();
		
		System.out.println("Turns Required to reach destination: " + (path.size() - 1) + "\nPath : " + c.pathToString(path));
	}

	/**
	 * Creates chess board as a graph represented as adjacency list
	 *
	 * @return root node of the graph
	 */
	private Vertex createChessboardGraph() {
		
		// first we are creating all possible nodes in the graph
		// without associating any adjacent nodes to them
		final ArrayList<Vertex> vertexes = new ArrayList<>();
		for (int i = 0; i <= PROBLEM_CONDITIONS.getChessBoardSize(); i++) {
			for (int j = 0; j <= PROBLEM_CONDITIONS.getChessBoardSize(); j++) {
				vertexes.add(new Vertex(i, j));
			}
		}

		// and now we are actually associating adjacent nodes
		// to each created node
		for (Vertex v : vertexes) {
			if (v.getAdjVertices().isEmpty())
				createAdjListForVertex(v, vertexes);
		}

		// we return the root node as it will represent the entire graph
		return vertexes.get(0);
	}

	/**
	 * Creates adjacency list for provided node , according to problem
	 * definition
	 *
	 * @param vertexes
	 *            are used to define connections between one another
	 */
	private void createAdjListForVertex(Vertex v, ArrayList<Vertex> vertexes) {
		// Here we are just trying to create adjacent nodes in all possible
		// directions

		int xRightFull = v.getX() + PROBLEM_CONDITIONS.getFareMostMove();
		int xRightHalf = v.getX() + PROBLEM_CONDITIONS.getNearestMove();
		int xLeftFull = v.getX() + -PROBLEM_CONDITIONS.getFareMostMove();
		int xLeftHalf = v.getX() + -PROBLEM_CONDITIONS.getNearestMove();

		int yUpFull = v.getY() + PROBLEM_CONDITIONS.getFareMostMove();
		int yUpHalf = v.getY() + PROBLEM_CONDITIONS.getNearestMove();
		int yDownFull = v.getY() + -PROBLEM_CONDITIONS.getFareMostMove();
		int yDownHalf = v.getY() + -PROBLEM_CONDITIONS.getNearestMove();

		// full right half up
		createAdjVertexIfInBounds(v, xRightFull, yUpHalf, vertexes);
		// half right Full up
		createAdjVertexIfInBounds(v, xRightHalf, yUpFull, vertexes);
		// half left Full up
		createAdjVertexIfInBounds(v, xLeftHalf, yUpFull, vertexes);
		// full left half up
		createAdjVertexIfInBounds(v, xLeftFull, yUpHalf, vertexes);
		// full left half down
		createAdjVertexIfInBounds(v, xLeftFull, yDownHalf, vertexes);
		// half left full down
		createAdjVertexIfInBounds(v, xLeftHalf, yDownFull, vertexes);
		// half right full down
		createAdjVertexIfInBounds(v, xRightHalf, yDownFull, vertexes);
		// full right half down
		createAdjVertexIfInBounds(v, xRightFull, yDownHalf, vertexes);
	}

	/**
	 * adds adjacent nodes according to constrains in problem definition
	 *
	 * @param vertexes
	 *            will be used to define connections between one another
	 */
	private void createAdjVertexIfInBounds(Vertex v, int x, int y, ArrayList<Vertex> vertexes) {
		// check PROBLEM
		if (PROBLEM_CONDITIONS.isPositionOnChessBoard(x, y)) {

			// we don't want to assign new instances of Vertexes
			// as adjacent nodes , that will not work.
			// we need to reuse the same instances and assign
			// connections between them
			final int indexOf = vertexes.indexOf(new Vertex(x, y));
			final Vertex reusedVertex = vertexes.get(indexOf);
			v.addAdjVertex(reusedVertex);
		}
	}

	public List<Vertex> solveProblem() {
		return solveProblem(root,destinationVertex);
	}
	
	/**
	 * Finds a shortest path from source to destination
	 *
	 * @param from
	 *            source node
	 * @param to
	 *            destination node
	 * @return path complete representation of solved problem
	 */
	private List<Vertex> solveProblem(final Vertex from, final Vertex to) {
		final List<Vertex> path = new ArrayList<>();
		final HashMap<Vertex, Vertex> parentToChild = new HashMap<>();
		bfs.run(from, new BfsAlgorithm.BfsActionForInterruptTraversal() {

			private Vertex currParent;

			@Override
			public boolean onVisitParent(Vertex parent) {
				currParent = parent;
				return false;
			}

			@Override
			public boolean onVisitChild(Vertex vertex) {
				parentToChild.put(vertex, currParent);
				if (vertex.equals(to))
					return true;
				else
					return false;
			}
		});
		path.add(to);
		Vertex par = parentToChild.get(to);
		while (par != null) {
			path.add(par);
			par = parentToChild.get(par);
		}

		Collections.reverse(path);
		return path;
	}

	/**
	 * Converts a list of nodes that represents a path to simple string
	 * representation
	 *
	 * @param path
	 *            list of nodes
	 */
	public String pathToString(List<Vertex> path) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < path.size(); i++) {
			Vertex v = path.get(i);
			if (i != 0)
				sb.append("->");

			sb.append(v);
		}
		return sb.toString();
	}

	private void printGraphForRoot() {
		printGraph(root);
	}
	
	/**
	 * Prints the graph as adjacency list
	 *
	 * @param graph
	 *            root node
	 */
	private void printGraph(Vertex graph) {
		List<Vertex> list = graphToList(graph);
		Collections.sort(list, new Comparator<Vertex>() {
			public int compare(Vertex o1, Vertex o2) {
				if (o1.getX() == o2.getX())
					return o1.getY() - o2.getY();
				else
					return o1.getX() - o2.getX();
			}
		});

		StringBuilder sb = new StringBuilder();
		for (Vertex vert : list) {
			sb.append(vert + "->");
			for (Vertex adjV : vert.getAdjVertices()) {
				sb.append(" " + adjV);
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	/**
	 * Uses bfs internally to convert a graph to list of distinct nodes
	 *
	 * @param vert
	 *            root node
	 * @return list of all child nodes
	 */
	private List<Vertex> graphToList(Vertex vert) {
		final List<Vertex> list = new ArrayList<>();
		bfs.run(vert, new BfsAlgorithm.BfsActionForInterruptTraversal() {
			@Override
			public boolean onVisitParent(Vertex v) {
				list.add(v);
				return false;
			}

			@Override
			public boolean onVisitChild(Vertex vertex) {
				return false;
			}
		});
		return list;
	}

	/**
	 * Created by yan.braslavski on 1/24/16.
	 *
	 * To have some degree of freedom I've encapsulated some problem related
	 * conditions in order to scale the problem with ease.
	 */
	public class ProblemConditions {
		private final int mSizeOfBoardNxN;
		private final int mNearestMove;
		private final int mFareMostMove;

		/**
		 * When Knight moves , he moves 2 squares and then 1 square
		 * perpendicularly. To make this generic , I am saying it moves a "big"
		 * distance and then smaller distance perpendicularly.
		 * 
		 * @param sizeOfBoardNxN
		 *            standard board is 8x8 , but yours can be different
		 * @param nearestMove
		 *            the smaller part of knight step
		 * @param fareMostMove
		 *            the bigger part of knight step
		 */
		public ProblemConditions(int sizeOfBoardNxN, int nearestMove, int fareMostMove) {
			mSizeOfBoardNxN = sizeOfBoardNxN;
			mNearestMove = nearestMove;
			mFareMostMove = fareMostMove;
		}

		/**
		 * @return true if the position within bounds of chessboard
		 */
		public boolean isPositionOnChessBoard(int x, int y) {
			return (x <= mSizeOfBoardNxN && y <= mSizeOfBoardNxN && x >= 0 && y >= 0);
		}

		public int getFareMostMove() {
			return mFareMostMove;
		}

		public int getNearestMove() {
			return mNearestMove;
		}

		public int getChessBoardSize() {
			return mSizeOfBoardNxN;
		}
	}

	public Vertex getRoot() {
		return root;
	}

	public Vertex getDestinationVertex() {
		return destinationVertex;
	}

}

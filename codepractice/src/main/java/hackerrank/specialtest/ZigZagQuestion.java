package hackerrank.specialtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ZigZagQuestion {

	/**
	 * ZigZag interface instance
	 */
	private ZigZag zigZagInstance;
	
	/**
	 * Tree node
	 * 
	 * @author amazon
	 */
	public class Node {
		
		private int value;
		private Node left;
		private Node right;

		public Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}

		public int getValue() {
			return this.value;
		}

		public Node getLeft() {
			return this.left;
		}

		public Node getRight() {
			return this.right;
		}
		
		protected void setLeft(Node leftNode) {
			this.left = leftNode;
		}

		protected void setRight(Node rightNode) {
			this.right = rightNode;
		}

		@Override
		public String toString() {
			return String.valueOf( getValue() );
		}
	}

	/**
	 * ZigZag interface
	 * 
	 * @author amaozn
	 *
	 */
	public interface ZigZag {
		public List<Node> GetZigZagOrder(Node rootNode);
	}
	
	/**
	 * My ZigZag Implementation
	 * 
	 * @author ozkansari
	 *
	 */
	public class ZigZagImpl implements ZigZag {

		/**
		 * Map of stacks to represent tree levels
		 */
		Map<Integer,Stack<Node>> levels=new HashMap<Integer,Stack<Node>>();
		
		@Override
		public List<Node> GetZigZagOrder(Node rootNode) {
			
			// Initialize first root level
			Stack<Node> rootLevel = new Stack<Node>();
			rootLevel.add(rootNode);
			levels.put(1,rootLevel);
			
			// Initialize next level
			initLevels(rootNode, 2);
			
			// Find result list
			List<Node> resultList = new ArrayList<Node>();
			boolean rightSide = false;
			for (int i=1; ; i++) {
				
				Stack<Node> levelStack = levels.get(i);
				if(levelStack==null) break;
				
				while(!levelStack.empty()) {
					Node currentNode = null;
					
					if(rightSide) {
						currentNode = levelStack.pop();
					} else {
						currentNode = levelStack.firstElement();
						levelStack.remove(currentNode);
					}
					
					resultList.add(currentNode);
				}
				rightSide = !rightSide;
			}
			
			return resultList;
		}

		/**
		 * Helper recursive method
		 * @param currentNode
		 * @param currentLevel
		 */
		private void initLevels(Node currentNode, Integer levelIndex) {

			Node leftNode = currentNode.getLeft();
			Node rightNode = currentNode.getRight();

			if(leftNode==null && rightNode==null) {
				return;
			} 
			
			Stack<Node> currentLevel = levels.get(levelIndex);
			if(currentLevel==null) {
				currentLevel = new Stack<Node>();
				levels.put(levelIndex,currentLevel);
			}

			if(leftNode!=null) {
				currentLevel.push(leftNode);
				if(leftNode.getLeft()!=null || leftNode.getRight()!=null) {
					initLevels(leftNode,levelIndex+1);
				} 
			}
			
			if(rightNode!=null) {
				currentLevel.push(rightNode);
				if(rightNode.getLeft()!=null || rightNode.getRight()!=null) {
					initLevels(rightNode,levelIndex+1);
				}
			}

		}

	}
	
	/**
	 * 
	 * @return ZigZag instance
	 */
	public ZigZag getZigZagInstance(){
		if(zigZagInstance==null) {
			zigZagInstance = new ZigZagImpl();
		}
		return zigZagInstance;
	}
	
	/**
	 * Main method to test the ZigZag coding sample. 
	 * I actually prefer to test my code using JUnit but the result is requested to be in one file.
	 * 
	 * @author ozkansari
	 * 
	 */
	public void test1() {
		
		// Create dummy data
		List<Node> sampleData = new ArrayList<Node>();
		for(int i=1;i<=12;i++) {
			Node currentNode = new Node(i,null,null);;
			sampleData.add(currentNode);
		}
		int j=1;
		for (Node node : sampleData) {
			int index = j*2;
			node.setRight( index+1<=sampleData.size() ? sampleData.get(index) : null);
			node.setLeft(index<=sampleData.size() ? sampleData.get(index-1) : null);
			j++;
		}

		ZigZag zigZagImpl = getZigZagInstance();
		List<Node> zigZagOrderedList = zigZagImpl.GetZigZagOrder(sampleData.get(0));
		
		for (Node node : zigZagOrderedList) {
			System.out.print(node + " ");
		}
		
	}
	
	/**
	 * Main method to test my sample code.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new ZigZagQuestion().test1();
	}

}

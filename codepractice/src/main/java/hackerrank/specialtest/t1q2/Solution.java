package hackerrank.specialtest.t1q2;
import java.util.ArrayList;

import hackerrank.SolutionHelper;

/**
 * Amazon Test - Question 2
 * 
 * @author ozkansari
 *
 */
public class Solution {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SolutionHelper.start();
		
		// GET INPUT
		int n = SolutionHelper.getIn().nextInt();

		
		
		// DISPLAY OUTPUT
		SolutionHelper.getOut().print("");
		
		SolutionHelper.end();
	}
	
	/*
	 * Complete the function below.
	 */
	/*
	For your reference:
	LinkedListNode {
	    int val;
	    LinkedListNode *next;
	};
	*/
	static LinkedListNode manipulateList(LinkedListNode root) {

		ArrayList<LinkedListNode> nodeList = new ArrayList<LinkedListNode>();
		LinkedListNode currentNode = root;
		int elementCount = 0;
		
		// Put nodes into a list
		while (currentNode != null) {
			elementCount++;
			nodeList.add(currentNode);
			currentNode = currentNode.next;
		}
		
		// Find the mid point and rearrange nodes 
		int mid = elementCount/2;
		LinkedListNode newRoot = null;
		for(int nodeIndex = 0,midIndex=mid; midIndex<elementCount; nodeIndex++, midIndex++) {
			if (nodeIndex == 0) {
				newRoot = _insert_node_into_singlylinkedlist(null,root.val);;
			} else if(nodeIndex<mid) {
				newRoot = _insert_node_into_singlylinkedlist(newRoot,nodeList.get(nodeIndex).val);
			}
			newRoot = _insert_node_into_singlylinkedlist(newRoot,nodeList.get(midIndex).val);
		}
		
		return newRoot;
	}
	
	// **************************************************************************** //
	// Following methods are not given in the problem
	// They are provided for compile reasons
	
	private static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode newRoot, Object val) {
		// TODO Auto-generated method stub
		return null;
	}

	private class LinkedListNode {
		public LinkedListNode next;
		public Object val;
	}
	
	
}

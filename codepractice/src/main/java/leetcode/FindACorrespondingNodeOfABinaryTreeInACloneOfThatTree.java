package leetcode;

import java.util.LinkedList;

public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {

	protected static interface Solution {
		/**
		 * Given two binary trees original and cloned and given a reference to a node
		 * target in the original tree.
		 * 
		 * The cloned tree is a copy of the original tree.
		 * 
		 * Note that you are not allowed to change any of the two trees or the target
		 * node and the answer must be a reference to a node in the cloned tree.
		 * 
		 * @param original
		 * @param cloned
		 * @param target
		 * @return a reference to the same target node in the cloned tree.
		 */
		TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target);
	}
	

	/** Runtime: 6 ms, Memory Usage: 46.2 MB */
	protected static class Solution1 implements Solution {
		
		@Override
		public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
			
			VisitingNode targetVisitingNode = searchPreOrderDfs(original, target);
			
			LinkedList<Boolean> pathStack = new LinkedList<Boolean>();
			VisitingNode current = targetVisitingNode;
			while (current.parent != null) {
				pathStack.addLast(current.rightNode);
				current = current.parent;
			}
			
			TreeNode targetCopy = cloned;
			while (!pathStack.isEmpty()) {
				Boolean goRight = pathStack.removeLast();
				if (goRight) {
					targetCopy = targetCopy.right;
				} else {
					targetCopy = targetCopy.left;
				}
			}
			
			return targetCopy;
	        
	    }
		
		public VisitingNode searchPreOrderDfs(TreeNode root, TreeNode target) {

			if (root == null) {
				return null;
			}
			
			LinkedList<VisitingNode> stack = new LinkedList<VisitingNode>();
		    VisitingNode current = new VisitingNode(root, null, null);
		    stack.addLast(current);

		    while(!stack.isEmpty()) {
		        current = stack.removeLast();
		        if(current.node.equals(target)) {
		        	return current;
		        }
		        
		        if(current.node.right != null) {
		            stack.addLast(new VisitingNode(current.node.right, current, Boolean.TRUE));
		        }    
		        if(current.node.left != null) {
		            stack.addLast(new VisitingNode(current.node.left, current, Boolean.FALSE));
		        }
		    }
		    
		    return null;
		}

		/** A new data type to track path that wraps TreeNode which is not allowed to be changed */
		private static class VisitingNode {
			
			/** Wrapped tree node object */
			TreeNode node;
			
			/** When null, meaning this is rootNode */
			VisitingNode parent;
			
			/** Shows if this the right node of the parent? When null, meaning this is rootNode */
			Boolean rightNode;
			public VisitingNode(TreeNode node, VisitingNode parent, Boolean rightNode) {
				super();
				this.node = node;
				this.parent = parent;
				this.rightNode = rightNode;
			}
		}
	}
	
	/** Definition for a binary tree node */
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}
}

package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import leetcode.FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree.Solution;
import leetcode.FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree.Solution1;
import leetcode.FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree.TreeNode;

public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTreeTest {

	private Solution fixture = new Solution1();
	
	@Test
	public void testForRootNode() {
		
		// Given
		TreeNode rootNode = new TreeNode(1);
		
		TreeNode original = rootNode;
		TreeNode cloned = rootNode;
		TreeNode target  = rootNode;
		
		// When
		TreeNode actual = fixture.getTargetCopy(original, cloned, target);
		
		// Then
		assertEquals(target, actual);
	}
	
	@Test
	public void test2() {
		
		// Given
		TreeNode rootNode = new TreeNode(1);
		TreeNode rootLeftNode = new TreeNode(2);
		rootNode.left = rootLeftNode;
		TreeNode rootRightNode = new TreeNode(3);
		rootNode.right = rootRightNode;
		
		TreeNode original = rootNode;
		TreeNode cloned = rootNode;
		TreeNode target  = rootRightNode;
		
		// When
		TreeNode actual = fixture.getTargetCopy(original, cloned, target);
		
		// Then
		assertEquals(target, actual);
	}

}

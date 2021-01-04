package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import leetcode.MergeTwoSortedLists.ListNode;

public class MergeTwoSortedListsTest {

	private MergeTwoSortedLists fixture = new MergeTwoSortedLists();
	
	@Test
	public void testMergeTwoLists() {
		
		// Given
		MergeTwoSortedLists.ListNode l1 = null;
		MergeTwoSortedLists.ListNode l2 = new MergeTwoSortedLists.ListNode(1);
		
		// When
		ListNode result = fixture.mergeTwoLists(l1, l2);
		
		// Then
		assertEquals(result.val, 1);
		
	}

}

package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import leetcode.SortedLists.ListNode;

public class SortedListsTest {

	private SortedLists fixture = new SortedLists();
	
	@Test
	public void testMergeTwoLists() {
		
		// Given
		SortedLists.ListNode l1 = null;
		SortedLists.ListNode l2 = new SortedLists.ListNode(1);
		
		// When
		ListNode result = fixture.mergeTwoLists(l1, l2);
		
		// Then
		assertEquals(result.val, 1);
		
	}

}

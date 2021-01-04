package leetcode;

public class MergeTwoSortedLists {

	// Runtime: 0 ms, Memory Usage: 38.4 MB
	/**
	 * Merge two sorted linked lists and return it as a sorted list. The list should
	 * be made by splicing together the nodes of the first two lists
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	
		// Pre-check
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        // Initializations
        ListNode current1;
        ListNode current2;
        ListNode head;
        if(l1.val > l2.val) {
            head = new ListNode(l2.val);
            current1 = l2.next;
            current2 = l1;
        } else {
            head = new ListNode(l1.val);
            current1 = l1.next;
            current2 = l2;
        }
        ListNode currentResultNode = head;
        
        // List merge
        while(current1 != null || current2 != null) {
            
            if(current1 != null && current2 != null) {
                
                if(current1.val <= current2.val) {
                    currentResultNode.next = new ListNode(current1.val);
                    current1 = current1.next;
                } else {
                    currentResultNode.next = new ListNode(current2.val);
                    current2 = current2.next;
                }
                currentResultNode = currentResultNode.next;
                
            } 
            // Add all from current1 to result if the other is depleted
            else if(current2 == null) {
                
                while(current1 != null) {
                    currentResultNode.next = new ListNode(current1.val);
                    current1 = current1.next;
                    currentResultNode = currentResultNode.next;
                }
                break;
            }
            // Add all from current2 to result if the other is depleted
            else if(current1 == null) {
                
                while(current2 != null) {
                    currentResultNode.next = new ListNode(current2.val);
                    current2 = current2.next;
                    currentResultNode = currentResultNode.next;
                }
                break;
                
            } else {
                break;
            }
            
        }
        
        return head;
    }
    
    
    /** Definition for singly-linked list. */
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
    
}

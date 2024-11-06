/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        
        // Step 1: Detect if there is a cycle
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            // Cycle detected
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        
        // If no cycle was detected, return null
        if (!hasCycle) {
            return null;
        }

        // Step 2: Find the length of the cycle
        int lengthOfCycle = 0;
        ListNode temp = slow;
        do {
            temp = temp.next;
            lengthOfCycle++;
        } while (temp != slow);

        // Step 3: Find the start of the cycle
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        
        // Move pointer2 ahead by the length of the cycle
        for (int i = 0; i < lengthOfCycle; i++) {
            pointer2 = pointer2.next;
        }

        // Move both pointers one step at a time until they meet at the start of the cycle
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        // Both pointers now point to the start of the cycle
        return pointer1;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        //in-place reversal
        ListNode current = head;
        ListNode prev = null;

        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        return head;
       // return reverseRecursively(head);
        
    }

    // ListNode reverseRecursively(ListNode p){
    //     ListNode head = new ListNode();

    //     if(p.next == null){
    //         head = p;
    //         return head;
    //     }

        
    //     ListNode q = reverseRecursively(p.next);
    //     q.next = p;
    //     p.next = null;

    //     return head;
    // }
}
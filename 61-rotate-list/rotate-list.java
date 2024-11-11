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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k <= 0 || head.next == null){
            return head;
        }
        int length = 1;
        ListNode temp = head;
        // connect tail to head and count the length also
        while(temp.next != null){
            length++;
            temp = temp.next;
        }

        ListNode tail = temp;
        int validRotations = k%length;
        int end = length - validRotations;
        temp = head;
        for(int i = 0; temp != null && i < end-1 ; i++){
            temp = temp.next;
        }
        
        tail.next = head;
        head = temp.next;
        temp.next = null;

        // cutt off from tail k elements or L-k from start
        // the node that cut off point was poiting to is the head
        // if k> length of LL, then k % L is the actual count of rotations and rest are redundant 
        // this algo has Time Complexity : O(n) and space is O(1)

        return head;
    }
}
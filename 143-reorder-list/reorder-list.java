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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        // find mid and break from prev so that we may traverse in odd cases
        ListNode mid = findMid(head);

        //reverse from mid
        ListNode reverseMid = reverseLinkedList(mid);

        // form new list while both are non null by taking one from each
        ListNode reorderedList = new ListNode();
        ListNode reorderedHead = reorderedList;
        ListNode reorderedTail = reorderedHead;

        while(reverseMid != null && head != null){
            reorderedTail.next = head;
            head = head.next;
            reorderedTail = reorderedTail.next;

            reorderedTail.next = reverseMid;
            reverseMid = reverseMid.next;
            reorderedTail = reorderedTail.next;

        }

        reorderedTail.next = (head != null)? head: reverseMid;
        head = reorderedHead.next;
    }

    ListNode reverseLinkedList(ListNode head){
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
    }
    private ListNode findMid (ListNode head) {
        ListNode midPrev = null;
        while(head != null && head.next != null){
            midPrev = (midPrev == null)? head: midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
}
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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        // find mid-1 and mid
        // break from mid
        // reverse from mid
        // compare and return in case false
        // run loop till atleast one or both reach null whatever is earliest

        //ListNode mid = findMid(head);
        // ListNode midHead = reverseList(mid);

        ListNode mid = getMid(head);
        ListNode secondHead = reverseList(mid);
        ListNode reverseHead = secondHead;

        while(secondHead != null && head != null){
            if(secondHead.val != head.val){
               break;
            }
            secondHead = secondHead.next;
            head = head.next;
        }

        // if( head == null || secondHead == null){
        //     return true;
        // }

        reverseList(reverseHead);

        return head == null || secondHead == null;
    }

    // ListNode findMid ( ListNode head){
    //     ListNode prevMid = null;

    //     while(head != null && head.next != null){
    //         prevMid =(prevMid==null)? head: prevMid.next;
    //         head = head.next.next;
    //     }

    //     ListNode mid = prevMid.next;
    //     prevMid.next = null;
    //     return mid;
    // }

    ListNode getMid ( ListNode head){
        ListNode fp = head;
        ListNode sp = head;

        while(fp != null && fp.next != null){
            fp = fp.next.next;
            sp = sp.next;
        }

        return sp;
    }

    ListNode reverseList ( ListNode head){
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
        /**
        we can also only reverse the list from mid, run loops and then compare and break out if not true and then reverse again 
        */
    }
}
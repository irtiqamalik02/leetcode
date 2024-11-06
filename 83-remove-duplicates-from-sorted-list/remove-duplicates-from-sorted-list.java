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
    public ListNode deleteDuplicates(ListNode head) {
        //iterate over list
        // compare current and next vlaues till they are not equal
        //if equal skip the next repeating nodes otherwise continue

        ListNode temp = head;
        while(temp != null){

            //check for duplicates
            if(temp.next != null && temp.val == temp.next.val){
                ListNode current = temp;
                while(temp.next != null && temp.next.val ==  current.val){
                    temp = temp.next;
                }
                current.next=temp.next;
                temp=current;
            }
            //rearrange pointers
            temp = temp.next;

        }

        return head;
    }
}
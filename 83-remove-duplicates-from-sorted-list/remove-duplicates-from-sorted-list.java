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

        

        if(head == null){
            return head;
        }
        
        ListNode temp = head;
        while(temp.next != null){
            //check for duplicates
            if( temp.val == temp.next.val){
                temp.next = temp.next.next;
                
            }
            else{
                temp = temp.next;
            }

        }

        return head;
    }
}
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

        if(head == null){
            return null;
        }

        ListNode fp = head;
        ListNode sp = head;

        int lengthOfCycle = 0;
        boolean hasCycle = false;
        //detect cycle
        while(fp != null && fp.next != null){
            fp = fp.next.next;
            sp = sp.next;
            if(fp == sp){
                hasCycle = true;
                break;
            }
        }

        if(!hasCycle){
            return null; //since no cycle detected
        }

        ListNode temp = sp;
        do{
            temp = temp.next;
            lengthOfCycle++;
        }while(temp != sp);


        //traverse into LL by cycle length
        //reset pointer
        ListNode fp2 = head;
        ListNode sp2 = head;

        for (int i = 0; i < lengthOfCycle; i++){
            sp2 = sp2.next;
        }

        // find where fp and lp meet
        while(fp2 != sp2){
            
            sp2 = sp2.next;
            fp2 = fp2.next;
            
        }

        return sp2;
    }

   
}
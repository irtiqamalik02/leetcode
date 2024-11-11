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
            return head;
        }
        // find cycle length
        ListNode fp = head;
        ListNode sp = head;

         // Step 1: Detect if there is a cycle
        boolean hasCycle = false;
        while (fp != null && fp.next != null) {
            fp = fp.next.next;
            sp = sp.next;
            
            // Cycle detected
            if (fp == sp) {
                hasCycle = true;
                break;
            }
        }
        
        // If no cycle was detected, return null
        if (!hasCycle) {
            return null;
        }
        int count = 1;
        ListNode temp = sp.next;

        while(temp!= sp){
            count++;
            temp = temp.next;
        }

        //move sp by cycle legnht
        //reset sp
        sp = head;
        fp = head;
        while(count>0 && sp != null){
            sp = sp.next;
            count --;
        }
        // traverse 1 by 1 and find point of mating

        while(sp != fp){
            sp = sp.next;
            fp = fp.next;
        }

        return sp;

    }
}
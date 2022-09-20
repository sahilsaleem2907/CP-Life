/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode currA = headA, currB = headB;
        int headAsize = 0, headBsize = 0;
        
        while( currA  != null ){
             ++headAsize;
            currA = currA.next;
        }
        
        while( currB  != null ){
             ++headBsize;
            currB = currB.next;
        }
        
        int count = Math.abs(headAsize - headBsize);
        
        ListNode slow = headAsize > headBsize ? headB : headA;
        ListNode fast = headAsize > headBsize ? headA : headB;
        
        while(count --> 0){
            fast = fast.next;
        }
        
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
        
        
        
    }
}
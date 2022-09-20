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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        
         ListNode end = head; 
        int count = k; 
        
        while(count - 1 != 0 && end != null){
            end = end.next; count --;
        }
        
        if(end == null) return head; 
        
        ListNode start = end.next;
        end.next = null;
        
        ListNode newHead = reverse(head);
        head.next = reverseKGroup(start, k); 
        return newHead;
        
    }
    
    public ListNode reverse(ListNode head){
        
        ListNode curr = head, next = null, prev = null;
        
        while(curr != null){
            
            next = curr.next;
            curr.next = prev;
            prev = curr;
            
            curr = next;
            
        }
        
        return prev;
        
    }
}
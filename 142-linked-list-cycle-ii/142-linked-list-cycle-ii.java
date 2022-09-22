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
        
        if(head == null) return null;
        
        ListNode slow= head, fast = head, entry = head;
        
        while(fast != null && fast.next != null){
            
            
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) {
                
                while(slow != entry) {
                    
                    slow = slow.next;
                    entry = entry.next;
                    
                }
                
                return slow;
            }
            
        }
        
        return null;
        
    }
}
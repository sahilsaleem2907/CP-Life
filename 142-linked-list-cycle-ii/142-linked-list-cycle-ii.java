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
        
        HashSet<ListNode> freq = new HashSet<>();
        
        while(head != null){
            
            if(!freq.contains(head))
                freq.add(head);
            else
                return head;
            
            head = head.next;
            
        }
        
        return null;
        
    }
}
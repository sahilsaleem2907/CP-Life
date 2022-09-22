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
        
        ListNode curr = head;
        
        while(curr != null){
            
            if(!freq.contains(curr))
                freq.add(curr);
            else
                return curr;
            
            curr = curr.next;
            
        }
        
        return null;
        
    }
}
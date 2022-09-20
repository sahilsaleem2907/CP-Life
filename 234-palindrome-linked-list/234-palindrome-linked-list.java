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
        
        if(head == null) return false;
        
        if(head.next == null) return true;
        
        ListNode slow  = head, fast = head;
        
        Stack<Integer> dp =  new Stack<>();
        
        while(fast != null && fast.next != null){
            
            dp.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
            
        }
        
        
    if(fast != null) dp.push(slow.val);
                
        while(!dp.isEmpty() || slow != null){
            
            if(slow.val != dp.pop())
                return false;
            
            slow = slow.next;
            
        }
        
        return true;
        
    }
}
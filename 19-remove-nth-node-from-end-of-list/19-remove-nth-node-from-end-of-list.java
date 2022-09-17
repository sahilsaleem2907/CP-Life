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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        
        ListNode curr = head, temp = head;
        
        int size = 0;
        
        while(temp != null){
            ++size;
            temp = temp.next;
        }
        
        if(size == 1)
            return null;
        
        int index = size - n - 1;
        
        if(index + 1 == 0){
            head = head.next;
        }else{
            
            for(int i = index; i > 0 ; i--){
                
                curr = curr.next;
                
            }
            
            ListNode fut = curr.next.next;
            curr.next.next = null;
            curr.next = fut;
            
            
        }
        
        
        
        return head;
        
    }
}
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
        if(head==null || head.next==null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode newHead = reverse(slow);
        fast = head;
        while(newHead!=null){
            if(fast.val!=newHead.val){
                return false;
            }
            fast=fast.next;
            newHead=newHead.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode nxt = null;

        while(curr!=null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr=nxt;
        }
        return prev;
    }
}
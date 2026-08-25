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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    public ListNode mergeSort(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode rightHead = mid.next;
        mid.next=null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(rightHead);
        return merge(left, right);
    }
    public ListNode getMid(ListNode head){
        ListNode slow=head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode left = head1;
        ListNode right = head2;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(left!=null && right!=null){
            if(left.val<=right.val){
                temp.next=left;
                left=left.next;
                temp=temp.next;
            }else{
                temp.next=right;
                right=right.next;
                temp=temp.next;
            }
        }
        if(left!=null){
            temp.next=left;
        }
        if(right!=null){
            temp.next=right;
        }
        return dummy.next;
    }
}
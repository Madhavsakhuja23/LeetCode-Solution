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
        if(head == null || k==1){
            return head;
        }   
        int len = 0 ;
        ListNode tmp = head;
        while(tmp!=null){
            tmp=tmp.next;
            len++;
        }
        tmp = head;
        int grps = len/k;
        boolean found = false;
        ListNode prevGrpEnd = null;
        while(grps>0){
            ListNode strt = tmp;
            ListNode prev = null;
            for(int i=0;i<k;i++){
                prev=tmp;
                tmp=tmp.next;
            }
            ListNode newStart = prev.next;
            prev.next=null;
            ListNode rev = reverse(strt);
            ListNode ntemp = rev;
            if(prevGrpEnd !=null){
                prevGrpEnd.next=rev;
            }
            if(found==false){
                head=rev;
                found=true;
            }
            while(ntemp.next!=null){
                ntemp=ntemp.next;
            }
            prevGrpEnd = ntemp;
            ntemp.next=newStart;
            tmp=newStart;
            grps--;
        }
        return head;
    }

    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode nxt = null;
        ListNode prev = null;

        while(curr!=null){
            nxt = curr.next;
            curr.next = prev;
            prev= curr;
            curr=nxt;
        }
        return prev;
    }
}
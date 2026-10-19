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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tmp1 = list1;
        ListNode tmp2 = list2;
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        while(tmp1!=null && tmp2!=null){
            if(tmp1.val<=tmp2.val){
                tmp.next= new ListNode(tmp1.val);
                tmp1=tmp1.next;
                tmp=tmp.next;
            }else{
                tmp.next= new ListNode(tmp2.val);
                tmp2=tmp2.next;
                tmp=tmp.next;
            }
        }
        if(tmp1!=null){
            tmp.next=tmp1;
        }
        if(tmp2!=null){
            tmp.next=tmp2;
        }
        return res.next;
    }
}
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) {
            return head;
        }

        ListNode temp = head;
        int len = 0;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        temp = head;
        ListNode prevGroupEnd = null;

        while (len >= k) {

            ListNode move = temp;

            for (int i = 0; i < k - 1; i++) {
                move = move.next;
            }

            ListNode grpStrt = move.next;

            move.next = null;

            ListNode grpEnd = reverse(temp);

            // Connect previous group to current reversed group
            if (prevGroupEnd != null) {
                prevGroupEnd.next = grpEnd;
            } else {
                // First group
                head = grpEnd;
            }

            // temp is now the tail of the reversed group
            temp.next = grpStrt;

            // Save tail for next group
            prevGroupEnd = temp;

            temp = grpStrt;

            len -= k;
        }

        return head;
    }

    public ListNode reverse(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode nxt = curr.next;

            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        return prev;
    }
}
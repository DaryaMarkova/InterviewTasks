package list;

public class RemoveNodeFromListEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        head = new RemoveNodeFromListEnd().removeNthFromEnd(head, 0);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head, t;
        if (n < 1) return head;

        while(p != null) {
            t = p;

            int index = n;
            while (index-- > 0 && t != null) {
                t = t.next;
            }

            if (t != null && t.next == null) {
               p.next = p.next.next;
               return head;
            } else if (t == null && index < 0) {
                head = head.next;
                return head;
            }

            p = p.next;
        }

        return head;
    }
}

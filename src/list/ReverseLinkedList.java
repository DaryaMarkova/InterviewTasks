package list;

public class ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        ListNode p = head;
        int i = 1;

        while (p != null && ++i < m) {
            p = p.next;
        }

        if (p == null)
            return head;

        ListNode t = m > 1 ? p.next : p;
        i = n - m;

        ListNode fakeHead = null, fakeTail = null;
        ListNode s;

        while (i >= 0 && t != null) {
            s = t.next;

            if (fakeHead == null) {
                fakeHead = t;
                fakeTail = fakeHead;
            } else {
                t.next = fakeHead;
                fakeHead = t;
            }

            t = s;
            --i;
        }

        if (m == 1) {
            head = fakeHead;
        } else {
            p.next = fakeHead;
        }

        fakeTail.next = t;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode reversed = new ReverseLinkedList().reverseBetween(head, 1, 3);

        while (reversed != null ) {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        }
    }
}

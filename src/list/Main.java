package list;

public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode output = new Main().partition(head, 3);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode current = fake;

        while (current.next != null && current.next.next != null) {
            ListNode p = current.next;
            ListNode q = current.next.next;

            // swapping pair of elements
            p.next = q.next;
            current.next = q;
            current.next.next = p;
            // going to the next element
            current = current.next.next;
        }

        return fake.next;
    }

    public ListNode rotateRightNew(ListNode head, int k) {
        ListNode p = head, last = new ListNode(-1);

        int size = getSize(head, last);
        last = last.next;

        int m = (k <= size) ? k : k % size;

        if (m == size)
            return head;

        int i = 1;
        while (p != null && i < size - m) {
            p = p.next;
            ++i;
        }

        if (p.next == null)
            return head;

        ListNode t = p.next;
        p.next = null;
        last.next = head;

        return t;
    }

    public ListNode rotateRight(ListNode head, int k) {
        while (--k >= 0) {
            ListNode p = head, prevTail;

            while (p.next != null && p.next.next != null) {
                p = p.next;
            }

            prevTail = head.next == null ? null : p;
            head = swap(head, prevTail);
        }

        return head;

    }

    private int getSize(ListNode head, ListNode last) {
        ListNode p = head;
        int count = 0;

        while(p != null) {
            ++count;
            last.next = p;
            p = p.next;
        }

        return count;
    }

    private ListNode swap(ListNode head, ListNode prevTail) {
        if (prevTail == null)
            return head;

        ListNode temp = prevTail.next;
        prevTail.next = null;
        temp.next = head;

        return temp;
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode pHead = new ListNode(0);
        ListNode qHead = new ListNode(0);
        ListNode pTail = pHead, qTail = qHead;

        ListNode t = head;

        while (t != null) {
            if (t.val < x) {
               pTail.next = t;
               pTail = pTail.next;
            } else {
                qTail.next = t;
                qTail = qTail.next;
            }

            t = t.next;
        }

        qTail.next = null;
        pTail.next = qHead.next;

        return pHead.next;
    }
}

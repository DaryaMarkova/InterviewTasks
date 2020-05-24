package list;

public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        new Main().swapPairs(head);
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
}

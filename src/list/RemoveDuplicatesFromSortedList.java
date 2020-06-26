package list;


public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null)
            return null;

        ListNode p = head;
        ListNode fakeHead = new ListNode(0);
        ListNode fakeTail = fakeHead;

        while (p != null) {
            int count = 0;

            while (p.next != null && p.val == p.next.val) {
                ++count;
                p = p.next;
            }

            if (count == 0) {
                fakeTail.next = p;
                fakeTail = fakeTail.next;
            }

            if (p.next == null)
                fakeTail.next = null;

            p = p.next;

        }

        return fakeHead.next;
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode current = head, prev = null;

        while (current.next != null) {
            if (current.val == current.next.val) {
                if (prev == null) {
                    head = head.next;
                    current = head;
                } else {
                    prev.next = current.next;
                    current = prev.next;
                }
            } else {
                prev = current;
                current = current.next;
            }
        }

        return head;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;

        while ( true )  {
            if (pA == pB) {
                return pA;
            }

            if (pA.next == null && pB.next == null) {
                break;
            }

            pA = pA.next;

            if (pA == null) {
                pA = headB;
            }

            pB = pB.next;

            if (pB == null) {
                pB = headA;
            }

        }

        return null;
    }

    public ListNode deleteDuplicatesPureApproach(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
         ListNode head = new ListNode(1);
         head.next = new ListNode(1);
         head.next.next = new ListNode(1);
         head.next.next.next = new ListNode(1);
         head.next.next.next.next = new ListNode(1);
         head.next.next.next.next.next = new ListNode(2);
         head.next.next.next.next.next.next = new ListNode(3);
         // head.next.next.next.next.next.next.next = new ListNode(5);
         ListNode unique = new RemoveDuplicatesFromSortedList().deleteDuplicates2(head);

         while (unique != null) {
             System.out.print(unique.val + " ");
             unique = unique.next;
         }
    }
}

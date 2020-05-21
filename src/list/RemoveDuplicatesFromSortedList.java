package list;


public class RemoveDuplicatesFromSortedList {
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
        ListNode headA = new ListNode(1);
//        headA.next = new ListNode(3);
//        headA.next.next = new ListNode(5);

        ListNode headB = null;
//        headB.next = new ListNode(4);
//        headB.next.next = new ListNode(6);
//        headB.next.next.next = new ListNode(8);

//        ListNode common = new ListNode(5);
//        common.next = new ListNode(15);
//
//        headA.next.next.next = common;
//        headB.next.next.next.next = common;

        ListNode node = new RemoveDuplicatesFromSortedList().getIntersectionNode(headA, headB);
        System.out.print(node.val);
    }
}

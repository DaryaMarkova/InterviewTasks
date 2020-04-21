package list;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { val = x;}
}

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
        head.next.next.next.next.next = new ListNode(1);

        ListNode unifiedList = new RemoveDuplicatesFromSortedList().deleteDuplicates(null);
    }
}

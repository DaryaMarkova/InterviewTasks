package tree;
import list.ListNode;


public class SortedListToBST {
    public static void main(String[] args) {
        ListNode head = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9, null)))));
        TreeNode root =  new SortedListToBST().sortedListToBST(head);
    }

    private ListNode findMiddleElement(ListNode head) {
        ListNode pPrev = null;
        ListNode pSlow = head;
        ListNode pFast = head;

        while (pFast != null && pFast.next != null) {
            pPrev = pSlow;
            pSlow = pSlow.next;
            pFast = pFast.next.next;
        }

        // Handling the case when slowPtr was equal to head.
        if (pPrev != null) {
            pPrev.next = null;
        }

        return pSlow;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode mid = this.findMiddleElement(head);
        TreeNode node = new TreeNode(mid.val);

        if (head == mid) {
            return node;
        }

        node.left =  sortedListToBST(head);
        node.right = sortedListToBST(mid.next);

        return node;
    }

    public TreeNode sortedArrayToBST(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new TreeNode(array[start]);
        }

        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(array[mid]);
        root.left = sortedArrayToBST(array, start, mid - 1);
        root.right = sortedArrayToBST(array, mid + 1, end);

        return root;
    }
}

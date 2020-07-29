package tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightNode {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // TreeNode result = new PopulatingNextRightNode().connect(null);
        TreeNode connectedRoot = new PopulatingNextRightNode().efficientConnect(root);
    }

    public TreeNode efficientConnect(TreeNode root) {
        if (root == null) {
            return root;
        }

        if (root.left != null && root.right != null) {
            root.left.next = root.right;

            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }

        root.left = efficientConnect(root.left);
        root.right = efficientConnect(root.right);

        return root;
    }

    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (queue.isEmpty()) {
                break;
            }

            if (current == null) {
                queue.add(null);
                continue;
            }

            current.next = queue.peek();

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return root;
    }
}

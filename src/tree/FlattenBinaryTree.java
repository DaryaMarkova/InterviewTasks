package tree;

import java.util.Stack;

public class FlattenBinaryTree {
    // TODO: think how to improve this solution
    public void flatten(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }

            if (!stack.isEmpty()) {
                current.right = stack.peek();
            }

            current.left = null;
        }
    }

    public static void main(String[] args) {

    }
}

package tree;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
//
//        root.left.left = new TreeNode(1);
//        root.right.left.left = new TreeNode(3);
//        root.right.left.right = new TreeNode(4);

        List<List<Integer>> levels = new BinaryTreeZigzagLevelOrderTraversal().traverse(root);
    }

    private List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> tree = new LinkedList<>();

        if (root == null)
            return tree;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> level = new LinkedList<>();

            while (!stack1.isEmpty()) {
                TreeNode current = stack1.pop();
                level.add(current.val);

                if (current.left != null)
                    stack2.push(current.left);
                if (current.right != null)
                    stack2.push(current.right);
            }

            if (level.size() > 0) {
                tree.add(level);
            }

            level = new LinkedList<>();

            while (!stack2.isEmpty()) {
                TreeNode current = stack2.pop();
                level.add(current.val);

                if (current.right != null)
                    stack1.push(current.right);

                if (current.left != null)
                    stack1.push(current.left);
            }

            if (level.size() > 0) {
                tree.add(level);
            }
        }

        return tree;
    }
}

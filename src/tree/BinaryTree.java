package tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
}

public class BinaryTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

    public boolean isSymmetricIterative(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;

            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }

        return true;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public List<List<Integer>> breadthLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> levelList = new LinkedList<List<Integer>>();

        if (root == null) {
            return levelList;
        }

        queue.offer(root);

        while(!queue.isEmpty()){
            int levelCount = queue.size();
            List<Integer> subList = new LinkedList<>();

            for (int i= 0; i < levelCount; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }

                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }

                subList.add(queue.poll().val);
            }

            levelList.add(0, subList);
        }

        return levelList;
    }

    public List<List<Integer>> depthLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new LinkedList<>();

        if (root == null) {
            return levels;
        }

        depthLevelOrder(root, 0, levels);
        return levels;
    }

    void depthLevelOrder(TreeNode root, int level, List<List<Integer>> levels) {
        if (levels.size() <= level) {
            levels.add(0, new ArrayList<>());
        }

        if (root.left != null) {
            depthLevelOrder(root.left, level + 1, levels);
        }

        if (root.right != null) {
            depthLevelOrder(root.right, level + 1, levels);
        }

        levels.get(levels.size() - 1 - level).add(root.val);
    }

    public static void main(String[] args) {
         TreeNode root = new TreeNode(3);
         root.left = new TreeNode(9);
         root.right = new TreeNode(20);

         root.left.left = new TreeNode(4);
         root.left.right = new TreeNode(5);

         root.right.left = new TreeNode(15);
         root.right.right = new TreeNode(7);

         root.left.left.right = new TreeNode(8);

         new BinaryTree().depthLevelOrder(null);
    }
}

package tree;

import java.util.*;

class TreeNode {
    int val;

    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode(int x) {val = x;}
    boolean visited = false;
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

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = (high - low) / 2 + low;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBST(nums, low, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, high);

        return root;
    }

    private boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
         TreeNode root = new TreeNode(1);
         root.left = new TreeNode(2);
         System.out.println(new BinaryTree().hasPathSum(root, 1));
    }

}

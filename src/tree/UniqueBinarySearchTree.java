package tree;

public class UniqueBinarySearchTree {
    public static void main(String[] args) {
        UniqueBinarySearchTree tree = new UniqueBinarySearchTree();
        TreeNode root = tree.generateTrees(new TreeNode(3), 3, Integer.MIN_VALUE, Integer.MAX_VALUE, 1);
    }

    public TreeNode generateTrees(TreeNode root, int n, int minValue, int maxValue, int level) {
        for (int i = 1; i <= n; i++) {
            if (i > minValue && i < root.val) {
                root.left = generateTrees(new TreeNode(i), 3, minValue, root.val, level + 1);
            }

            if (i > root.val && i < maxValue) {
                root.right = generateTrees(new TreeNode(i), 3, root.val, maxValue, level + 1);
            }
        }

        return root;
    }

    public int countTrees(int n) {
        int arr[] = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                arr[i] += arr[j] * arr[i - j - 1];
            }
        }

        return arr[n];
    }
}

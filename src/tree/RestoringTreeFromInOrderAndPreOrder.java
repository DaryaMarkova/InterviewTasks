package tree;

import java.util.HashMap;

public class RestoringTreeFromInOrderAndPreOrder {
    HashMap<Integer, Integer> map = new HashMap<>();
    int preIndex = 0;
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

//        int[] inorder = new int[]{1,2};
//        int[] preorder = new int[]{1,2};
        TreeNode root = new RestoringTreeFromInOrderAndPreOrder().buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        return getTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode getTree(int[] preorder, int start, int end) {
        if (start > end)
            return null;


        int value = preorder[preIndex++];
        int split = map.get(value);

        TreeNode root = new TreeNode(value);

        if (start == end)
            return root;

        root.left = getTree(preorder, start, split - 1);
        root.right = getTree(preorder, split + 1, end);

        return root;
    }
}

package tree;

import java.util.HashMap;
import java.util.Map;

public class RestoringTreeFromInOrderAndPostOrder {
    public static void main(String[] args) {
        int[] inorder = new int[]{ 9,5,1,7,2,12, 8, 4, 3, 11};
        int[] postorder = new int[]{9,1,2, 12,7, 5, 3, 11,4,8};
//        int[] inorder = new int[]{1,2,3,4};
//        int[] postorder = new int[]{2,3,4,1};
//        int[] inorder = new int[] {4,2,5,1,3};
//        int[] postorder = new int[] {4,5,2,3,1};
//       int[] inorder = new int[]{1,2,3,4,5};
//       int[] postorder = new int[]{3,2,5,4,1};
       // [1,null,4,2,5,null,3]
//        int[] inorder = new int[] {9,3,15,20,7};
//        int[] postorder = new int[] {9,15,7,20,3};

        TreeNode root = new RestoringTreeFromInOrderAndPostOrder().buildTree(inorder, postorder);
        printInorder(root);
        System.out.println();
        printPostorder(root);
    }

    static void printPostorder(TreeNode node) {
        if (node == null)
            return;

        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.val + " ");
    }

    static void printInorder(TreeNode node) {
        if (node == null)
            return;

        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        TreeNode root = getTree(indexMap, postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1);
        return root;
    }

    TreeNode getTree(Map<Integer, Integer> indexMap, int[] postOrder, int[] inOrder, int pStart, int pEnd, int inStart, int inEnd) {
        if (pStart > pEnd || inStart > inEnd) return null;

        if (inStart == inEnd) {
            return new TreeNode(inOrder[inStart]);
        }

        int nodeValue = postOrder[pEnd];
        int splitIndex = indexMap.get(nodeValue);
        TreeNode node = new TreeNode(nodeValue);

        node.left = getTree(indexMap, postOrder,  inOrder, pStart, pStart + splitIndex - inStart - 1, inStart, splitIndex - 1);
        node.right = getTree(indexMap, postOrder, inOrder, pStart + splitIndex - inStart,pEnd - 1, splitIndex + 1, inEnd);
        return node;
    }
}

package tree;

import java.util.*;

class SumStack {
    Node head;
    private int sum = 0;

    class Node {
        TreeNode value;
        Node next;

        public Node(TreeNode value) {
            this.value = value;
        }
    }

    void push(TreeNode value) {
        if (head == null) {
            sum += value.val;
            head = new Node(value);
            return;
        }

        Node newHead = new Node(value);
        newHead.next = head;
        head = newHead;
        sum += newHead.value.val;
    }

    TreeNode pop() {
        Node current = head;

        if (head != null) {
            sum -= current.value.val;
            head = head.next;
            return current.value;
        }

        return null;
    }

    TreeNode peek() {
        return head.value;
    }

    int getSum() {
        return sum;
    }

    boolean isEmpty() {
        return head == null;
    }
}

// task 113
public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        // root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        // root.right.left = new TreeNode(13);
       //  root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        // root.right.right.left = new TreeNode(5);
        // root.right.right.right = new TreeNode(1);
        // List<List<Integer>> output = new PathSum().pathSum(root, 22);
        List<List<Integer>> output = new PathSum().pathSumUtilsIterative(root, 22);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> output = new LinkedList<>();

        if (root == null)
            return output;

        pathSumUtils(root, output, new LinkedList<>(), sum - root.val);
        return output;
    }

    public void pathSumUtils(TreeNode root, List<List<Integer>> output, List<Integer> combination, int sum) {
        combination.add(root.val);

        if (isLeaf(root) ) {
            if (sum == 0) {
                output.add(new ArrayList<>(combination));
            }

            return;
        }

        if (root.left != null) {
            pathSumUtils(root.left, output, combination, sum - root.left.val);
            combination.remove(combination.size() - 1);
        }

        if (root.right != null) {
            pathSumUtils(root.right, output, combination, sum - root.right.val);
            combination.remove(combination.size() - 1);
        }
    }

    // simplify
    // map for visited
    // stack with sum support
    public List<List<Integer>> pathSumUtilsIterative(TreeNode root, int target) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> output = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        SumStack stack = new SumStack();
        stack.push(root);

        while (!stack.isEmpty()) {
           TreeNode current = stack.peek();

           if (current.right != null && visited.containsKey(current.right)) {
               stack.pop();
               continue;
           }

           if (current.right == null && current.left != null && visited.containsKey(current.left)) {
               stack.pop();
               continue;
           }

           // is leaf
           if (current.left == null && current.right == null) {
               if (stack.getSum() == target) {
                   SumStack.Node pointer = stack.head;
                   List<Integer> path = new LinkedList<>();

                   while (pointer != null) {
                       path.add(0, pointer.value.val);
                       pointer = pointer.next;
                   }

                   output.add(path);
               }

               stack.pop();
           } else if (current.left != null && !visited.containsKey(current.left)) {
               stack.push(current.left);
               visited.put(current.left, true);
           } else if (current.right != null && !visited.containsKey(current.right)) {
               stack.push(current.right);
               visited.put(current.right, true);
           }
        }

        return output;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public void findPath(TreeNode root, int sum) {
        if (isLeaf(root) ) {
            if (sum == 0) {
                // print
                System.out.println(root.val);
            }

            return;
        }

        if (root.left != null) {
            findPath(root.left, sum - root.left.val);
            // sum += root.left.val;
        }

        if (root.right != null) {
            findPath(root.right, sum - root.right.val);
            // sum += root.right.val;
        }
    }
}

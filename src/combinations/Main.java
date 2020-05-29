package combinations;
import java.util.*;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
       //  List<List<Integer>> output =  new Main().combinationSum(new int[]{10,1,2,7,6,1,5}, 8);

        List<List<Integer>> output = new Main().permute(new int[]{1,2,3});
        output.forEach(list -> {
            list.forEach(item -> out.print(item));
            out.println();
        });
    }

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        Integer[] permutation = new Integer[n];
        List<List<Integer>> output = new LinkedList<>();
        permute(nums, visited, permutation, 0, output);
        return output;
    }


    private void permute(int[] nums, boolean[] visited, Integer[] permutation, int index, List<List<Integer>> output) {
        if (index == permutation.length) {
            output.add(new LinkedList<>(Arrays.asList(permutation)));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                permutation[index] = nums[i];
                visited[i] = true;
                permute(nums, visited, permutation, index + 1, output);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new LinkedList<>();
        Arrays.sort(candidates);
        findCombinations(candidates, target, 0,  new ArrayList<>(), output);

        return output;
    }

    private void findCombinations(int[] candidates, int target, int start, List<Integer> permutation, List<List<Integer>> result) {
        if (target == 0) {
            permutation.forEach((Integer number) -> System.out.print(number));
            System.out.println();
            result.add(new ArrayList<>(permutation));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i-1]) continue;

            permutation.add(permutation.size(), candidates[i]);

            findCombinations(candidates, target - candidates[i], i + 1, permutation, result);

            permutation.remove(permutation.size() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> output = new LinkedList<>();
        backtrack(output, "", 0, 0, n);
        // generateParenthesis(output, "(", n, 1, 0);
        return output;
    }

    public void backtrack(List<String> output, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            output.add(current);
            return;
        }

        if (open < max)
            backtrack(output, current.concat("("), open + 1, close, max);

        if (close < open)
            backtrack(output, current.concat(")"), open, close + 1, max);
    }

    private void generateParenthesis(List<String> output, String permutation, int total, int open, int close) {
        if (open == total && close == total) {
            out.println(permutation);
            output.add(permutation);
            return;
        }

        if (open < total) {
            generateParenthesis(output,permutation + "(", total, open + 1, close);
        }

        if (close < total && open > close) {
            generateParenthesis(output,permutation + ")", total, open, close + 1);
        }
    }
}

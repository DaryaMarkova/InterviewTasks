package combinations;
import java.util.*;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
      // new Main().getAllCombinations(4, 2);
        // System.out.println("Hello World")
        List<List<Integer>> output = new LinkedList<>();
        new Main().getSubsets(new int[]{1,2,3}, 0, new ArrayList<>(), output);
    }

    private List<List<Integer>> getSubsets(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();
        output.add(new ArrayList<>());
        getSubsets(nums, 0, new ArrayList<>(), output);
        return output;
    }

    private void getSubsets(int[] nums, int start, List<Integer> subset, List<List<Integer>> result) {
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            result.add(new LinkedList<>(subset));
            subset.forEach(it -> System.out.print(it));
            System.out.println();

            getSubsets(nums, i + 1, subset, result);

            if (!subset.isEmpty()) {
                subset.remove(subset.size() - 1);
            }
        }
    }

    public List<List<Integer>> getAllCombinations(int n, int k) {
        List<List<Integer>> combinations = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            getCombination(combinations, new LinkedList<>(), n, i, k);
        }

        return combinations;
    }

    private void getCombination(List<List<Integer>> output, List<Integer> combination, int n, int index, int k) {
        combination.add(index + 1);

        if (k == 1) {
            output.add(new LinkedList(combination));
            return;
        }

        for (int i = index + 1; i < n; i++) {
            getCombination(output, combination, n, i, k - 1);
            combination.remove(combination.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);

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
            if (i > 0 && visited[i - 1] && nums[i] == nums[i - 1])
                continue;

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

    public String getPermutation(int n, int k) {
        k = k - 1;
        StringBuilder result = new StringBuilder();
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(i + 1);
        }

        int index, fact;

        while (n > 0) {
            fact = factorial(n - 1);
            index = k / fact;
            result.append(numbers.get(index));
            numbers.remove(index);
            k = k - index * fact;
            n--;
        }

        return result.toString();
    }

    private int factorial(int number) {
        int result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }

        return result;
    }
}

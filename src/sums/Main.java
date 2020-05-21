package sums;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // List<List<Integer>> result = new Main().fourSum2(new int[] {-1, 0, -5, -2, -2, -2, -4, 0, 1, -2}, -9);
        new Main().fourSum2(new int[]{1, 0, -1, 0, -2, 2}, 0);
    }

    class Pair implements Comparable<Pair> {
        int sum;
        int value1;
        int value2;

        public Pair(int _sum, int _value1, int _value2) {
            sum = _sum;
            value1 = _value1;
            value2 = _value2;
        }

        @Override
        public int compareTo(Pair o) {
            if ((o.value1 == value1 && o.value2 == value2) || (o.value2 == value1 && o.value1 == value2)) {
                return 0;
            }

            return 1;
        }

    }


    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> output = new LinkedList<>();
        PriorityQueue<Pair> pairSums = new PriorityQueue<Pair>((o1, o2) -> o1.sum - o2.sum);

        int length = nums.length;
        if (length < 4)
            return output;

        Arrays.sort(nums);

        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                pairSums.add(new Pair(nums[i] + nums[j], nums[i], nums[j]));
            }
        }

        Pair[] pairs = new Pair[pairSums.size()];
        int index = 0;
        while (!pairSums.isEmpty()) {
            Pair nextPair = pairSums.remove();
            pairs[index++] = nextPair;
        }

        int left = 0, right = index - 1;

        while (left < right) {
            int currentSum = pairs[left].sum + pairs[right].sum;
            if (currentSum == target) {
                System.out.println(String.format("%d %d %d %d", pairs[left].value1, pairs[left].value2, pairs[right].value1, pairs[right].value2));
                output.add(Arrays.asList(new Integer[] {pairs[left].value1, pairs[left].value2, pairs[right].value1, pairs[right].value2}));
                left++; right--;
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }

        return output;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> output = new LinkedList<>();

        if (nums.length < 4)
            return output;

        Arrays.sort(nums);

        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1, right = length - 1;
                int targetSum = target - (nums[i] + nums[j]);

                while (left < right) {
                    while (left > j + 1 && left < right && nums[left - 1] == nums[left]) ++left;
                    while (right < length - 1 && right > 0 && nums[right] == nums[right + 1]) --right;

                    if (left >= right) break;

                    int currentSum = nums[left] + nums[right];

                    if (currentSum == targetSum) {
                        // output.add(Arrays.asList(new Integer[] {nums[i], nums[j], nums[left], nums[right]}));
                        System.out.println(String.format("%d %d %d %d", nums[i], nums[j], nums[left], nums[right]));
                        left++; right--;
                    } else if (currentSum < targetSum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return output;
    }
}

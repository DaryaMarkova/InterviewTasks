package sums;
import java.util.*;

public class Main {
    public static void main(String[] args) {
       List<List<Integer>> result = new Main().fourSum(new int[] {-1, 0, -5, -2, -2, -2, -4, 0, 1, -2}, -9);
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

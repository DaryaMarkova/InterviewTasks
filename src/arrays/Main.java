package arrays;
import java.util.Arrays;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1, 2,2,3};
        new Main().removeDuplicates(nums);
    }

    public int removeDuplicates(int[] nums) {
        return 0;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        if (nums.length < 1 || target < nums[0] || target > nums[nums.length - 1]) {
            return result;
        }

        int index = Arrays.binarySearch(nums, target);

        if (index < 0) return result;

        int lower =  index;
        int upper = lower;

        while (lower - 1 >= 0 && nums[lower - 1] == target) --lower;
        while (upper + 1 < nums.length && nums[upper + 1 ] == target) ++upper;


        result[0] = lower;
        result[1] = lower == upper ? -1 : upper;

        return result;
    }

    public void sortColors(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return;
        int start = 0;
        int end = nums.length - 1;
        int index = 0;
        while (index <= end && start < end) {
            if (nums[index] == 0) {
                nums[index] = nums[start];
                nums[start] = 0;
                start++;
                index++;
            } else if (nums[index] == 2) {
                nums[index] = nums[end];
                nums[end] = 2;
                end--;
            } else {
                index++;
            }
        }
    }
}

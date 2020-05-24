package arrays;
import java.util.Arrays;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        int[] range = new Main().searchRange(new int[]{5}, 6);

        out.println(String.format("%d %d", range[0], range[1]));
    }

    // O (n/2)
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
}

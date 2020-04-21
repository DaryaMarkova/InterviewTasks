package arrays;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = -1;

        while (++j < n) {
            while (i < m && nums1[i] < nums2[j]) { ++i; };

            if (i == m) {
                int k = m;

                while (j < n) {
                    nums1[k] = nums2[j++];
                    k += 1;
                }

                return;
            }
            // insert(nums1, i, nums2[j], m);
            int k = m;

            while(k > i) {
                nums1[k] = nums1[--k];
            }

            nums1[i] = nums2[j];
            m+=1;
        }
    }

    void insert(int[] nums, int pos, int val, int len) {
        int i = len;

        while(i > pos) {
            nums[i] = nums[--i];
        }

        nums[pos] = val;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 1, 1, 1, 0, 0, 0};
        int[] nums2 = new int[]{1, 1, 1};

        MergeSortedArray merge = new MergeSortedArray();
        merge.merge(nums1, 4, nums2, 3);
    }
}

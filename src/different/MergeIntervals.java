package different;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
    private class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
        }
    }

    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> merged = new LinkedList<>();
        Collections.sort(Arrays.asList(intervals), new IntervalComparator());

        for (int[] interval: intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
            {1, 5},
            {4, 7},
            {6, 10},
            {15, 17},
            {16, 20}
        };
        // {1,10}, {15, 17}, {16, 20}

        int[][] matrix = new MergeIntervals().merge(intervals);
    }

}

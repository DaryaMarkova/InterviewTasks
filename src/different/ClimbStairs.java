package different;

public class ClimbStairs {
    public int getCountOfWays(int i, int n) {
        if (i > n) {
            return 0;
        }

        if (i == n) {
            return 1;
        }

        return getCountOfWays(i + 1, n) + getCountOfWays(i + 2, n);
    }

    public int getCountOfWays(int n) {
        return getCountOfWays(0, n);
    }

    public int getCountOfWaysWithMemoization(int n) {
        int[] memo = new int[n + 1];
        return getCountOfWaysWithMemoization(0, n, memo);
    }

    public int getCountOfWaysWithMemoization(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }

        if (i == n) {
            return 1;
        }

        if (memo[i] > 0) {
            return memo[i];
        }

        memo[i] = getCountOfWaysWithMemoization(i + 1, n, memo) +
                getCountOfWaysWithMemoization(i + 2, n, memo);
        return memo[i];
    }

    public int getCountOfWaysDynamic(int n) {
        if (n == 1) {
            return 1;
        }

        int[] sequence = new int[n + 1];
        sequence[1] = 1;
        sequence[2] = 2;

        for (int i = 3; i <= n; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }

        return sequence[n];
    }

    public static void main(String[] args) {
       System.out.println(new ClimbStairs().getCountOfWaysDynamic( 5));
    }
}

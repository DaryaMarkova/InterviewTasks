package arrays;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // {9,1,5,2,8,4}
        // {2,4,1}
        System.out.println(new MaxProfit().maxProfit(new int[]{7,1,5,3,6,4}));
    }
}

package Leetcode;

public class MaxProfit {

    /**
     * @description 주식을 사고 팔아서 가장 큰 이익을 반환하는 문제
     * Input: [7,1,5,3,6,4]
     * Output: 7
     * input[1] 에 사서 input[2] 에 팔면 profit 4
     * input[3] 에 사서 input[4] 에 팔면 profit 3
     * Total profit = 7
     */
    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            total += Math.max(0, prices[i] - prices[i - 1]);
        }
        return total;
    }
}

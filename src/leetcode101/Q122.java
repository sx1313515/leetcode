package leetcode101;

/**
 * 描述:122. 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @Author: xiang_song
 * @CreateDate: 2021/3/24 19:30
 */
public class Q122 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 1) {
            return 0;
        }
        int[] memo = new int[length];
        if (prices[1] > prices[0]) {
            memo[0] = 1;  //买
        }
        if (prices[length-2] < prices[length-1]) {
            memo[length-1] = 2;  //卖
        }
        for (int i = 1; i < length-1; i++) {
            if (prices[i] > prices[i - 1] && prices[i] >= prices[i + 1]) {
                memo[i] = 2;
            } else if (prices[i] <= prices[i - 1] && prices[i] < prices[i + 1]) {
                memo[i] = 1;
            }
        }
        int sum = 0;
        int min = 0;
        for (int i = 0; i < length; i++) {
            if (memo[i] == 1) {
                min = prices[i];
            } else if (memo[i] == 2){
                sum += prices[i] - min;
            }
        }
        return sum;
    }
}

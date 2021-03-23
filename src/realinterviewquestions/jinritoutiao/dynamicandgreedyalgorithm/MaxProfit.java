package realinterviewquestions.jinritoutiao.dynamicandgreedyalgorithm;

/**
 * 描述:
 *给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * 思路：
 * 动态规划算法，记录之前的最大差距，并记录最小的值
 * @Author: xiang_song
 * @CreateDate: 2019/1/11 11:23
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length<2)
            return 0;
        int min=prices[0],max=0;
        for(int i=1;i<length;i++){
            min = Math.min(min, prices[i]);  //记录最小值
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}

package 面试真题.美团;

import java.util.ArrayList;
import java.util.List;

/*
 * 在股市的交易日中，假设最多可进行两次买卖(即买和卖的次数均小于等于2)，规则是必须一笔成交后进行另一笔(即买-卖-买-卖的顺序进行)。给出一天中的股票变化序列，请写一个程序计算一天可以获得的最大收益。请采用实践复杂度低的方法实现。
	给定价格序列prices及它的长度n，请返回最大收益。保证长度小于等于500。
	测试样例：
 */
/*
思路：
画出折线图，相邻的谷底和谷峰之差是一次收益，找出最大的两次收益再加起来
 */
public class StockExchangeDay {
		public static int maxProfit(int[] prices) {
            int i = 0;
            int valley = prices[0];
            int peak = prices[0];
            List<Integer> profits = new ArrayList<>();
            while (i < prices.length - 1) {
                while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                    i++;
                valley = prices[i];
                while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                    i++;
                peak = prices[i];
                profits.add(peak - valley);
            }
            return maxAndSecond(profits);

		}
		//求数组最大和第二大的数
		public static int maxAndSecond(List<Integer> nums) {
			int max = 0,second=0;
			if(nums.size()==2){
				max = Math.max(nums.get(0),nums.get(1));
				second = Math.min(nums.get(0),nums.get(1));
			}
			for(int i=3;i<nums.size();i++){
				if(nums.get(i)>max){
				    second = max;
				    max = nums.get(i);
                }else if(nums.get(i)>second){
				    second = nums.get(i);
                }
			}
			return max+second;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {10,22,5,75,65,80};
		System.out.println(maxProfit(a));
	}

}

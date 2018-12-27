package 面试真题.美团;

/*
 * 在股市的交易日中，假设最多可进行两次买卖(即买和卖的次数均小于等于2)，规则是必须一笔成交后进行另一笔(即买-卖-买-卖的顺序进行)。给出一天中的股票变化序列，请写一个程序计算一天可以获得的最大收益。请采用实践复杂度低的方法实现。
	给定价格序列prices及它的长度n，请返回最大收益。保证长度小于等于500。
	测试样例：
 */
/*
 * 思路：
自己看了一下网上的其他人的解法，发现果然很赞。
别人的思路是这样的。用两个数组，一个数组preProfit[i],
指的是第i+1天（数组下标从0开始）之前，当然也包括第i+1天的最大收益，
需要保存的一个数据是第i+1天之前的最小价格，
如果第i+1天的价格减去最小价格后的利润是要比不在这天卖出的利润大，
那么就果断卖出，否则，这一天就不卖出，
那么这天之前的最大利润和昨天的最大利润是一样的。
这样就使用了昨天的数据，这才是正统的动态规划的思想。
另外一个数组postProfit[i]指定是第i天买入的话，
之后所能获得的最大利润，需要保持一个变量记录第i+1天之后的最大价格，
如果最大价格减去这一天的利润比明天之后卖出的最大利润要大的话，
就卖出，否则，就等于明天之后卖出的最大利润。最后将两个数组求和，
计算出总的最大利润
 */
public class StockExchangeDay {
		public static int maxProfit(int[] prices, int n) {
			//第i天之前的最大利益
			int[] preProfit = new int[n];
			//第i天之后的最大
			int[] postProfit = new int[n];
			//总的最大利润
			int max = Integer.MIN_VALUE;
			//如果今天的价格减掉最小价格比截止到昨天的最大收益大，就用今天的价格减去最小价格，否则，用截止到昨天的最大收益
			int minBuy = prices[0];
			for(int i=1;i<n;i++)
			{
				minBuy = Math.min(minBuy, prices[i]);
				preProfit[i] = Math.max(preProfit[i-1],prices[i]-minBuy);
			}
			//如果最大价格减掉今天价格比明天以后买入的最大收益大，就用最大价格减掉今天价格，否则，用明天以后买入的最大收益
			int maxShell = prices[n-1];
			for(int i=n-2;i>=0;i--)
			{
				maxShell = Math.max(maxShell, prices[i]);
				postProfit[i] = Math.max(postProfit[i+1],maxShell-prices[i]);
			}
			//求出两次交易的和，与总的最大利润进行比较
			for(int i=0;i<n;i++)
			{
				max = Math.max(max, preProfit[i]+postProfit[i]);
			}
			return max;
				
					
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {10,22,5,75,65,80};
		System.out.println(maxProfit(a,a.length));
	}

}

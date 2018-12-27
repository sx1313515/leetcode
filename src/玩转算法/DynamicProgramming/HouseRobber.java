package 玩转算法.DynamicProgramming;
/*
 * 一条街的所有房子。每个房子里都有不同价值的宝物，
 * 但是如果你选择偷窃连个连续的房子就会报警。
 * 编程求出你最多能偷出的价值多少？
 */
public class HouseRobber {
	// memo[i] 表示抢劫 nums[i...n) 所能获得的最大收益
	static int[] memo;
	//考虑抢劫nums[index,nums.length)范围内的所有房子
	//递归加记忆搜索
	public static int fun2(int[] nums,int index) {
		if(index>=nums.length)
			return 0;
		if(memo[index]!=-1)
			return memo[index];
		int max = -1;
		for(int i = index;i<nums.length;i++)
		{
			max = Math.max(max,nums[i]+fun2(nums,i+2));
		}
		memo[index] = max;	
		return memo[index];
		// TODO Auto-generated method stub
	}	
	//动态规划
	public static int fun3(int[] nums) {
		if(nums.length==0)
			return 0;
		int[] memo1 = new int[nums.length];
		memo1[nums.length-1] = nums[nums.length-1];
		for(int i = nums.length-2;i>=0;i--)
		{
			for(int j=i;j<nums.length;j++)
			{
				memo1[i] = Math.max(memo1[i],nums[j]+((j+2)<nums.length?memo1[j+2]:0));
			}
		}	
		return memo1[0];
		
		// TODO Auto-generated method stub
	}
	public static int fun1(int[] nums) {
		// TODO Auto-generated method stub
		memo = new int[nums.length];
		for(int i=0;i<memo.length;i++) {
			memo[i] = -1;
		}
		return fun2(nums,0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,4,1,2};
		System.out.println(fun3(a));
	}

}

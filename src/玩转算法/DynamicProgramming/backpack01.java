package 玩转算法.DynamicProgramming;

/*
 * 有一个背包，它的容量为C。现在有n种不同的物品，编号为0,1..n-1
 * 其中每件物品的质量为w[i],每件物品的价值为v[i]。问可以向这个背包中
 * 乘放哪些物品，使得不超过背包容量的基础上，物品的总价值最大
 */
public class backpack01 {
	//动态规划算法
	public static int fun1(int[] w,int[] v,int c)
	{
		if(w.length==0||v.length==0)
			return 0;
		int n = w.length;
		int[][] memo = new int[n][c+1];
		for(int j=0;j<=c;j++)
		{
			if(j<w[0])
				memo[0][j] = 0;
			else
				memo[0][j] = v[0];
		}
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<=c;j++)
			{
				//空间复杂度优化
				memo[i%2][j] = memo[(i-1)%2][j];
//				memo[i][j] = memo[i-1][j];
				if(w[i]<=j)
					memo[i%2][j] = Math.max(memo[(i-1)%2][j],v[i]+memo[(i-1)%2][j-w[i]]);
//					memo[i][j] = Math.max(memo[i-1][j],v[i]+memo[i-1][j-w[i]]);
			}
		}
//		return memo[n-1][c];
		return memo[(n-1)%2][c];
	}
	static int[][] memo1;
	public static int fun2(int[] w, int[] v, int index, int c) {
		// TODO Auto-generated method stub
		if(index<0||c<=0)
			return 0;
		if(memo1[index][c]!=-1)
			return memo1[index][c];
		int result = fun2(w,v,index-1,c);
		if(c>=w[index])
			result = Math.max(result,v[index]+fun2(w,v,index-1,c-w[index]));
		memo1[index][c] = result;
		return result;
	}
	public static int fun3(int[] w,int[] v,int c)
	{
		int size = w.length;
		memo1 = new int[2][c+1];
		for(int i=0;i<2;i++)
			for(int j=0;j<=c;j++)
				memo1[i][j]=-1;
		return fun2(w,v,size-1,c);
	}

	public static void main(String[] args) {
		int[] w = {1,2,3};
		int[] v = {6,10,12};
		int c = 5;
		System.out.println(fun1(w,v,c));;
	}
}

package playingwiththealgorithm.DynamicProgramming;
/*
 * 给出两个字符串S1和S2，求这两个字符串的最长公共子序列的长度
 */
public class LongestCommonString {
//递归算法
	public static int fun1(char[] s1,char[] s2,int index1,int index2)
	{
		if(index1<0||index2<0)
			return 0;
		if(s1[index1]==s2[index2])
			return 1+fun1(s1,s2,index1-1,index2-1);
		else
			return Math.max(fun1(s1,s2,index1-1,index2),fun1(s1,s2,index1,index2-1)); 
	}
//动态规划算法
	public static int fun2(char[] s1,char[] s2)
	{
		int size1 = s1.length;
		int size2 = s2.length;
		int[][] memo = new int[size1+1][size2+1];
		for(int i=0;i<=size1;i++)
			for(int j=0;j<=size2;j++)
				memo[i][j] = 0;
		for(int i=1;i<=size1;i++)
		{
			for(int j=1;j<=size2;j++)
			{
				if(s1[i-1]==s2[j-1])
					memo[i][j] = 1+memo[i-1][j-1];
				else
					memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
			}
		}
		return memo[size1][size2];
	}
	public static int fun3(char[] s1,char[] s2)
	{
		int size1 = s1.length;
		int size2 = s2.length;
		return fun1(s1,s2,size1-1,size2-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "xyxzyxyzzy";
		String s2 = "xzyzxyzxyzxy";
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		System.out.println(fun2(c1, c2));
	}

}

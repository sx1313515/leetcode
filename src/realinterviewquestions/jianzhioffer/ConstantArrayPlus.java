package realinterviewquestions.jianzhioffer;

/*
 * 输入一个整形数组，里面有正数也有负数。数组中一个或者
 * 连续的多个组成一个子数组。求所有子数组和的最大值
 */
public class ConstantArrayPlus {
	public static int fun(int[] a)
	{
		a[0] = a[0];
		for(int i=1;i<a.length;i++)
		{
			if(a[i-1]<=0)
				a[i] = a[i];
			else
				a[i] = a[i]+a[i-1];
		}
		int res = a[0];
		for(int i=1;i<a.length;i++)
			res = Math.max(res, a[i]);
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,-2,3,10,-4,7,2,-5};
		System.out.println(fun(a));
	}

}

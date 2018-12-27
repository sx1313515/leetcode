package 面试真题.美团;
//将10个糖分给5个小朋友有多少种分发
public class DividedCandy {
	public static int fun(int n,int m)
	{
		int sum=0;
		if(n==0||m==1){
			return 1;
		}
		for (int i = 0; i <= n; i++) {
			sum+=fun(n-i,m-1);
		}
		return sum;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fun(10,5));
	}

}

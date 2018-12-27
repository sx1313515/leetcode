package 面试真题.排序算法;
//归并排序
public class Merge_sort {
	//将a数组中第m...n和第n+1...k合并成有序序列
	public static void merge(int[] a,int m,int n,int k)
	{
		int[] memo = new int[k-m+1];
		int i=m; int j=n+1; int s=0;
		while(i<=n&&j<=k)
		{
			if(a[i]<=a[j])
				memo[s++] = a[i++];
			else
				memo[s++] = a[j++];
		}
		if(i>n)
			while(j<=k)
				memo[s++] = a[j++];
		if(j>k)
			while(i<=n)
				memo[s++] = a[i++];
		for(int p=0;p<=k-m;p++)
		{
			a[m+p] = memo[p];
		}
	}
	//非递归归并排序
	public static void Merge_sort(int[] a)
	{
		int size = a.length;
		int i; //开始合并时第一个序列的起始位置
		int s;  //合并前大小
		int t = 1;  //合并后的大小
		while(t<=size)
		{
			s = t; t = 2*s; i=0;
			while((i+t)<size)
			{
				merge(a, i, i+s-1,i+t-1);
				i = i+t;
			}
			if((i+s)<size)
				merge(a, i, i+s-1, size-1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4,4,2,65,1,23,3,5,5,3,3};
		Merge_sort(a);
		for (int i : a) {
			System.out.print(i+" ");
		}
	}

}

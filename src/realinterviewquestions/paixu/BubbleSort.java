package realinterviewquestions.paixu;
/*
 * 起泡排序
 */
public class BubbleSort {
	public static void fun(int[] a)
	{
		int s;
		int size = a.length-1;
		int k = size-1;
		for(int i=0;i<=size;i++)
		{
			boolean flag = false;
			for(int j=0;j<=k;j++)
			{
				if(a[j+1]<a[j])
				{
					s = a[j+1];
					a[j+1] = a[j];
					a[j] = s;
					flag = true;
				}
			}
			if(!flag)
				break;
			k--;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {5,345,34,5,34,324234,23,4,234,23,423,4,23,3456,46,45,7,43};
		fun(a);
		for (int i : a) {
			System.out.print(i+" ");
		}
	}

}

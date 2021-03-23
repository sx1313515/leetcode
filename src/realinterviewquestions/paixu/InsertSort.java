package realinterviewquestions.paixu;
/*
 * 插入排序
 */
public class InsertSort {
	//直接插入排序
	public static void StraightInsertSort(int[] a)
	{
		int size = a.length-1;
		for(int i=1;i<=size;i++)
		{
			if(a[i]<a[i-1])
			{ 
				int s = a[i];
				int j=0;
					for(j=i-1;j>=0&&a[j]>s;j--)
					{
						a[j+1] = a[j];
					}
				a[j+1] = s;
			}
		}
	}
	//折半插入排序
	public static void BinaryInsertSort(int[] a)
	{
		int size = a.length-1;
		for(int i=1;i<=size;i++)
		{
			int s = a[i];
			int low = 0;
			int high = i-1;
			while(low<=high)
			{
				int m = (low+high)/2;
				if(a[m]>s)
					high = m-1;
				else
					low = m+1;
			}
			for(int j=i-1;j>=high+1;j--)
			{
				a[j+1] = a[j];
			}
			a[high+1] = s;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {5,345,34,5,34,324234,23,4,234,23,423,4,23,3456,46,45,7,43};
		StraightInsertSort(a);
		//BinaryInsertSort(a);
		for (int i : a) {
			System.out.print(i+" ");
		}
	}

}

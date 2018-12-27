package 面试真题.排序算法;
/*
 * 快速排序
 */
public class QuickSort {
	//一趟排序
	public static int Partition(int[] a,int low,int high)
	{
		int pivotkey = a[low];
		while(low<high)
		{
			while(low<high&&a[high]>=pivotkey)
				high--;
			a[low] = a[high];
			while(low<high&&a[low]<=pivotkey)
				low++;
			a[high] = a[low];
		}
		a[low] = pivotkey;
		return low;
	}
	//递归快速排序
	public static void QSort(int[] a,int low,int high)
	{
		if(low<high)
		{
			int pivotkey = Partition(a,low,high);
			QSort(a, low, pivotkey-1);
			QSort(a, pivotkey+1,high);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {5,345,34,5,34,324234,23,4,234,23,423,4,23,3456,46,45,7,43};
		QSort(a, 0, a.length-1);
		for (int i : a) {
			System.out.print(i+" ");
		}
	}

}

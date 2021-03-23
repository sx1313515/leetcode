package realinterviewquestions.paixu;
/*
 * 简单选择排序
 */
public class SimpleSelectSort {
	public static int selectMinKey(int[] a,int i)
	{
		int min = Integer.MAX_VALUE;
		int index=0;
		for(int j = i;j<a.length;j++)
		{
			if(a[j]<min)
			{
				min = a[j];
				index = j;
			}
		}
		return index;
	}
	public static void simpleSelectSort(int[] a)
	{
		for(int i=0;i<a.length;i++)
		{
			int index = selectMinKey(a, i);
			if(index!=i)
			{
				int temp = a[index];
				a[index] = a[i];
				a[i] = temp;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4,4,2,65,1,23,3,5,5,3,3};
		simpleSelectSort(a);
		for (int i : a) {
			System.out.print(i+" ");
		}
	}

}

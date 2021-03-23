package realinterviewquestions.paixu;

import java.util.Scanner;

public class HeapSort {
	
//元素上移操作,第i个元素
	public static void sift_up(int[] a,int i)
	{
		boolean flag = false;
		if(i>1)
		{
			while(!flag&&i>1)
			{
				if(a[i]>a[i/2])
				{
					int temp = a[i];
					a[i] = a[i/2]; 
					a[i/2] = temp; 
				}
				else
					flag = true;
				i = i/2;
			}
		}
	}
	//元素下移操作,第i个元素

	/**
	 *
	 * @param a
	 * @param n 在第1...n个元素范围内排序
	 * @param i
	 */
		public static void sift_down(int[] a,int n,int i)
		{
			while((i=2*i)<=n)  //只替换非叶子节点
			{
				if((i+1)<=n&&a[i+1]>a[i])  //替换两个节点中大的那个元素，因为是大顶堆
				{
					i = i +1;
				}
				if (a[i / 2] < a[i]) {  //如果子节点比父节点大，则替换
					int temp = a[i];
					a[i] = a[i / 2];
					a[i / 2] = temp;
				} else {  //如果子节点比父节点小，则不需要替换了
					return;
				}
			}
		}


	/**
	 * 构建一个堆，这里构建的是一个完全二叉树的堆，堆不一定是完全二叉树，但是为了方便存储一般构建成完全二叉树
	 *
	 * 对于所有非叶子节点，自上而下不断调整使其满足大顶堆的条件(每个节点值都大于等于其左右节点的值)即可，遍历到最后得到的堆一定是大顶堆！同时调整堆的过程中只是不断交换数组里的元素，没有用到额外的存储空间。
	 * 那么非叶子节点的范围是多少呢，假设数组元素为 n，则数组下标为 1 到 n / 2 的元素是非叶子节点。下标 n / 2 + 1 到 n 的元素是叶子节点。
	 * 画外音：假设下标 n/2+1 的节点不是叶子节点，则其左子节点下标为 (n/2 + 1) * 2 = n + 2，超过了数组元素 n，显然不符合逻辑，由此可以证明 n / 2 + 1 开始的元素一定是叶子节点。
	 * @param a 构建 大顶堆
	 * @param n
	 */
		public static void make_heap(int[] a,int n)
		{
			for (int i = n / 2; i >= 1; i--) {  //i = n/2是从第一个非叶子节点开始
				sift_down(a, n, i);
			}
		}
		//就地堆排序
		public static void heap_sort(int[] a,int n)
		{
			make_heap(a, n);
			for(int i=n;i>=1;i--)  //此时第一个元素是最大的，放到最后一个排好序，重复这样做，最后就变成增序的了
			{
				int temp = a[i];
				a[i] = a[1];
				a[1] = temp;
				sift_down(a, i-1,1);
			}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//从小到大的增序
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			int n = sc.nextInt();
			int[] a = new int[n+1]; //第0个位置不放元素，便于计算
			for(int i=0;i<n;i++)
			{
				a[i+1] = sc.nextInt();
			}
			heap_sort(a, n);
			for (int i=1;i<=n;i++) {
				System.out.print(a[i]+" ");
			}
		}
	}

}

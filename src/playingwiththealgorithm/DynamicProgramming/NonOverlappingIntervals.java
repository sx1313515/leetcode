package playingwiththealgorithm.DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 给定一组区间，问最多可以保留多少个区间，可以让这些区间之间互相不重叠
 */
public class NonOverlappingIntervals {
	//动态规划算法
	public static int fun1(node[] nodes){
		int size = nodes.length;
		int[] memo = new int[size];
		Arrays.fill(memo, 1);
		Arrays.sort(nodes,new node());
		for(int i = 1;i<size;i++)
			for(int j=0;j<i;j++)
				if(nodes[i].start>=nodes[j].end)
					memo[i] = Math.max(memo[i], 1+memo[j]);
		int res = 1;
		for(int i=0;i<size;i++)
			res = Math.max(res, memo[i]);
		return res;
	}
	//贪心算法
	public static int fun2(node[] nodes){
		int size = nodes.length;
		int[] memo = new int[size];
		Arrays.fill(memo, 1);
		//排序这个要改一下
		Arrays.sort(nodes,new node());
		int res = 1;
		int pre = 0;
		for(int i = 1;i<size;i++)
				if(nodes[i].start>=nodes[pre].end)
				{
					res++;
					pre = i;
				}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node[] a = {new node(3, 4),new node(2, 5),new node(2, 4),new node(1, 5),};
		System.out.println(fun1(a));
	}

}

class node implements Comparator<node>{
	public int start;
	public int end;
	public node()
	{
		
	}
	public node(int start0,int end0)
	{
		this.start = start0;
		this.end = end0;
	}
	@Override
	public int compare(node o1, node o2) {
		// TODO Auto-generated method stub
		int result = o1.start>o2.start?1:(o1.start==o2.start? 0:-1);
		if(result==0)
			result = o1.end>o2.end?1:-1;
		return result;
		
	}
}

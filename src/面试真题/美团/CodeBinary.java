package 面试真题.美团;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//请设计一个算法，给一个字符串进行二进制编码，
//使得编码后字符串的长度最短。
public class CodeBinary {
	public static List<Integer> transfer(String str)
	{
		char[] ch = str.toCharArray();
		HashMap<String,Integer> map = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<ch.length;i++)
		{
			if(map.containsKey(String.valueOf(ch[i])))
			{
				int value = map.get(String.valueOf(ch[i]));
				map.put(String.valueOf(ch[i]),value+1);
			}
			else
			{
				map.put(String.valueOf(ch[i]),1);
			}
		}
		for (Integer integer : map.values()) {
			list.add(integer);
		}
		for (Integer integer : list) {
		}
		return list;
	}
	public static List<Integer> Select(Node[] ht,int n)
	{
	  ArrayList<Integer> list = new ArrayList<Integer>();
	  list.add(3);
	  list.add(3);
	  int i;
	  int max=1000;
	  int se_max=1000;
	  for(i=1;i<=n;i++)
	  {
	    if((ht[i].parent==0)&&(ht[i].weight<=max))
	    {
	      max =ht[i].weight;
	      list.set(0,i);
	    }
	  }
	  for(i=1;i<=n;i++)
	  {
	    if((ht[i].parent==0)&&(i!=list.get(0))&&(ht[i].weight<=se_max))
	    {
	      se_max =ht[i].weight;
	      list.set(1,i);
	    }
	  }
	  return list;
	}
	public static Long CodeToBinary(List<Integer> list)
	{
		Long totalLength = (long) 0;
		Long Length = (long) 0;
		int m = list.size()*2-1;
		Node[] nodes = new Node[m+1];
		for(int i=0;i<m+1;i++)
			nodes[i] = new Node();
		if(list.size()<1)
			totalLength = (long) 0;
		for(int i=1;i<=list.size();i++)
		{
			nodes[i].weight = list.get(i-1);
			nodes[i].parent = 0;
			nodes[i].lchild = 0;
			nodes[i].rchild = 0;
		}
		for(int i=list.size()+1;i<=m;i++)
		{
			nodes[i].weight = 0;
			nodes[i].parent = 0;
			nodes[i].lchild = 0;
			nodes[i].rchild = 0;
		}
		for(int i=list.size()+1;i<=m;i++)
		{
			List<Integer> result = new ArrayList<>();
			result = Select(nodes,i-1);
			int s1 = result.get(0);
			int s2 = result.get(1);
			nodes[s1].parent=i;
			nodes[s2].parent=i;
			nodes[i].lchild=s1;
			nodes[i].rchild=s2;
			nodes[i].weight = nodes[s1].weight+nodes[s2].weight;
		}
		for(int i=1;i<=m;i++)
			nodes[i].flag=0;
		int q = m;
	  while(q>=1)
	  {
	    if(nodes[q].flag==0)  //向左
	    {
	      nodes[q].flag=1;
	      if(nodes[q].lchild!=0)
	      {
	        q=nodes[q].lchild;
	        Length++;
	      }
	      else if(nodes[q].rchild==0)  //登记叶子结点的字符编码
	      {
	    	  nodes[q].len = Length;
	      }
	    }
	    else if(nodes[q].flag==1)  //向右
	    {
	    	nodes[q].flag=2;
	      if(nodes[q].rchild!=0)
	      {
	        q = nodes[q].rchild;
	        Length++;
	      }
	    }
	    else   //回调，退回到父结点，编码长度减1
	    {
	    	nodes[q].flag=0;
	      q = nodes[q].parent;
	      Length--;
	    }
	  }
	  for(int i=1;i<=list.size();i++)
	  {
		  totalLength = totalLength+(nodes[i].weight)*(nodes[i].len);  
	  }
		return totalLength;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			String s = sc.nextLine();
			List<Integer> list = new ArrayList<>();
			list = transfer(s);
			Long result = CodeToBinary(list);
			System.out.println(result);
		}
	}

}

class Node{
	int weight;
	int parent;
	int lchild;
	int rchild;
	Long len;
	int flag;
	public String toString() {
		return "Node [weight=" + weight + ", parent=" + parent + ", lchild=" + lchild + ", rchild=" + rchild + ", len="
				+ len + ", flag=" + flag + "]";
	}
} 

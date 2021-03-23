package playingwiththealgorithm.RecurionAndBackstracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * n皇后问题，要求在n*n的国际象棋的棋盘上放置n个皇后，
 * 使其不再同一行同一列或斜率为+-1的同一斜线上
 */
public class NQueens {
	public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	public static boolean[] col;
	public static boolean[] dia1;
	public static boolean[] dia2;
	public static void PutQueen(int n,int row,ArrayList<Integer> p) 
	{
		if(row==n)
		{
			ArrayList<Integer> arraylist0 = new ArrayList<>();
			for(int i=0;i<p.size();i++)
				arraylist0.add(p.get(i));
			list.add(arraylist0);
			return;
		}
		for(int j=0;j<n;j++)
			if(!col[j]&&!dia1[j+row]&&!dia2[row-j+n-1])
			{
				p.add(j);
				col[j] = true;
				dia1[j+row] = true;
				dia2[row-j+n-1] = true;
				PutQueen(n, row+1,p);
				col[j] = false;
				dia1[j+row] = false;
				dia2[row-j+n-1] = false;
				p.remove(p.size()-1);
			}
		return;
		
	}
	public static ArrayList<ArrayList<Integer>> FindQueen(int n) 
	{
		ArrayList<Integer> arraylist = new ArrayList<>();
		col = new boolean[n];
		dia1 = new boolean[2*n-1];
		dia2 = new boolean[2*n-1];
		Arrays.fill(col, false);
		Arrays.fill(dia1, false);
		Arrays.fill(dia2, false);
		PutQueen(n,0,arraylist);
		return list;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			int n = sc.nextInt();
			ArrayList<ArrayList<Integer>> list0 = new ArrayList<>();
			list0 = FindQueen(n);
			for(int i=0;i<list0.size();i++)
			{
				int[][] show = new int[n][n];
				for(int j=0;j<list0.get(i).size();j++)
					show[j][list0.get(i).get(j)] =1;
				for(int g =0;g<n;g++)	
				{
					for(int h =0;h<n;h++)
					{
						System.out.print(show[g][h]+" ");
					}
					System.out.println();
				}	
				System.out.println();
				System.out.println();
				System.out.println();
				
			}
	
			
		}
			
	}
}

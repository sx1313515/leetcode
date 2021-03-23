package realinterviewquestions.wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 小易有一些彩色的砖块。每种颜色由一个大写字母表示。
 * 各个颜色砖块看起来都完全一样。现在有一个给定的字符串s,
 * s中每个字符代表小易的某个砖块的颜色。小易想把他所有的砖块排成一行。
 * 如果最多存在一对不同颜色的相邻砖块,那么这行砖块就很漂亮的。
 * 请你帮助小易计算有多少种方式将他所有砖块排成漂亮的一行。
 * (如果两种方式所对应的砖块颜色序列是相同的,那么认为这两种方式是一样的。)
例如: s = "ABAB",那么小易有六种排列的结果:
 */
public class ColorfulStocks {
	public static int fun(String s)
	{
		char[] ch = s.toCharArray();
		List<String> list = new ArrayList<String>();
		for(int i=0;i<ch.length;i++)
			if(list.contains(String.valueOf(ch[i])))
				continue;
			else
				list.add(String.valueOf(ch[i]));
		int size = list.size();
		if(size==1)
			return 1;
		else if(size==2)
			return 2;
		else
			return 0;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			String s = sc.next();
			System.out.println(fun(s));
		}
	}
}

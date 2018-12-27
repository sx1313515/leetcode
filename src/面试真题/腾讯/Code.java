package 面试真题.腾讯;
/*
 * 假定一种编码的编码范围是a ~ y的25个字母，
 * 从1位到4位的编码，如果我们把该编码按字典序排序，
 * 形成一个数组如下： a, aa, aaa, aaaa, aaab, aaac, … …, 
 * b, ba, baa, baaa, baab, baac … …, yyyw, yyyx, yyyy 
 * 其中a的Index为0，aa的Index为1，aaa的Index为2，以此类推。
 *  编写一个函数，输入是任意一个编码，输出这个编码对应的Index. 
 */
import java.util.Scanner;

public class Code {
	public static int fun(String s)
	{
		char[] ch = s.toCharArray();
		int size = ch.length;
		int sum = 0;  //记录总的编号
		int memo = 0; //保存已有记录的计算结果
		for(int i=0;i<4;i++)
		{
			memo = memo*25;
			if(i<size)
			{
				memo = memo+ch[i]-'a';
			}
			sum = sum + memo;
			if(i<size-1)
			{
				sum = sum+1;
			}
		}
		return sum;
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

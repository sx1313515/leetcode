package 面试真题.网易;
/*
 小易准备去魔法王国采购魔法神器,购买魔法神器需要使用魔法币,
 但是小易现在一枚魔法币都没有,
 但是小易有两台魔法机器可以通过投入x(x可以为0)个魔法币产生更多的魔法币。
魔法机器1:如果投入x个魔法币,魔法机器会将其变为2x+1个魔法币
魔法机器2:如果投入x个魔法币,魔法机器会将其变为2x+2个魔法币
小易采购魔法神器总共需要n个魔法币,
所以小易只能通过两台魔法机器产生恰好n个魔法币,
小易需要你帮他设计一个投入方案使他最后恰好拥有n个魔法币
 */
import java.util.Scanner;

public class MagicCoin {
	public static String s="";
	public static String fun(int n)
	{
		if(n==0)
			return s;
		if((n-1)%2==0)
		{
			s = s+"1";
			n = (n-1)/2;
			fun(n);
		}
		else
		{
			s = s+"2";
			n = (n-2)/2;
			fun(n);
		}
		return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
				int n = sc.nextInt();
				String ss = fun(n);
				char[] ch = ss.toCharArray();
				for(int i=ch.length-1;i>=0;i--)
					System.out.print(String.valueOf(ch[i]));
				
		}
	}

}

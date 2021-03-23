package realinterviewquestions.wangyi;

import java.util.Scanner;

/*
小易为了向他的父母表现他已经长大独立了,他决定搬出去自己居住一段时间。
一个人生活增加了许多花费: 小易每天必须吃一个水果并且需要每天支付x元的房屋租金。
当前小易手中已经有f个水果和d元钱,小易也能去商店购买一些水果,
商店每个水果售卖p元。小易为了表现他独立生活的能力,
希望能独立生活的时间越长越好,小易希望你来帮他计算一下他最多能独立生活多少天。 
 */
public class IndependentLittleYi {
	public static int fun(int x,int f,int d,int p)
	{
		if(d/f<x)
			return d/x;
		else
		{
			return f+(d-f*x)/(p+x);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			int x = sc.nextInt();
			int f = sc.nextInt();
			int d = sc.nextInt();
			int p = sc.nextInt();
			System.out.println(fun(x, f, d, p));
		}
	}

}

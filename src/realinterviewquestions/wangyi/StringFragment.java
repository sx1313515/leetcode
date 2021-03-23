package realinterviewquestions.wangyi;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class StringFragment {
	public static float fun(String s)
	{
		HashMap<String, Integer> map = new HashMap<>();
		char[] ch = s.toCharArray();
		int size = ch.length;
		int sum = 1;
		char c = ch[0];
		for(int i=1;i<size;i++)
		{
			if(ch[i]==c)
			{
				sum++;
				if(i == size-1)
				{
					if(map.containsKey(String.valueOf(c)))
						map.put(String.valueOf(c),Math.max(sum,map.get(String.valueOf(c))));
					else
						map.put(String.valueOf(c),sum);
				}
			}
			else
			{
				if(map.containsKey(String.valueOf(c)))
					map.put(String.valueOf(c),Math.max(sum,map.get(String.valueOf(c))));
				else
					map.put(String.valueOf(c),sum);
				sum = 1;
				c = ch[i];
				if(i==size-1)
				{
					if(map.containsKey(String.valueOf(c)))
						map.put(String.valueOf(c),Math.max(sum,map.get(String.valueOf(c))));
					else
						map.put(String.valueOf(c),sum);
				}
			}
		}
		float mapsize = map.size();
		float total = 0;
		Set<String> set = map.keySet();
		for (String string : set) {
			System.out.println(string);
			total += map.get(string);
		}
		System.out.println(mapsize+"  "+total);
		return (float)Math.round(total/mapsize*100)/100;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
				String s = sc.next();
				System.out.println(fun(s));
		}
	}

}

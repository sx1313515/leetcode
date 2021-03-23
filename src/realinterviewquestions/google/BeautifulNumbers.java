package realinterviewquestions.google;


public class BeautifulNumbers {
	public static boolean isBeautiful(Long n,Long ary)
	{
		Long beichu=n;
		Long shang;
		Long yushu;
		shang = n/ary;
		yushu = n%ary;
		if(yushu!=1)
			return false;
		while(shang!=0)
		{
			beichu = shang;
			shang = beichu/ary;
			yushu = beichu%ary;
			if(yushu!=1)
				return false;
		}
		return true;
	}
	public static Long isBeautifulNumbers(Long n)
	{
		Long result = (long) 0;
		if(n==1)
			result = (long) 2;
		else
		{
			for(Long i=(long)2;i<n;i++)
			{
				if(isBeautiful(n,i))
				{
					result = i;
					break;
				}
			}
		}
		return result;
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Long n = (long) 15;
		System.out.println(isBeautifulNumbers(n));
	}

}

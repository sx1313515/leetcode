package ��������.����;

public class DivideApple {
/*
 * ��԰����һ��ƻ����һ��nͷ(n����1С��9)�����֣���һͷΪС����
 * ����ƻ������n�ݺ󣬶����һ�������ӵ�����һ����
 * �������Լ���һ��ƻ�������ŵڶ�ͷ���ظ���һ���̣�
 * ���Ⱦ���n�ݣ��ӵ�һ��Ȼ������һ�ݣ�
 * �Դ�����ֱ�����һͷ�ܶ�������(���һͷ���ӵ����������0����
 * Ҳ����n�ݾ���)����������ƻ�������ж��ٸ���
  ����һ������n,��ʾ�ܵĸ��������������ƻ��������֤�н⡣
 */
	public static int getInitial(int n) {
		for(int i=n+1;;i++)
		{
			int bear = n;
			int temp = i;
			while(bear>0)
			{
				if(temp%n==1)
				{
					temp = temp-1-temp/n;
					bear--;
				}
				else
				{
					break;
				}
			}
			if(bear==0)
				return i;
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		System.out.println(getInitial(n));
		System.out.println();
	}

}

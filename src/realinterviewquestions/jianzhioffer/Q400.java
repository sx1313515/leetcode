package realinterviewquestions.jianzhioffer;

/**
 * 描述:第 N 位数字
 *在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 位数字。
 * @Author: xiang_song
 * @CreateDate: 2021/3/31 8:59
 */
public class Q400 {
    public int findNthDigit(int n) {
        long num=n;

        long size=1;  //表示这个数是几位数
        long max=9;

        while(n>0){
            //判断不在当前位数内
            if(num-max*size>0){
                num=num-max*size;
                size++;
                max=max*10;
            }else{
                long count=num/size;  //num表示这个数是在size位数里面的第多少位
                long left=num%size;  //表示结果是在这个数的第几位
                if(left==0){
                    return (int) (((long)Math.pow(10, size-1)+count-1)%10);
                    //求出那个数，并去第left位
                }else{
                    return (int) (((long)Math.pow(10, size-1)+count)/((long)Math.pow(10, (size-left)))%10);
                }
            }
        }

        return 0;
    }

}

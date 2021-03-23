package realinterviewquestions.tencent.math;

/**
 * 描述:
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方
 * @Author: xiang_song
 * @CreateDate: 2019/2/14 9:24
 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n<1)
            return false;
        if (n==1)
            return true;
        while (n/2>0){
            if (n%2==1)
                return false;
            n = n / 2;
        }
        return true;
    }
}

package dynamicplanning;

import java.math.BigInteger;

/**
 * @ProjectName: leetcode
 * @Package: dynamicplanning
 * @ClassName: Test
 * @Description: java类作用描述
 * @Author: 唐朝
 * @CreateDate: 2018/12/28 10:44
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/12/28 10:44
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Test {
    public int uniquePaths(long m, long n) {
        if(m==1&&n==1)
            return 1;
        return jiecheng(m+n-2).divide(jiecheng(m-1)).divide(jiecheng(n-1)).intValue();
    }
    public BigInteger jiecheng(long n){
        if(n==1||n==0){
            return BigInteger.valueOf(1);
        }else{
            return BigInteger.valueOf(n).multiply(jiecheng(n-1));
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.uniquePaths(1,2));;
    }
}

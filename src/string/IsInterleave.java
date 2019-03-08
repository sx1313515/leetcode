package string;

/**
 * 描述:
 *给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * 示例 1:
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 * @Author: xiang_song
 * @CreateDate: 2019/3/6 13:44
 */
public class IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        char[] chars3 = s3.toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;
        int length3 = chars3.length;
        if(length1+length2!=length3)
            return false;
        int index1 = 0,index2 = 0,index3 = 0;
        if(length1==0){  //s1为空串的情况
            while (index3<length3){
                if (chars3[index3]==chars2[index2]){
                    index2++;
                }else {
                    return false;
                }
                index3++;
            }
            return true;
        }
        if(length2==0){  //s2为空串的情况
            while (index3<length3){
                if (chars3[index3]==chars1[index1]){
                    index1++;
                }else {
                    return false;
                }
                index3++;
            }
            return true;
        }
        while (index3<length3){
            if (index1<length1&&chars3[index3]==chars1[index1]){
                index1++;
            }else if (index2<length2&&chars3[index3]==chars2[index2]){
                index2++;
            }else {
                if (index1<length1&&index2<length2){
                    return false;
                }
            }
            index3++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsInterleave().isInterleave("a","","c"));
    }
}

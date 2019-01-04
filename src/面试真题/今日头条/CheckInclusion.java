package 面试真题.今日头条;

import java.util.HashMap;

/**
 * 描述:
 *给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串
 * 思路
 * 我们先来看使用两个哈希表来做的情况，我们先来分别统计引和 52 中前 n1
 * 个字符串中各个字符出现的次数，其中 n1 为字符串引的长度，这样如果二者
 * 字符出现次数的情况完全相同，说明引和 s2 中前 n1 的字符互为全排列关系，
 * 那么符合题意了，直接返回 true 。如果不是的话，那么我们遍历 52 之后的字符，
 * 对于遍历到的字符，对应的次数加 1 ，由于窗口的大小限定为了 n1 ，所以每在窗
 * 口右侧加一个新字符的同时就要在窗口左侧去掉一个字符，每次都比较一下两个哈希
 * 表的情况，如果相等，说明存在，参见代码如下：
 * @Author: g
 * @CreateDate: 2019/1/4 9:37
 */
public class CheckInclusion {
    public static boolean checkInclusion(String s1, String s2) {
        int s1_length = s1.length();
        int s2_length = s2.length();
        int index=0,count=0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s1_length;i++){
            if(map.get(s1.charAt(i))==null){
                map.put(s1.charAt(i),1);
            }else{
                map.put(s1.charAt(i),map.get(s1.charAt(i))+1);
            }
        }
        while(index<=s2_length-s1_length){
            boolean isdo = true;
            boolean isfinished = true;
            HashMap<Character,Integer> map0 = new HashMap<>(map);
            for(int i=0;i<s1_length;i++){
                if(map.get(s2.charAt(i+index))==null){
                    index = index+i+1;
                    isdo = false;
                    break;
                }else if(map.get(s2.charAt(i+index))==0){
                    index++;
                    isdo = false;
                    break;
                }else {
                    map0.put(s2.charAt(i + index), map0.get(s2.charAt(i + index))-1);
                }
            }
            if(isdo){
                for(Integer value:map0.values()){
                    if(value!=0){
                        isfinished=false;
                        index++;
                        break;
                    }
                }
                if(isfinished){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "abcdxabcde";
        String s2 = "abcdeabcdx";
        System.out.println(checkInclusion(s1,s2));
    }
}

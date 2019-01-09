package 面试真题.今日头条;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * @Author: g
 * @CreateDate: 2019/1/7 15:06
 */
public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        int length = s.length();
        int count = 0;
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if(length>12||length<4)
            return result;
        fun(result,sb,s,count);
        return result;
    }

    private void fun(List<String> result, StringBuilder sb,String s,int count) {
        for(int i=1;i<=3&&i<=s.length();i++){
            String temp = s.substring(0,i);
            String remain = s.substring(i,s.length());
            if(temp.charAt(0)=='0'&&temp.length()>1)
                break;
            if(remain.length()<(count==3?0:(4-count-1))||remain.length()>(count==3?3:((4-count-1)*3)))
                continue;
            if(Integer.valueOf(temp)>255)
                break;
            if(count==3&&remain.length()!=0)
                continue;
            sb.append(temp + ".");
            count++;
            if(count==4) {
                result.add(sb.deleteCharAt(sb.length() - 1).toString());
                sb.delete(sb.length() - temp.length(), sb.length());
                count--;
                break;
            }
            fun(result,sb,remain,count);
            sb.delete(sb.length() - temp.length()-1, sb.length());
            count--;
        }
    }

    public static void main(String[] args) {
        String s = "0000";
        List<String> strings = new RestoreIpAddresses().restoreIpAddresses(s);
        System.out.println();
    }

}

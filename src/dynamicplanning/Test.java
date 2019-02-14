package dynamicplanning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public String reverseString(char[] s) {
        int length = s.length;
        if(length<=1)
            return String.valueOf(s);
        char temp;
        for(int i=0;i<length/2;i++){
            temp = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = temp;
        }
        return String.valueOf(s);
    }
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        String result = "";
        for (int i = 0; i < strs.length; i++) {
            result = result+reverseString(strs[i].toCharArray())+" ";
        }
        result = result.trim();
        return result;
    }
    public int[] productExceptSelf(int[] nums) {
        int sum = 1;
        int count = 0;
        int index = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if(nums[i]==0){
                index = i;
                count++;
                continue;
            }
            sum = sum*nums[i];
        }
        if(count>1) {
            Arrays.fill(nums, 0);
            return nums;
        }
        if(count==1){
            Arrays.fill(nums, 0);
            nums[index] = sum;
            return nums;
        }
        for (int i = 0; i < length; i++) {
            nums[i] = sum / nums[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(new Test().productExceptSelf(new int[]{9,0,-2}));;
    }
}


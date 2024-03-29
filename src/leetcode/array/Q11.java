package leetcode.array;

/**
 * 描述:盛最多水的容器
 *给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别
 * 为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * @Author: xiang_song
 * @CreateDate: 2021/4/27 17:33
 */
public class Q11 {
    public int maxArea(int[] height) {

        int result = 0;
        int low = 0, heigh = height.length-1;
        while(low<heigh){
            result = Math.max(result, (heigh - low) * Math.min(height[low],
                    height[heigh]));
            if(height[heigh]>height[low]){
                low++;
            }else {
                heigh--;
            }
        }
        return result;
    }
}

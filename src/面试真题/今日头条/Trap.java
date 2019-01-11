package 面试真题.今日头条;

/**
 * 描述:
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 思路：先找出最高的柱子，然后从两边向中间的柱子遍历，
 * 左往右遍历时，如果后面的柱子比前面的矮，也两则的距离就是积累的水，再把后面柱子的高度设置为前面的柱子
 * 右往左遍历时，如果前面的柱子比后面的矮，也两则的距离就是积累的水，再把前面柱子的高度设置为后面的柱子
 * @Author: xiang_song
 * @CreateDate: 2019/1/11 10:34
 */
public class Trap {
    public int trap(int[] height) {
        if(height.length<3){
            return 0;
        }
        int index = 0;
        int max = height[0];
        int result = 0;
        //找出最高柱子的位置
        for (int i = 1; i < height.length; i++) {
            if(height[i]>max){
                max = height[i];
                index = i;
            }
        }
        //左往右遍历
        for (int i = 0; i <= index-1; i++) {
            if(height[i+1]>=height[i]){
                continue;
            }else {
                result = result + height[i]-height[i+1];
                height[i + 1] = height[i];
            }
        }
        //右往左遍历
        for(int i=height.length-1;i>=index+1;i--){
            if(height[i-1]>=height[i]){
                continue;
            }else {
                result = result + height[i]-height[i-1];
                height[i-1] = height[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] values = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        new Trap().trap(values);
        System.out.println();
    }
}

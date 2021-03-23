package realinterviewquestions.jinritoutiao.dynamicandgreedyalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述:
 *给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 例如，给定三角形：
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * @Author: xiang_song
 * @CreateDate: 2019/1/17 17:09
 */
public class Triangle {
    private static int min = Integer.MAX_VALUE;
    private static int sum;
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==1){
            return triangle.get(0).get(0);
        }
        sum=triangle.get(0).get(0);
        fun(triangle,1,0);
        return min;
    }
    public void fun(List<List<Integer>> triangle,int row,int index){
        List<Integer> list = triangle.get(row);
        for(int i=0;i<2;i++){
            sum += list.get(index+i);
            if(row==triangle.size()-1){
                min = Math.min(sum, min);
            }else {
                fun(triangle,row+1,index+i);
            }
            sum -= list.get(index+i);
        }
    }
    public int minimumTotal1(List<List<Integer>> triangle) {
        /**
         自底向上动态规划, dp[i]表示到第i行时的最小路径和, 先从底层
         开始判断, 每向上一层后该层的数据无需再使用可以直接覆盖, 所以
         可以把空间复杂度优化到O(N), 但是要注意覆盖时的顺序
         **/
        int n = triangle.size();
        if(n < 1) return 0;
        int[] dp = new int[n+1];

        for(int i = n-1; i >= 0; --i) {
            int size = triangle.get(i).size();
            for(int j = 0; j < size; ++j)
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(new Integer[]{-1})));
        triangle.add(new ArrayList<>(Arrays.asList(new Integer[]{2,3})));
        triangle.add(new ArrayList<>(Arrays.asList(new Integer[]{1,-1,-3})));
//        triangle.add(new ArrayList<>(Arrays.asList(new Integer[]{4,1,8,3})));
        System.out.println(new Triangle().minimumTotal(triangle));
        System.out.println(new Triangle().minimumTotal1(triangle));

    }
}

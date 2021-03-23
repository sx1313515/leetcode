package realinterviewquestions.jinritoutiao.dynamicandgreedyalgorithm;

/**
 * 描述:
 *在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 输入:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 输出: 4
 *
 * 思路
 * dp[i][j]表示以第i行第j列为右下角所能构成的最大正方形边长,
 * 如果dp[i][j]是0，则dp[i][j]等于0
 * 否则， 则递推式为:dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]);
 * @Author: xiang_song
 * @CreateDate: 2019/1/17 14:15
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int length_row = matrix.length;
        if(length_row==0)
            return 0;
        int leng_column = matrix[0].length;
        int[][] value = new int[length_row][leng_column];
        int max = 0;
        for (int i = 0; i < length_row; i++) {
            if(matrix[i][0]=='1'){
                value[i][0] = 1;
                max = 1;
            }
        }
        for (int i = 0; i < leng_column; i++) {
            if(matrix[0][i]=='1'){
                value[0][i] = 1;
                max = 1;
            }
        }
        if(leng_column<=1||length_row<=1)
            return max;
        for (int i = 1; i < length_row; i++) {
            for (int j = 1; j < leng_column; j++) {
                if (matrix[i][j]=='1'){
                    value[i][j] = 1 + Math.min(Math.min(value[i - 1][j - 1], value[i][j - 1]), value[i - 1][j]);
                    max = Math.max(max, value[i][j]);
                }
            }
        }
        return max*max;
    }

    public static void main(String[] args) {
        char[][] value = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(new MaximalSquare().maximalSquare(value));;
    }
}

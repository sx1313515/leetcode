package realinterviewquestions.jianzhioffer;

/**
 * 描述:搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * @Author: xiang_song
 * @CreateDate: 2021/3/29 9:19
 */
public class Q240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int column = 0;
        while (row >= 0 && column < matrix[0].length) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] < target) {
                column++;
            } else {
                row--;
            }
        }
        return false;
    }
}

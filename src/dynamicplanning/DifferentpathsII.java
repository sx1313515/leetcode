package dynamicplanning;

/**
 * 描述:
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * @Author: g
 * @CreateDate: 2018/12/28 14:38
 */
public class DifferentpathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int index = 1;
        if (row < 1)
            return 0;
        int column = obstacleGrid[0].length;
        if (row == 1) {
            for (int i = 0; i < column; i++) {
                if (obstacleGrid[0][i] == 1)
                    return 0;
            }
            return 1;
        }
        if (column == 1) {
            for (int i = 0; i < row; i++) {
                if (obstacleGrid[i][0] == 1)
                    return 0;
            }
            return 1;
        }
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < row; i++) {
            if (obstacleGrid[i][0] == 1)
                obstacleGrid[i][0] = 0;
            else {
                obstacleGrid[i][0] = obstacleGrid[i - 1][0];
            }
        }
        for (int i = 1; i < column; i++) {
            if (obstacleGrid[0][i] == 1)
                obstacleGrid[0][i] = 0;
            else {
                obstacleGrid[0][i] = obstacleGrid[0][i - 1];
            }
        }
        while (index < row || index < column) {
            if (index >= row) {
                for (int i = index; i < column; i++) {
                    if (obstacleGrid[row - 1][i] == 1) {
                        obstacleGrid[row - 1][i] = 0;
                    } else {
                        obstacleGrid[row - 1][i] = obstacleGrid[row - 2][i] + obstacleGrid[row - 1][i - 1];
                    }
                }
                break;
            } else if (index >= column) {
                for (int i = index; i < row; i++) {
                    if (obstacleGrid[i][column - 1] == 1) {
                        obstacleGrid[i][column - 1] = 0;
                    } else {
                        obstacleGrid[i][column - 1] = obstacleGrid[i][column - 2] + obstacleGrid[i - 1][column - 1];
                    }
                }
                break;
            } else {
                for (int i = index; i < row; i++) {
                    if (obstacleGrid[i][index] == 1) {
                        obstacleGrid[i][index] = 0;
                    } else {
                        obstacleGrid[i][index] = obstacleGrid[i][index - 1] + obstacleGrid[i - 1][index];
                    }
                }
                for (int i = index + 1; i < column; i++) {
                    if (obstacleGrid[index][i] == 1) {
                        obstacleGrid[index][i] = 0;
                    } else {
                        obstacleGrid[index][i] = obstacleGrid[index - 1][i] + obstacleGrid[index][i - 1];
                    }
                }
                index++;
            }
        }
        return obstacleGrid[row - 1][column - 1];
    }

    public static void main(String[] args) {
        int[][] value = new int[][]{{0,0},
                {0,0},
                {0,0},
                {0,0},
                {0,0},
                {0,0},
                {1,0},
                {0,0},
                {0,0},
                {0,0},
                {0,0},
                {0,0},
                {1,0},
                {0,0},
                {0,0},
                {0,0},
                {0,0},
                {0,1},
                {0,0},
                {0,0},
                {1,0},
                {0,0},
                {0,0},
                {0,1},
                {0,0},
                {0,0},
                {0,0},
                {0,0},
                {0,0},
                {0,0},
                {0,0},
                {0,1},
                {0,0},
                {0,0},
                {0,0},
                {0,0},
                {1,0},
                {0,0},
                {0,0},
                {0,0},
                {0,0}};
    }
}
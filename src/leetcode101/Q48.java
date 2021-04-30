package leetcode101;

/**
 * 描述:90度旋转数组
 *
 * @Author: xiang_song
 * @CreateDate: 2021/3/25 8:35
 */
public class Q48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n/2; i++) { //每次旋转最外层的圈，一共有n/2券
            for (int j = i; j <n-1-i; j++) {  //只需遍历最上面的行，因为下面的代码会替换4个方向（i，j）->(j,n-1-i)，所以j<n-1-j
                int l_u = matrix[i][j];
                int r_u = matrix[j][n - 1 - i];
                int r_d = matrix[n - 1 - i][n - 1 - j];
                int l_d = matrix[n - 1 - j][i];
                matrix[j][n - 1 - i] = l_u;
                matrix[n - 1 - i][n - 1 - j] = r_u;
                matrix[n - 1 - j][i] = r_d;
                matrix[i][j] = l_d;
            }
        }
    }
}

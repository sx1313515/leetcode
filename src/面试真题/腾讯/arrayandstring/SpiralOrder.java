package 面试真题.腾讯.arrayandstring;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * @Author: xiang_song
 * @CreateDate: 2019/2/12 17:21
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length ==0){
            return res;
        }
        int numi = matrix.length;
        int numj = matrix[0].length;
        //环数
        int loop = numi>numj?(numj+1)/2:(numi+1)/2;  //环数为行列最小值的一半

        for(int i=0;i<loop;i++,numi-=2,numj-=2){  //编译一圈之后，剩余的行数和列数都会减二

            for(int col = i;col<i+numj;col++){
                res.add(matrix[i][col]);
            }
            for(int row = i+1;row<i+numi;row++){
                res.add(matrix[row][i+numj-1]);
            }
            //最后一环为一行或一列，则在上面两步之后已经全部输出，直接退出即可
            if(numi ==1||numj==1)
                break;

            for(int col = i+numj-2;col>=i;col--){
                res.add(matrix[i+numi-1][col]);
            }
            for(int row = i+numi -2;row>i;row--){
                res.add(matrix[row][i]);
            }
        }
        return res;
    }
    /*
    给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
     */
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int loop = (n+1)/2;
        int rowcol = n;
        int index = 1;
        for(int i=0;i<loop;i++,rowcol-=2){  //遍历一圈之后，剩余的行数和列数都会减二
            for(int col = i;col<i+rowcol;col++){
                result[i][col] = index;
                index++;
            }
            for(int row = i+1;row<i+rowcol;row++){
                result[row][i+rowcol-1] = index;
                index++;
            }
            //最后一环为一行或一列，则在上面两步之后已经全部输出，直接退出即可
            if(rowcol ==1)
                break;
            for(int col = i+rowcol-2;col>=i;col--){
                result[i+rowcol-1][col] = index;
                index++;
            }
            for(int row = i+rowcol -2;row>i;row--){
                result[row][i] = index;
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        new SpiralOrder().spiralOrder(new int[][]{
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12}
//        });
        new SpiralOrder().generateMatrix(3);
    }
}

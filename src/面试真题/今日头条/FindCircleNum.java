package 面试真题.今日头条;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 描述:
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。
 * 如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。
 * 所谓的朋友圈，是指所有朋友的集合。
 *
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，
 * 表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你
 * 必须输出所有学生中的已知的朋友圈总数。
 * @Author: g
 * @CreateDate: 2019/1/10 13:58
 */
public class FindCircleNum {
    //方法一
    public int findCircleNum(int[][] M) {
        int count = M.length;
        int[] help = new int[M.length];
        for(int i = 0;i < help.length;i++)
            help[i] = i;
        for(int i = 0;i < M.length;i++){
            for(int j = i + 1;j < M.length;j++){
                if(M[i][j] == 1){
                    int i_parent = findParent(help,i);
                    int j_parent = findParent(help,j);
                    if(i_parent != j_parent){
                        help[j_parent] = i_parent;
                        count--;
                    }
                }
            }
        }
        return count;
    }
    public int findParent(int[] help,int id){
        if(help[id] == id)
            return id;
        return findParent(help,help[id]);
    }

    //方法二
    public int findCircleNum2(int[][] M) {
        /**
         使用一个visited数组, 依次判断每个节点, 如果其未访问, 朋友圈数加1并对该节点进行dfs搜索标记所有访问到的节点
         **/
        boolean[] visited = new boolean[M.length];
        int ret = 0;
        for(int i = 0; i < M.length; ++i) {
            if(!visited[i]) {
                dfs(M, visited, i);
                ret++;
            }
        }
        return ret;
    }

    private void dfs(int[][] m, boolean[] visited, int i) {
        for(int j = 0; j < m.length; ++j) {
            if(m[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(m, visited, j);
            }
        }
    }





    public static void main(String[] args) {
        int[][] value = {{1,1,0},{1,1,0},{0,0,1}};
        int result = new FindCircleNum().findCircleNum(value);
        System.out.println(result);
    }

}

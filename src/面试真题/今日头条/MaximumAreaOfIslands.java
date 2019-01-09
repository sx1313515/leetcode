package 面试真题.今日头条;

import java.math.BigInteger;

/*
 * 给定一个二维数组，只含有0和1两个字符。其中1代表陆地，
 * 0代表水域。横向和纵向的陆地连接成岛屿，被水域分隔开。
 *问给出的地图中最大的岛屿面积是多少
 */
public class MaximumAreaOfIslands {
	static boolean[][] visited;
	static int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
	public static boolean inArea(int x, int y) {
		// TODO Auto-generated method stub
		int n = visited.length;
		int m = visited[0].length;
		return x>=0&&x<n&&y>=0&&y<m;
	}
	public static int fun(int[][] board)
	{
		int n = board.length;
		int m = board[0].length;
		visited = new boolean[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				visited[i][j] = false;
		int max = 0;
		SongInt result = new SongInt();
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++){
				if(!visited[i][j]&&board[i][j]==1)
				{
					dfs(board,i,j,result);
					max = Math.max(max,result.getValue());
					result.clear();
				}
			}
		return max;
	}
	public static void dfs(int[][] board, int x, int y,SongInt result) {
		// TODO Auto-generated method stub
		visited[x][y] = true;
		result.addOne();
		for(int i=0;i<4;i++)
		{
			int newX = x+d[i][0];
			int newY = y+d[i][1];
			if(inArea(newX,newY)&&!visited[newX][newY]&&board[newX][newY]==1)
				dfs(board, newX, newY,result);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int[][] g1 = {
	            {1,1,1,1,0},
	            {1,1,0,1,0},
	            {1,1,0,0,0},
	            {0,0,0,0,0}};
	    int[][] g2 = {
	            {1,1,1,0,0},
	            {1,1,0,1,0},
	            {1,1,0,0,1},
	            {0,0,1,0,1}};
	    System.out.println(fun(g1));
	    System.out.println(fun(g2));
	}

}
class SongInt{
    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public void addOne(){
        this.value++;
    }
    public void clear(){
        value = 0;
    }
}

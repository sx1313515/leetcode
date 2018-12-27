package 玩转算法.RecurionAndBackstracking;
/*
 * 给定一个二维平面的字母和一个单词，看是否可在
 * 这个二维平面找到这个单词。找到这个单词的规则是
 * 从一个字母出发，可以横向或者纵向连接二维
 * 平面的其他字母。同一个位置的字母只能使用一次
 */
public class WordSearch {
	static boolean[][] visited;
	static int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
	public static boolean isexist(char[][] board,char[] word)
	{
		int n = board.length;
		int m = board[0].length;
		visited = new boolean[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				visited[i][j] = false;
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
			{
				if(searchWord(board,word,i,j,0))
					return true;
			}
		return false;
		
	}

	public static boolean searchWord(char[][] board, char[] word, int startX, int startY, int index) {
		// TODO Auto-generated method stub
		if(index==word.length-1)
			return board[startX][startY]==word[index];
		if(word[index]==board[startX][startY])
		{
			visited[startX][startY] = true;
			for(int i=0;i<4;i++)
			{
				int newX = startX + d[i][0];
				int newY = startY + d[i][1];
				//判断是否出界
				if(inArea(newX,newY)&&!visited[newX][newY]&&searchWord(board,word,newX,newY,index+1));
					return true;
			}
			visited[startX][startY] = false;
		}
		return false;
	}

	public static boolean inArea(int x, int y) {
		// TODO Auto-generated method stub
		int n = visited.length;
		int m = visited[0].length;
		return x>=0&&x<n&&y>=0&&y<m;
	}
	public static void main(String[] args) {
		char[][] b = {{'A','B','C','E'},
					  {'S','F','C','S'},
					  {'A','D','E','E'}};
		char[] c = {'A','B','C','C','E','D'};
		System.out.println(isexist(b,c));
	}
}

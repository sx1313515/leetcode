package realinterviewquestions.meituan;
/*
有一个二维数组(n*n),写程序实现从右上角到左下角沿主对角线方向打印。
给定一个二位数组arr及题目中的参数n，请返回结果数组。
测试样例：
[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]],4
返回：[4,3,8,2,7,12,1,6,11,16,5,10,15,9,14,13]
 */
public class PrintTwoDimensionArray {
	public static void main(String[] args) {
		 int[][] a = {{1,2,3,4},  
                 {5,6,7,8},  
                 {9,10,11,12},  
                 {13,14,15,16}}; 
	        int size = a.length;  
	        int len = 2*a.length-1;//一共生成几行结果  
	        for(int k=0;k<len;k++){  
	            //规律是第 K的 列号-行号=size-1-k  
	            for(int i=0;i<size;i++){  
	                for(int j=0;j<size;j++){  
	                    if(j-i == size-1-k){  
	                        System.out.print(a[i][j]+" ");  
	                    }  
	                }  
	            }  
	        } 
	}
}
/*
 *     public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int[] res = new int[n*n];
        int index = 0;
        int startX = 0;
        int startY = n-1;
        while(startX<n){
            int x = startX;
            int y = startY;
            while(x<n&&y<n)
                res[index++]=arr[x++][y++];
            if(startY>0)
                startY--;
            else
                startX++;
        }
        return res;
    }
 */

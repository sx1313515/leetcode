package realinterviewquestions.xiechen;

public class MinNum {
    public static int findMinMis(int[] A) {
    	int size = A.length;
    	int res = Integer.MAX_VALUE;
    	for(int i=0;i<size;i++)
    		if(A[i]>=1)
    			res = Math.min(res, A[i]);
    	if(res==Integer.MAX_VALUE)
    		return 1;
    	else if(res==1)
    		return 2;
    	else  
    		return res-1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}

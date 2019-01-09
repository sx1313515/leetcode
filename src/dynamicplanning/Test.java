package dynamicplanning;

import java.util.Arrays;

public class Test {
    //一趟划分
    public static int Partition(int[] a,int low,int high)
    {
        int pivotkey = a[low];
        while(low<high)
        {
            while(low<high&&a[high]>=pivotkey)
                high--;
            a[low] = a[high];
            while(low<high&&a[low]<=pivotkey)
                low++;
            a[high] = a[low];
        }
        a[low] = pivotkey;
        return low;
    }
    public static int findKthLargest(int[] nums, int k) {
        return Search(nums,0,nums.length-1,k);
    }
    public static int Search(int a[], int i, int j, int k) {
        int m = Partition(a, i, j);
        if (k==j-m+1) {
            return a[m];
        }
        else if (k<j-m+1) {
            return Search(a,m+1,j,k );
        }else {
            return Search(a,i,m-1, k-j+m-1);
        }
    }

    public static void main(String[] args) {
        int[] a = {99,99};
        int k = 1;
        System.out.println(findKthLargest(a,k));
    }
}


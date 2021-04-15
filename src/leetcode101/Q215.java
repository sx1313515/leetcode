package leetcode101;

/**
 * 描述:数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * @Author: xiang_song
 * @CreateDate: 2021/4/11 5:11 下午
 */
public class Q215 {
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
}

package realinterviewquestions.jinritoutiao;

/**
 * 描述:
 *假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 思路：二分法将数组分为两部分，其中一部分一定是有序的，对于有序的这部门如果数位于最大和最小之间，则一定在这部门
 * 否则在另外一部门，以此类推。
 * @Author: xiang_song
 * @CreateDate: 2019/1/8 18:46
 */
public class SearchRotationSortArray {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(target==nums[mid]) {
                return mid;
            }else if(nums[mid]<nums[end]&&target<=nums[end]&&target>nums[mid]){
                start = mid+1;
            }else if(nums[mid]<nums[end]){
                end = mid-1;
            }else if(nums[mid]>nums[end]&&target<nums[mid]&&target>=nums[start]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(new SearchRotationSortArray().search(nums,target));
    }
}

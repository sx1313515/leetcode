package realinterviewquestions.jianzhioffer;

import java.util.HashSet;

/**
 * 描述:扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 10 J Q K A 不是顺子
 * @Author: xiang_song
 * @CreateDate: 2021/4/10 9:24 下午
 */
public class Q61 {
    public boolean isStraight(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = -1;
        int min = 20;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;  //遇到0就跳过
            }
            if (set.contains(nums[i])) {
                return false;  //出现重复的不可能是顺子
            }
            set.add(nums[i]);
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        return max - min < 5;  //满足这个条件才有顺子
    }
}

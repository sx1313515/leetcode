package realinterviewquestions.jianzhioffer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 描述:在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 * @Author: xiang_song
 * @CreateDate: 2021/4/11 8:39 上午
 */
public class Q56 {
    public int singleNumber(int[] nums) {
        int length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], 2);
            } else {
                map.put(nums[i], 1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if (next.getValue() == 1) {
                return next.getKey();
            }
        }
        return 0;
    }
}

package leetcode.string;

import java.util.*;

/**
 * 描述:字母异或词分组
 *
 * @Author: xiang_song
 * @CreateDate: 2021/4/30 14:32
 */
public class Q49 {
    /**
     * 先对字符串排序，不同排列的字符串排完序后肯定一致
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> result = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String str = String.valueOf(chars);
            if (result.get(str) == null) {
                ArrayList<String> set = new ArrayList<>();
                set.add(strs[i]);
                result.put(str, set);
            } else {
                result.get(str).add(strs[i]);
            }
        }
        List<List<String>> resultValue = new ArrayList<>();
        Iterator<ArrayList<String>> iterator = result.values().iterator();
        while (iterator.hasNext()) {
            resultValue.add(iterator.next());
        }
        return resultValue;
    }
}

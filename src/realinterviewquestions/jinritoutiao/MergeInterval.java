package realinterviewquestions.jinritoutiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 描述:
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * @Author: g
 * @CreateDate: 2019/1/10 17:23
 */
public class MergeInterval {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals.size()==0)
            return result;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start != o2.start){
                    return o1.start-o2.start;
                }else {
                    return o1.end - o2.end;
                }
            }
        });
        for(int i=0;i<intervals.size()-1;i++){
            Interval pre = intervals.get(i);
            Interval post = intervals.get(i + 1);
            if(post.start<=pre.end) {
                post.start = Math.min(pre.start, post.start);
                post.end = Math.max(pre.end, post.end);
            }else {
                result.add(pre);
            }
        }
        result.add(intervals.get(intervals.size() - 1));
        return result;
    }

    public static void main(String[] args) {
        List<Interval> result = new ArrayList<>();
        result.add(new Interval(3,8));
        result.add(new Interval(3,7));
        result.add(new Interval(2,3));
        new MergeInterval().merge(result);
    }
}
class Interval{
    public int start;
    public int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}


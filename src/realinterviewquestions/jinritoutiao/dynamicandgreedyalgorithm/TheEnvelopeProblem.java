package realinterviewquestions.jinritoutiao.dynamicandgreedyalgorithm;

import java.util.*;

/**
 * 描述:
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * 思路：
 * 先给信封的宽排序，然后高按最长递增子序列的方法去取就得出了最后的结果
 * @Author: xiang_song
 * @CreateDate: 2019/1/18 10:34
 */
public class TheEnvelopeProblem {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length==1)
            return 1;
        if(envelopes.length==0)
            return 0;
        List<Interval> list = new ArrayList<>();
        for(int i=0;i<envelopes.length;i++){
            list.add(new Interval(envelopes[i][0],envelopes[i][1]));
        }
        //排序
        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start != o2.start){
                    return o1.start-o2.start;
                }else {
                    return o1.end - o2.end;
                }
            }
        });
        int[] memo = new int[envelopes.length];
        Arrays.fill(memo,1);
        //求高度的最长递增子序列
        for(int i=1;i<envelopes.length;i++){
            for(int j=0;j<i;j++){
                if(list.get(i).end>list.get(j).end&&list.get(i).start>list.get(j).start){
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
            }
        }
        int res = 0;
        for(int i=0;i<memo.length;i++) {
            res = Math.max(res, memo[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new TheEnvelopeProblem().maxEnvelopes(new int[][]{{2,100},{3,200},{4,300},
                {5,500},{5,400},{5,250},{6,370},{6,360},{7,380}}));;
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

package leetcode;

/**
 * 描述: 供暖器
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 * @Author: xiang_song
 * @CreateDate: 2021/4/18 8:03 上午
 */
public class Q475 {
    public static void main(String[] args) {

    }

    public int findRadius(int[] houses, int[] heaters) { //找出每个房间最近的供暖期，最后取最大的
        int totalMax = -1;
        for (int i = 0; i < houses.length; i++) {
            int min = Integer.MAX_VALUE;
            int house = houses[i];
            for (int j = 0; j < heaters.length; j++) {
                min = Math.min(min, Math.abs(heaters[j] - house));
            }
            totalMax = Math.max(totalMax, min);
        }
        return totalMax;
    }
}

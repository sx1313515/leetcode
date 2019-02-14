package brainteaser;

/**
 * 描述:
 *你和你的朋友，两个人一起玩 Nim游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
 *
 * 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
 *
 * 解析:
 * 面对4的整数倍的人永远无法翻身，你拿N根对手就会拿4-N根，
 * 保证每回合共减4根，你永远对面4倍数，直到4. 相反，如果
 * 最开始不是4倍数，你可以拿掉刚好剩下4倍数根，让他永远对面4倍数。
 * @Author: xiang_song
 * @CreateDate: 2019/1/3 15:03
 */
public class NimGame {
    public boolean canWinNim(int n) {
        return n%4!=0;
    }
}

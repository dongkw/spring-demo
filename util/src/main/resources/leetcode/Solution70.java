package xyz.jecy.util.leetcode;

/**
 * 70. 爬楼梯 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2 输出： 2 解释： 有两种方法可以爬到楼顶。 1.  1 阶 + 1 阶 2.  2 阶 示例 2：
 *
 * 输入： 3 输出： 3 解释： 有三种方法可以爬到楼顶。 1.  1 阶 + 1 阶 + 1 阶 2.  1 阶 + 2 阶 3.  2 阶 + 1 阶
 */
public class Solution70 {


  public int climbStairs(int num) {

    int[] dp = new int[num];

    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= num; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[num];

  }

  public static void main(String[] args) {
    Solution70 solution = new Solution70();
    int ss = solution.climbStairs(3);
    System.out.println(ss);

  }
}
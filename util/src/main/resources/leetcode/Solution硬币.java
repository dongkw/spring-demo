package xyz.jecy.util.leetcode;

/**
 * 面试题 08.11. 硬币 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *
 * 示例1:
 *
 * 输入: n = 5 输出：2 解释: 有两种方式可以凑成总金额: 5=5 5=1+1+1+1+1 示例2:
 *
 * 输入: n = 10 输出：4 解释: 有四种方式可以凑成总金额: 10=10 10=5+5 10=5+1+1+1+1+1 10=1+1+1+1+1+1+1+1+1+1 说明：
 *
 * 注意:
 *
 * 你可以假设：
 *
 * 0 <= n (总金额) <= 1000000
 */
public class Solution硬币 {


  public int waysToChange(int n) {

    int[] dp = new int[n + 1];
    dp[0] = 1;
    int[] coins = {25, 10, 5, 1};
    for (int i = 0; i < coins.length; i++) {
      int coin = coins[i];
      for (int j = coin; j <= n; j++) {
        dp[j] = (dp[j] + dp[j - coin]) % 1000000007;
      }
    }
    return dp[n];

  }

  public static void main(String[] args) {
    Solution硬币 solution = new Solution硬币();
    int ss = solution.waysToChange(61);
    System.out.println(ss);

  }
}

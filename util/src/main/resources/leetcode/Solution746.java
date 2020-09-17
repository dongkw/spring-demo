package xyz.jecy.util.leetcode;

/**
 * 746. 使用最小花费爬楼梯 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 示例 1:
 *
 * 输入: cost = [10, 15, 20] 输出: 15 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。 示例 2:
 *
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1] 输出: 6 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 * 注意：
 *
 * cost 的长度将会在 [2, 1000]。 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
 */
public class Solution746 {


  public int minCostClimbingStairs(int[] num) {

//    int[] dp = new int[num.length + 1];
//
//    dp[0] = 0;
//    dp[1] = num[0];

    int dp0 = 0;
    int dp1 = num[0];
//    for (int i = 2; i <= num.length; i++) {

    for (int i = 1; i < num.length; i++) {

      int temp = dp1;
      dp1 = Math.min(dp0, dp1) + num[i];
      dp0 = temp;

//      dp[i] = Math.min(dp[i - 2], dp[i - 1]) + num[i - 1];

    }
//     return Math.min (dp[num.length-1],dp[num.length]);

    return Math.min(dp0, dp1);

  }

  public static void main(String[] args) {
    Solution746 solution = new Solution746();
    int[] i = {0, 0, 1, 1};
    int ss = solution.minCostClimbingStairs(i);
    System.out.println(ss);

  }
}

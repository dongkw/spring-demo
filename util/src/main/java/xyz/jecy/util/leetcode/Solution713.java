package xyz.jecy.util.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 713. 乘积小于K的子数组 给定一个正整数数组 nums。
 *
 * 找出该数组内乘积小于 k 的连续的子数组的个数。
 *
 * 示例 1:
 *
 * 输入: nums = [10,5,2,6], k = 100 输出: 8 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2],
 * [2,6], [5,2,6]。 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。 说明:
 *
 * 0 < nums.length <= 50000 0 < nums[i] < 1000 0 <= k < 10^6
 */
public class Solution713 {


  public int numSubarrayProductLessThanK(int[] nums, int k) {
    if (k <= 1) {
      return 0;
    }
    int now = 1, times = 0, left = 0;
    for (int right = 0; right < nums.length; right++) {
      now *= nums[right];
      while (now >= k) {
        now /= nums[left++];
      }
      times += right - left + 1;
    }

    return times;
  }







  public static void main(String[] args) {
    Solution713 solution = new Solution713();
    int[] i = {1, 1, 1, 1, 1, 1, 1};
    int ss = solution.numSubarrayProductLessThanK(i, 5);
    System.out.println(ss);

  }
}

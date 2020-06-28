package xyz.jecy.util.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 16. 最接近的三数之和 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target
 * 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class Solution16 {


  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);

    int t = Integer.MAX_VALUE;
    int r = 0;
    for (int i = 0; i < nums.length; i++) {
      int j = i + 1;
      int k = nums.length - 1;

      while (j < k) {
        if (t > Math.abs(nums[i] + nums[j] + nums[k] - target)) {
          t = Math.abs(nums[i] + nums[j] + nums[k] - target);
          r = nums[i] + nums[j] + nums[k];
        }
        if (nums[i] + nums[j] + nums[k] < target) {
          j++;
        } else if (nums[i] + nums[j] + nums[k] > target) {
          k--;
        } else {
          return target;
        }


      }

    }

    return r;
  }


  public static void main(String[] args) {
    Solution16 solution = new Solution16();
    int[] i = new int[]{-1, 2, 1, -4};
    int ss = solution.threeSumClosest(i, 1);
    System.out.println(ss);

  }
}

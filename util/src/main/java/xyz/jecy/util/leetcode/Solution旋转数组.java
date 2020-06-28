package xyz.jecy.util.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3 输出: [5,6,7,1,2,3,4] 解释: 向右旋转 1 步: [7,1,2,3,4,5,6] 向右旋转 2 步:
 * [6,7,1,2,3,4,5] 向右旋转 3 步: [5,6,7,1,2,3,4] 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2 输出: [3,99,-1,-100] 解释: 向右旋转 1 步: [99,-1,-100,3] 向右旋转 2 步:
 * [3,99,-1,-100] 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class Solution旋转数组 {

  public void rotate(int[] nums, int k) {
    int x = 0;
    for (int i = 0; x < nums.length; i++) {
      int current = i;
      int temp = nums[i];
      do {
        int index = (i + k) % nums.length;
        int t = nums[index];
        nums[index] = temp;
        temp = t;
        i = index;
        x++;
      }
      while (current != i);
    }
    Arrays.stream(nums).forEach(t -> System.out.print(t + ","));
  }
  public void rotate1(int[] nums, int k) {
    k=k%nums.length;
    reversal(nums,0,nums.length-1);
    reversal(nums,0,k-1);
    reversal(nums,k,nums.length-1);


  }

  public void reversal(int[] nums,int start,int end){

    while(start<end){
      int temp=nums[start];
      nums[start]=nums[end];
      nums[end]=temp;
      start++;
      end--;
    }
  }

  public static void main(String[] args) {
    Solution旋转数组 solution = new Solution旋转数组();
    int[] nums = {1, 2, 3, 4, 5, 6};
    solution.rotate(nums, 3);

  }

}

package xyz.jecy.util.leetcode;

/**
 * 153. 寻找旋转排序数组中的最小值 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2] 输出: 1 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2] 输出: 0
 */
public class Solution153 {


  public int findMin(int[] nums) {

    int min = 0;
    int max = nums.length - 1;
    while (min < max) {
      int half = (max - min) / 2 + min;
      if (nums[min] <= nums[max]) {
        return nums[min];
      } else {
        if (nums[half] < nums[max]) {
          max = half;
        }
        if (nums[min] < nums[half]) {
          min = half;
        }
        if (max - min == 1) {
          return nums[max];
        }
      }
    }
    return nums[min];
  }


  public static void main(String[] args) {
    Solution153 solution = new Solution153();
    int[] i = new int[]{3, 4, 5, 1, 2};
    int ss = solution.findMin(i);
    System.out.println(ss);

  }
}

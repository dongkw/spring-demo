package xyz.jecy.util.leetcode;


/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/5/25 4:17 下午
 */
public class Solution2 {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int s1 = 0;
    int e1 = nums1.length - 1;
    int s2 = 0;
    int e2 = nums2.length - 1;

    int n1 = nums1.length;
    int n2 = nums2.length;
    // 处理奇数偶数
    int k = (n1 + n2) / 2 + 1;
    int k2 = (n1 + n2 + 1) / 2;
    return (getMin(nums1, nums2, k2, s1, e1, s2, e2) + getMin(nums1, nums2, k, s1, e1, s2, e2))
        / 2.0;
  }

  private double getMin(int[] nums1, int[] nums2, int k, int s1, int e1, int s2, int e2) {

    int length1 = e1 - s1 + 1; //长度 nums1
    int length2 = e2 - s2 + 1; //长度 nums2

    if (length1 > length2) {
      return getMin(nums2, nums1, k, s2, e2, s1, e1);
    }
    if (length1 == 0) {
      return nums2[s2 + k - 1];
    }
    if (k == 1) {
      return Math.min(nums1[s1], nums2[s2]);
    }
    int i = s1 + Math.min(length1, k / 2) - 1;  //怎么找起点
    int j = s2 + Math.min(length2, k / 2) - 1;

    // 下一个k是什么
    if (nums1[i] > nums2[j]) {
      return getMin(nums1, nums2, k - (j - s2 + 1), s1, e1, j + 1, e2);
    } else {
      return getMin(nums1, nums2, k - (i - s1 + 1), i + 1, e1, s2, e2);

    }

  }


  public static void main(String[] args) {
    int[] nums1 = {3};
    int[] nums2 = {-2, -1};

    Solution2 solution = new Solution2();
    System.out.println(solution.findMedianSortedArrays(nums1, nums2));
  }
}

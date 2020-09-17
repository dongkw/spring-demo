package xyz.jecy.util.leetcode;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * 接雨水 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1] 输出: 6
 */
public class Solution42 {


  public int trap(int[] height) {

    int right = 0;
    int left = height.length - 1;
    int sum = 0;
    int maxh = 0;
    while (right < left) {
      int h = Math.min(height[right], height[left]);
      int w = left - right;
      if (maxh < h) {
        sum = sum + (h - maxh) * w;
      }
      maxh = Math.max(maxh, h);
      if (height[right] > height[left]) {
        left--;
      } else {
        right++;
      }
      sum = sum - h;

    }
    return sum;

  }


  public static void main(String[] args) {
    Solution42 solution = new Solution42();
    int[] i = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int ss = solution.trap(i);
    System.out.println(ss);

  }
}

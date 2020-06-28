package xyz.jecy.util.leetcode;

/**
 * 1139. 最大的以 1 为边界的正方形 给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回
 * 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]] 输出：9 示例 2：
 *
 * 输入：grid = [[1,1,0,0]] 输出：1
 */
public class Solution1139 {


  public int largest1BorderedSquare(int[][] grid) {

    int y = grid[0].length;
    int x = grid.length;
    int[][] dpleft = new int[grid.length + 1][grid[0].length + 1];
    int[][] dptop = new int[grid.length + 1][grid[0].length + 1];

    int sum = 0;
    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        if (grid[i][j] == 0) {
          dpleft[i][j] = 0;
          dptop[i][j] = 0;
        } else {
          sum = Math.max(sum, 1);
          int left = j > 0 ? dpleft[i][j - 1] : 0;
          int top = i > 0 ? dptop[i - 1][j] : 0;

          dpleft[i][j] = left + grid[i][j];
          dptop[i][j] = top + grid[i][j];
        }
        int h = Math.min(dpleft[i][j], dptop[i][j]);
        while (h > 1) {
          if (dptop[i][j - h + 1] >= h && dpleft[i - h + 1][j] >= h) {
            sum = Math.max(sum, h * h);
            break;
          } else {
            h--;
          }
        }
      }

    }

    return sum;

  }


  public static void main(String[] args) {
    Solution1139 solution = new Solution1139();
    int[][] i = {{0, 1}, {1, 1}};
    int ss = solution.largest1BorderedSquare(i);
    System.out.println(ss);

  }
}

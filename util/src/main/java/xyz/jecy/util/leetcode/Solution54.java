package xyz.jecy.util.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题29. 顺时针打印矩阵 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]] 输出：[1,2,3,6,9,8,7,4,5] 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]] 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100 0 <= matrix[i].length <= 100
 */
public class Solution54 {


  public int[] spiralOrder(int[][] matrix) {

    int[] result = new int[matrix.length * matrix[0].length];
    int s1 = 0;
    int s2 = 0;
    int e1 = matrix[0].length - 1;
    int e2 = matrix.length - 1;
    int x = 0;
    while (s1 <= e1 && s2 <= e2) {
      for (int i = s1; i <= e1; i++) {
        result[x++] = matrix[s2][i];
      }
      if (x==matrix.length * matrix[0].length){
        break;
      }
      s2++;
      for (int i = s2; i <= e2; i++) {
        result[x++] = matrix[i][e1];
      }
      if (x==matrix.length * matrix[0].length){
        break;
      }
      e1--;
      for (int i = e1; i >= s1; i--) {
        result[x++] = matrix[e2][i];
      }
      if (x==matrix.length * matrix[0].length){
        break;
      }
      e2--;
      for (int i = e2; i >= s2; i--) {
        result[x++] = matrix[i][s1];
      }
      if (x==matrix.length * matrix[0].length){
        break;
      }
      s1++;
    }

    return result;

  }


  public static void main(String[] args) {
    Solution54 solution = new Solution54();
    int[][] i = new int[][]{{1, 2, 3,4}, {4, 5, 6,4}, {7, 8, 9,8}};
    int[] ss = solution.spiralOrder(i);
    System.out.println(ss);

  }
}

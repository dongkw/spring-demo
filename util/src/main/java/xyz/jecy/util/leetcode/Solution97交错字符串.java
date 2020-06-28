package xyz.jecy.util.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 97. 交错字符串 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 *
 * 示例 1:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac" 输出: true 示例 2:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc" 输出: false
 */
public class Solution97交错字符串 {


  public boolean isInterleave(String s1, String s2, String s3) {

    int x = 0;
    int y = 0;

    if (s1.length() + s2.length() != s3.length()) {
      return false;
    }

    boolean[][] dp = new boolean[s1.length()][s3.length()];
    for (int i = 0; i <= s1.length(); i++) {
      for (int j = 0; i <= s2.length(); i++) {
        if (i == 0 && j == 0) {
          dp[i][j] = true;
        }
        dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1]
            && s2.charAt(j - 1) == s3.charAt(i + j - 1));

      }

    }

    return false;

  }


  public static void main(String[] args) {
    Solution97交错字符串 solution = new Solution97交错字符串();
    int[] i = {23, 2, 4, 6, 7};
    boolean ss = solution.isInterleave("aabcc", "dbbca", "aadbbcbcac");
    System.out.println(ss);

  }
}

package xyz.jecy.util.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 10. 正则表达式匹配 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符 '*' 匹配零个或多个前面的那一个元素 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。 p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 示例 1:
 *
 * 输入: s = "aa" p = "a" 输出: false 解释: "a" 无法匹配 "aa" 整个字符串。 示例 2:
 *
 * 输入: s = "aa" p = "a*" 输出: true 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为
 * 'a' 重复了一次。 示例 3:
 *
 * 输入: s = "ab" p = ".*" 输出: true 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。 示例 4:
 *
 * 输入: s = "aab" p = "c*a*b" 输出: true 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。 示例
 * 5:
 *
 * 输入: s = "mississippi" p = "mis*is*p*." 输出: false
 */
public class Solution10 {

  /*  j
    i   a c b b v
      a t
      .   t
      b   f
      *   f t t
      v         t
   */

  private boolean compare(char t, char p) {
    return t == p || p == '.';
  }

  private char getNext2(char[] t, int index) {

    if (index <= 2) {
      return '.';
    }
    if (t[index] != '*') {
      return t[index];
    }
    return getNext2(t, index - 2);

  }

  public boolean isMatch1(String text, String pattern) {
    boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
    dp[text.length()][pattern.length()] = true;

    for (int i = text.length(); i >= 0; i--) {
      for (int j = pattern.length() - 1; j >= 0; j--) {
        boolean first_match = (i < text.length() &&
            (pattern.charAt(j) == text.charAt(i) ||
                pattern.charAt(j) == '.'));
        if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
          dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
        } else {
          dp[i][j] = first_match && dp[i + 1][j + 1];
        }
      }
    }
    return dp[0][0];
  }


  public boolean isMatch(String text, String pattern) {

    char[] t = text.toCharArray();
    char[] p = pattern.toCharArray();
    int i = 0;
    int j = 0;
    boolean[][] bp = new boolean[t.length][p.length];
    while (i <= t.length - 1 && j <= p.length - 1) {
      System.out.println(t[i] + "  " + p[j] + " " + i + " " + j);

      if (i == t.length - 1) {
        if (compare(t[i], p[j])) {
          bp[i][j] = true;
          j++;
        } else if (p[j] == '*') {
          if (compare(t[i], p[j - 1])) {
            bp[i][j] = true;
          } else {
             j++;
             continue;
          }
        }else {
          if (bp[i][j-1]){
            i++;
          }else {
            j++;
          }
          continue;
        }

      }
      if (j == p.length - 1) {
        if (compare(t[i], p[j])) {
          bp[i][j] = true;
          i++;
          j++;
        } else if (p[j] == '*') {
          if (compare(t[i], p[j - 1])) {
            bp[i][j] = true;
            i++;
          } else {
            j++;
          }
        }else {
          if (bp[i][j]) {
            i++;
          } else {
            j++;
          }
        }
        continue;
      }
      if (i < t.length - 1 && j < p.length - 1) {
        if (compare(t[i], p[j])) {
          bp[i][j] = true;
          i++;
          j++;
        } else if (p[j] == '*') {
          if (compare(t[i], p[j - 1])) {
            bp[i][j] = true;
            i++;
          } else {
            j++;
          }
        } else {
          j++;
        }
      }
    }

    return bp[t.length - 1][p.length - 1];

  }


  public static void main(String[] args) {
    Solution10 solution3 = new Solution10();
    boolean ss = solution3.isMatch("a",
        "ad*");
    System.out.println(ss);

  }

}

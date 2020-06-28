package xyz.jecy.util.leetcode;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama" 输出: true 示例 2:
 *
 * 输入: "race a car" 输出: false
 */
public class Solution验证回文字符串 {


  public boolean isPalindrome(String s) {
    int l = 0;
    int r = s.length() - 1;
    while (l < r) {
      if (!isValid(s.charAt(l))) {
        l++;
        continue;
      }
      if (!isValid(s.charAt(r))) {
        r--;
        continue;
      }
      if (equal(s.charAt(l), s.charAt(r))) {
        l++;
        r--;
      } else {
        return false;
      }
    }
    return true;
  }

  public boolean equal(char c1, char c2) {
    if (c1 == c2) {
      return true;
    }
    if (c1 >= 'a' && c1 <= 'z' && c2 >= 'A' && c2 <= 'Z') {
      if ((char) (c2 + 32) == c1) {
        return true;
      }
    }
    if (c2 >= 'a' && c2 <= 'z' && c1 >= 'A' && c1 <= 'Z') {
      if ((char) (c1 + 32) == c2) {
        return true;
      }
    }

    return false;
  }

  public boolean isValid(char c) {
    if (c >= '0' && c <= '9') {
      return true;
    }
    if (c >= 'a' && c <= 'z') {
      return true;
    }
    if (c >= 'A' && c <= 'Z') {
      return true;
    }
    return false;
  }


  public static void main(String[] args) {
    Solution验证回文字符串 solution = new Solution验证回文字符串();
    boolean ss = solution.isPalindrome("A man, a plan, a canal: Panama");
    System.out.println(ss);

  }
}

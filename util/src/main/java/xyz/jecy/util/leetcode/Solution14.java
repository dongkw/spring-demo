package xyz.jecy.util.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 14. 最长公共前缀 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"] 输出: "fl" 示例 2:
 *
 * 输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */
public class Solution14 {


  public String longestCommonPrefix1(String[] strs) {

    int len = 0;
    if (strs.length <= 0) {
      return "";
    }
    String str0 = strs[0];
    while (len < str0.length()) {
      char flag = str0.charAt(len);
      for (int i = 0; i < strs.length; i++) {
        str0 = str0.length() <= strs[i].length() ? str0 : strs[i];
        if (str0.length() <= 0) {
          return "";
        }
        if (flag != strs[i].charAt(len)) {
          return str0.substring(0, len);
        }
      }
      len++;
    }

    return str0.substring(0, len);
  }

  public String longestCommonPrefix(String[] strs) {

    return prefix(strs, 0, strs.length - 1);

  }

  public String prefix(String[] strs, int x, int y) {
    if (strs.length <= 0) {
      return "";
    }
    if (strs[x] == "" || strs[y] == "") {
      return "";
    }
    if (x < y) {
      int mid = (y - x) / 2 + x;
      String s1 = prefix(strs, x, mid);
      String s2 = prefix(strs, mid + 1, y);
      return prefix(s1, s2);
    } else {
      return strs[x];
    }
  }


  public String prefix(String s1, String s2) {
    int length = Math.min(s1.length(), s2.length());
    int index = 0;
    while (index < length && s1.charAt(index) == s2.charAt(index)) {
      index++;
    }
    return s1.substring(0, index);

  }

  public static void main(String[] args) {
    Solution14 solution = new Solution14();
    String i[] = {"flower", "fl", "flight"};

    String ss = solution.longestCommonPrefix(i);
    System.out.println(ss);

  }
}

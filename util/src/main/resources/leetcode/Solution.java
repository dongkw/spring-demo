package xyz.jecy.util.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/5/25 4:17 下午
 */
public class Solution {

  public int lengthOfLongestSubstring(String s) {

    int length = 0;
    int left = 0;
    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      left = Math.max(left, map.getOrDefault(c,0));
      length = Math.max(length, i - left + 1);
      map.put(c, i + 1);

    }

    return length;
  }

  public static void main(String[] args) {
    String s = "pwwkew";

    Solution solution = new Solution();
    System.out.println(solution.lengthOfLongestSubstring(s));
  }
}

package xyz.jecy.util.leetcode;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll" 输出: 2 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba" 输出: -1 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class Solution实现strStr {


  public int strStr1(String haystack, String needle) {
    if (needle.length() == 0) {
      return 0;
    }
    if (haystack.length() < needle.length()) {
      return -1;
    }
    int index = 0;
    int[] kpm = getKpm(needle);
    while (index < haystack.length()) {
      int end = 0;
      int start = index;
      while (end <= needle.length()) {
        if (needle.charAt(end) == haystack.charAt(start)) {
          end++;
          start++;
        } else {
          index++;
          break;
        }
        if (end == needle.length()) {
          return index;
        }
        if (start == haystack.length()) {
          return -1;
        }

      }
    }
    haystack.indexOf(needle);
    return -1;
  }

  public int strStr2(String haystack, String needle) {
    int strLen = haystack.length(), subLen = needle.length();
    if (subLen == 0) {
      return 0;
    }
    if (strLen == 0) {
      return -1;
    }
    int[] next = getKpm(needle);
    int i = 0;
    int j = 0;
    while (i < strLen && j < subLen) {
      if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
        i++;
        j++;
      } else {
        j = next[j];
      }
    }
    if (j == subLen) {
      return i - j;
    } else {
      return -1;
    }

  }

  public int strStr(String haystack, String needle) {
    int strLen = haystack.length(), subLen = needle.length();
    if (subLen == 0) {
      return 0;
    }
    if (strLen == 0) {
      return -1;
    }
    return indexOf(haystack.getBytes(), strLen,needle.getBytes(), subLen, 0);
  }

  public int indexOf(byte[] value, int valueCount, byte[] str, int strCount, int fromIndex) {
    byte first = str[0];
    int max = (valueCount - strCount);
    for (int i = fromIndex; i <= max; i++) {
      // Look for first character.
      if (value[i] != first) {
        while (++i <= max && value[i] != first) {
          ;
        }
      }
      // Found first character, now look at the rest of value
      if (i <= max) {
        int j = i + 1;
        int end = j + strCount - 1;
        for (int k = 1; j < end && value[j] == str[k]; j++, k++) {
          ;
        }
        if (j == end) {
          // Found whole string.
          return i;
        }
      }
    }
    return -1;
  }


  private int[] getKpm(String str) {
    int i = 0;
    int k = -1;
    int len = str.length() - 1;
    int[] dp = new int[str.length()];
    dp[0] = -1;
    while (i < len) {
      if (k == -1 || str.charAt(i) == str.charAt(k)) {
        i++;
        k++;
        dp[i] = k;
      } else {
        k = dp[k];
      }
    }
    return dp;
  }


  public static void main(String[] args) {
    Solution实现strStr solution = new Solution实现strStr();
    int[] i = {23, 2, 4, 6, 7};
    int ss = solution.strStr("aabaaabaaac",
        "aabaaac");
//    int aa = solution.getIndex("aaaaa", 0, 1);
    System.out.println(ss);

  }
}

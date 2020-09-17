package xyz.jecy.util.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/5/23 4:43 下午
 */
public class Test1 {


  Map<Character, Integer> it = new HashMap<>();


  private boolean contain(String s, int left, int right, String t) {
    Map<Character, Integer> smap = new HashMap<>();

    if (right - left + 1 < t.length()) {
      return false;
    }
    for (int i = left; i < right + 1; i++) {
      char c = s.charAt(i);
      smap.put(c, smap.getOrDefault(c, 0) + 1);
    }

    for (char c : it.keySet()) {
      if (smap.getOrDefault(c, 0) < it.getOrDefault(c, 0)) {
        return false;
      }
    }
    return true;
  }


  public String minWindow(String s, String t) {
    int left = 0;
    int right = 0;
    String result = "";
    for (char c : t.toCharArray()) {
      it.put(c, it.getOrDefault(c, 0) + 1);
    }
    while (left <= right && right < s.length()) {

      if (contain(s, left, right, t)) {
        if (Objects.equals(result, "") || result.length() > right - left + 1) {
          result = s.substring(left, right + 1);
        }
        left++;
      } else {
        right++;
      }

    }
    return result;
  }
  Map<Character, Integer> ori = new HashMap<Character, Integer>();
  Map<Character, Integer> cnt = new HashMap<Character, Integer>();

  public String minWindow1(String s, String t) {
    int tLen = t.length();
    for (int i = 0; i < tLen; i++) {
      char c = t.charAt(i);
      ori.put(c, ori.getOrDefault(c, 0) + 1);
    }
    int l = 0, r = -1;
    int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
    int sLen = s.length();
    while (r < sLen) {
      ++r;
      if (r < sLen && ori.containsKey(s.charAt(r))) {
        cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
      }
      while (check() && l <= r) {
        if (r - l + 1 < len) {
          len = r - l + 1;
          ansL = l;
          ansR = l + len;
        }
        if (ori.containsKey(s.charAt(l))) {
          cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
        }
        ++l;
      }
    }
    return ansL == -1 ? "" : s.substring(ansL, ansR);
  }

  public boolean check() {
    Iterator iter = ori.entrySet().iterator();
    while (iter.hasNext()) {
      Map.Entry entry = (Map.Entry) iter.next();
      Character key = (Character) entry.getKey();
      Integer val = (Integer) entry.getValue();
      if (cnt.getOrDefault(key, 0) < val) {
        return false;
      }
    }
    return true;
  }



  public static void main(String[] args) {

    String s = "ADOBECODEBANC";
    String t = "ABC";
    Test1 test1 = new Test1();
    String r = test1.minWindow1(s, t);
    System.out.println(r);
  }


}

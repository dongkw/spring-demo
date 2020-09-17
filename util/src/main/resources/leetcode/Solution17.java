package xyz.jecy.util.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 17. 电话号码的字母组合 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 * 示例:
 *
 * 输入："23" 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]. 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class Solution17 {

  Map<Character, String> map = new HashMap<>() {{
    put('2', "abc");
    put('3', "def");
    put('4', "ghi");
    put('5', "jkl");
    put('6', "mno");
    put('7', "pqrs");
    put('8', "tuv");
    put('9', "wxyz");
  }};


  public List<String> letterCombinations(String digits) {

    if (Objects.equals(digits, "")) {
      return List.of();
    }
    List<String> strings = new ArrayList<>();
    strings = toList(List.of(digits), 0);

    for (int i = 1; i < digits.length(); i++) {
      strings = toList(strings, i);
    }

    return strings;
  }

  private List<String> toList(List<String> digitsList, int i) {
    List<String> strings = new ArrayList<>();
    digitsList.forEach(digits -> {
      if (digits.charAt(i) >= '2' && digits.charAt(i) <= '9') {
        for (char c : map.get(digits.charAt(i)).toCharArray()) {
          strings.add(digits.substring(0, i) + c + digits.substring(i + 1));
        }
      }
    });

    return strings;
  }


  public static void main(String[] args) {
    Solution17 solution = new Solution17();
    List<String> ss = solution.letterCombinations("234");
    System.out.println(ss);

  }
}

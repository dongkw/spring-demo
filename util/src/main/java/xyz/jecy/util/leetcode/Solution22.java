package xyz.jecy.util.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 22. 括号生成 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 * 示例：
 *
 * 输入：n = 3 输出：[ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 */
public class Solution22 {


  public List<String> generateParenthesis(int n) {
    if (n == 0) {
      return List.of("");
    }
    return generateParenthesis(n - 1).stream().flatMap(t -> strToList(t).stream())
        .collect(Collectors.toList());
  }

  private List<String> strToList(String str) {
    List<String> result = new ArrayList<>();
    result.add(str + "()");
    for (int i = str.length() - 1; i >= str.length() / 2; i--) {
      if (str.charAt(i) == ')') {
        result.add(str.substring(0, i) + "()" + str.substring(i));
      } else {
        break;
      }
    }
    return result;
  }

  private void dfs(String str, int left, int right, int n, List<String> res) {

    if (left == n && right == n) {
      res.add(str);
      return;
    }
    if (left < right) {
      return;
    }
    if (left < n) {
      dfs(str + "(", left + 1, right, n, res);
    }
    if (right < n) {
      dfs(str + ")", left, right + 1, n, res);
    }

  }


  public static void main(String[] args) {
    Solution22 solution = new Solution22();
    List<String> ss = solution.generateParenthesis(4);
    System.out.println(ss);

  }
}

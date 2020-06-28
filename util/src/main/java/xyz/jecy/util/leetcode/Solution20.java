package xyz.jecy.util.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()" 输出: true 示例 2:
 *
 * 输入: "()[]{}" 输出: true 示例 3:
 *
 * 输入: "(]" 输出: false 示例 4:
 *
 * 输入: "([)]" 输出: false 示例 5:
 *
 * 输入: "{[]}" 输出: true
 */
public class Solution20 {


  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    Map<Character, Character> map = new HashMap<>() {
      {
        put(')', '(');
        put(']', '[');
        put('}', '{');
      }
    };

    for (char c : s.toCharArray()) {
      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
      }
      if (c == ')' || c == ']' || c == '}') {
        if (!stack.empty() && stack.peek() == map.get(c)) {
          stack.pop();
        } else {
          return false;
        }
      }
    }
    return stack.empty();

  }


  public static void main(String[] args) {
    Solution20 solution = new Solution20();
    boolean ss = solution.isValid("])");
    System.out.println(ss);

  }
}

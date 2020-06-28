package xyz.jecy.util.leetcode;

import java.util.Stack;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/5/28 9:41 上午
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class Solution394 {


  public String decodeString(String s) {

    Stack<Character> stack = new Stack<>();
    StringBuilder result = new StringBuilder();

    for (char c : s.toCharArray()) {
      if (isNum(c) || isStart(c)) {
        stack.push(c);
      }
      if (isStr(c)) {
        if (stack.empty()) {
          result.append(c);
        } else {
          stack.push(c);
        }
      }
      if (isEnd(c)) {
        StringBuilder str = new StringBuilder();
        StringBuilder count = new StringBuilder();
        while (!isStart(stack.peek())) {
          str.append(stack.pop());
        }
        stack.pop();
        while (!stack.empty() && isNum(stack.peek())) {
          count.append(stack.pop());
        }
        str = str.reverse();
        count=count.reverse();
        for (int i = 0; i < Integer.parseInt(count.toString()); i++) {
          if (!stack.empty()) {
            for (char z : str.toString().toCharArray()) {
              stack.push(z);
            }
          } else {
            result.append(str);
          }
        }
      }

    }

    return result.toString();
  }


  private boolean isNum(char c) {
    return c >= '0' && c <= '9';
  }

  private boolean isStr(char c) {
    return (c >= 'a' && c <= 'z')||(c>='A'&&c<='Z');
  }

  private boolean isStart(char c) {
    return c == '[';
  }

  private boolean isEnd(char c) {
    return c == ']';
  }

  public static void main(String[] args) {
    Solution394 solution = new Solution394();
//    System.out.println(solution.isStr('['));
    String ss = solution.decodeString("100[fc]");
    System.out.println(ss);

  }
}

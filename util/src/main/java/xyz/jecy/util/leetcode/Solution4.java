package xyz.jecy.util.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/5/26 6:33 下午
 * 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class Solution4 {

  public String convert(String s, int numRows) {

    if (numRows < 2) {
      return s;
    }
    List<StringBuilder> list = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      list.add(new StringBuilder());
    }
    int i = 0;
    boolean f = false;
    for (char c : s.toCharArray()) {

      list.get(i).append(c);
      if (i == numRows - 1 || i == 0) {
        f = !f;
      }
      i = i + (f ? 1 : -1);
//      if (f){
//        list.get(i).append(c);
//        if (i == numRows-1) {
//          f=false;
//        }else {
//          i++;
//        }
//      }else {
//        i--;
//        list.get(i).append(c);
//        if (i==0){
//          f=true;
//          i++;
//        }
//      }

    }

    return list.stream().reduce((t, r) -> t.append(r)).get().toString();
  }

  public static void main(String[] args) {
    String s = "LEETCODEISHIRING";
    Solution4 solution3 = new Solution4();
    String ss = solution3.convert(s, 4);
    System.out.println(ss);
  }

}

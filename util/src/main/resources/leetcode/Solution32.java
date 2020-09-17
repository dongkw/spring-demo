package xyz.jecy.util.leetcode;

/**
 * 32. 最长有效括号 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()" 输出: 2 解释: 最长有效括号子串为 "()" 示例 2:
 *
 * 输入: ")()())" 输出: 4 解释: 最长有效括号子串为 "()()"
 */
public class Solution32 {


  public int longestValidParentheses(String s) {

    if (s.length() <= 0) {
      return 0;
    }
    int[] dp = new int[s.length()];
    int max = 0;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        if (s.charAt(i - 1) == '(') {
          if (i > 2) {
            dp[i] = dp[i - 2] + 2;
          } else {
            dp[i] = 2;
          }
        } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
          dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;

        }
        max = Math.max(max, dp[i]);
      }

    }

    return max;

  }

  public static void main(String[] args) {
    Solution32 solution = new Solution32();
    int ss = solution.longestValidParentheses("(()");
    System.out.println(ss);

  }

  class Solution {
    public int magicalString(int n) {
      StringBuilder sb=new StringBuilder();
      sb.append("1");
      boolean flag=true;
      int fast=0;
      int low=0;
      int max1=1;
      while(fast<n){
        char s=flag?'2':'1';
        flag=!flag;
        if(s=='1'){
          if(sb.charAt(low)=='1'){
            sb.append(s);
            low++;
            fast++;
            max1++;
          }else{
            sb.append(s).append(s);
            low++;
            fast++;
            fast++;
            max1++;
            max1++;
          }
        }
      }

      return max1;


    }
    public void add(boolean flag,int low,int fast,StringBuilder sb,int max1){


  }


}
}

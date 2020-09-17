package xyz.jecy.util.leetcode;


/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/5/26 4:11 下午
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Solution3 {


  public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";

    int right = 0;
    int left = 0;
    for (int i = 0; i < s.length(); i++) {
      //两种中心扩散的统一处理。
      int len1 = getSub(s, i, i);
      int len2 = getSub(s, i, i + 1);
      int len = Math.max(len1, len2);
      //通过扩散长度算出字符串起点终点
      if (len > left - right) {
        right = i - (len - 1) / 2;
        left = i + len / 2;
      }

    }

    return s.substring(right,left+1);
  }

  private int getSub(String s, int left, int right) {
    int L = left, R = right;
    //中心扩散记长度
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
      L--;
      R++;
    }

    return R-L - 1;
  }

  public static void main(String[] args) {
    String s = "lcnvoknqgejxbfhijmxglisfzjwbtvhodwummdqeggzfczmetrdnoetmcydwddmtubcqmdjwnpzdqcdhplxtezctvgnpobnnscrmeqkwgiedhzsvskrxwfyklynkplbgefjbyhlgmkkfpwngdkvwmbdskvagkcfsidrdgwgmnqjtdbtltzwxaokrvbxqqqhljszmefsyewwggylpugmdmemvcnlugipqdjnriythsanfdxpvbatsnatmlusspqizgknabhnqayeuzflkuysqyhfxojhfponsndytvjpbzlbfzjhmwoxcbwvhnvnzwmkhjxvuszgtqhctbqsxnasnhrusodeqmzrlcsrafghbqjpyklaaqximcjmpsxpzbyxqvpexytrhwhmrkuybtvqhwxdqhsnbecpfiudaqpzsvfaywvkhargputojdxonvlprzwvrjlmvqmrlftzbytqdusgeupuofhgonqoyffhmartpcbgybshllnjaapaixdbbljvjomdrrgfeqhwffcknmcqbhvulwiwmsxntropqzefwboozphjectnudtvzzlcmeruszqxvjgikcpfclnrayokxsqxpicfkvaerljmxchwcmxhtbwitsexfqowsflgzzeynuzhtzdaixhjtnielbablmckqzcccalpuyahwowqpcskjencokprybrpmpdnswslpunohafvminfolekdleusuaeiatdqsoatputmymqvxjqpikumgmxaxidlrlfmrhpkzmnxjtvdnopcgsiedvtfkltvplfcfflmwyqffktsmpezbxlnjegdlrcubwqvhxdammpkwkycrqtegepyxtohspeasrdtinjhbesilsvffnzznltsspjwuogdyzvanalohmzrywdwqqcukjceothydlgtocukc";
    Solution3 solution3 = new Solution3();
    String ss = solution3.longestPalindrome(s);
    System.out.println(ss);
  }
}

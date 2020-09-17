package xyz.jecy.util.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 */
public class Solution15 {


  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    if (nums.length < 2) {
      return List.of();
    }
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int j = i + 1;
      int k = nums.length - 1;
      while (j < k) {
        if (-nums[i] == nums[j] + nums[k]) {
          result.add(List.of(nums[i], nums[j], nums[k]));
          while (j < k && nums[j] == nums[j + 1]) {
            j++;
          }
          while (j < k && nums[k] == nums[k - 1]) {
            k--;
          }
          j++;
          k--;
        } else if (-nums[i] > nums[j] + nums[k]) {
          j++;
        } else {
          k--;
        }
      }

    }

    return result;
  }
  public boolean isAnagram(String s, String t) {
    int [] m=new int[26];
    for(int i=0;i<s.length();i++){
      m[s.charAt(i)-'a']++;
    }
    for(int i=0;i<t.length();i++){
      m[t.charAt(i)-'a']--;

      if(m[t.charAt(i)-'a']<0){
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Solution15 solution = new Solution15();
    int[] i = new int[]{-1, 0, 1, 2, -1, -4};
    boolean ss = solution.isAnagram("a","ab");
    System.out.println(ss);

  }
}

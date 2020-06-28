package xyz.jecy.util.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.gradle.api.internal.provider.Collectors;

/**
 * 217. 存在重复元素 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1] 输出: true 示例 2:
 *
 * 输入: [1,2,3,4] 输出: false 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2] 输出: true
 */
public class Solution217存在重复元素 {

  public boolean containsDuplicate(int[] nums) {
    if (nums.length<1){
      return false;
    }
    int max=nums[0];
    int min=nums[0];
    for (int i=1;i<nums.length;i++){
      if (nums[i]>max){
        max=nums[i];
        continue;
      }
      if (nums[i]<min){
        min=nums[i];
        continue;
      }
      for (int j=0;j<i;j++){
        if (nums[i]==nums[j]){
          return true;
        }
      }

    }

//    Map map=new HashMap();
//    Arrays.
//    List<Integer> list=new ArrayList();
//    list.toArray(new Integer[list.size()]);
    return false;
  }

  public static void main(String[] args) {
    Solution217存在重复元素 solution = new Solution217存在重复元素();
    int[] nums = {1, 2, 4, 3, 4, 1};
//    boolean b = solution.containsDuplicate(nums);
    System.out.println(nums);

    nums=new int[nums.length+1];
    System.out.println(nums);

    char i=1;
    Integer.parseInt(String.valueOf(i));

  }

}

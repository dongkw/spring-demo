package xyz.jecy.util.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/5/25 2:44 下午
 */
public class Sum {

  public int[] twoSum(int[] nums, int target) {
    int[] r = new int[2];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        r[0] = map.get(target - nums[i]);
        r[1] = i;
        break;
      }
      map.put(nums[i], i);

    }
    return r;
  }

  public static void main(String[] args) {
    int[] nums1 = {2, 7, 11, 15};
    int target = 9;

    Sum sum = new Sum();
    int[] re = sum.twoSum(nums1, target);

    Arrays.stream(re).forEach(t -> {
      System.out.println(t);
    });

  }
}

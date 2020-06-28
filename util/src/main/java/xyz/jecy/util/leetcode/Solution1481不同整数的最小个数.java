package xyz.jecy.util.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.springframework.util.CollectionUtils;

/**
 * 1481. 不同整数的最少数目 给你一个整数数组 arr 和一个整数 k 。现需要从数组中恰好移除 k 个元素，请找出移除后数组中不同整数的最少数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [5,5,4], k = 1 输出：1 解释：移除 1 个 4 ，数组中只剩下 5 一种整数。 示例 2：
 *
 * 输入：arr = [4,3,1,1,3,3,2], k = 3 输出：2 解释：先移除 4、2 ，然后再移除两个 1 中的任意 1 个或者三个 3 中的任意 1 个，最后剩下 1 和 3
 * 两种整数。
 **/
public class Solution1481不同整数的最小个数 {


  public int findLeastNumOfUniqueInts(int[] arr, int k) {

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }
    List<Integer> list = map.entrySet().stream().map(t -> t.getValue()).sorted()
        .collect(Collectors.toList());

    for (int i = 0; i < list.size(); i++) {
      if (k >= list.get(i)) {
        k = k - list.get(i);
      } else {
        return list.size() - i;
      }
    }

    return 0;


  }

  public static void main(String[] args) {
    Solution1481不同整数的最小个数 solution = new Solution1481不同整数的最小个数();
    int[] i = {4, 3, 1, 1, 3, 3, 2};
    int ss = solution.findLeastNumOfUniqueInts(i, 3);
    System.out.println(ss);

  }
}

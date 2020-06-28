package xyz.jecy.util.leetcode;

import java.util.Arrays;

class Merge {

  public void merge(int[] nums1, int m, int[] nums2, int n) {

//    for (int i = m; i < m + n; i++) {
//      nums1[i] = nums2[i - m];
//    }
//    Arrays.sort(nums1);
    int last=m + n - 1;
    while (n > 0) {
        if (m==0||nums1[m - 1] <= nums2[n - 1]) {
          nums1[last--] = nums2[--n];
        } else {
          nums1[last--] = nums1[--m];
      }
    }

  }

  public static void main(String[] args) {
    int[] nums1 = {4, 5, 6, 0, 0, 0};
    int m = 3;
    int[] nums2 = {1, 2, 3};
    int n = 3;

    Merge solution = new Merge();
    solution.merge(nums1, m, nums2, n);

    Arrays.stream(nums1).forEach(t -> {
      System.out.println(t);
    });

  }


}
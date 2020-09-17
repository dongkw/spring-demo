package xyz.jecy.util.leetcode;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix = [ [1,2,3], [4,5,6], [7,8,9] ],
 *
 * 原地旋转输入矩阵，使其变为: [ [7,4,1], [8,5,2], [9,6,3] ] 示例 2:
 *
 * 给定 matrix = [ [ 5, 1, 9,11], [ 2, 4, 8,10], [13, 3, 6, 7], [15,14,12,16] ],
 *
 * 原地旋转输入矩阵，使其变为: [ [15,13, 2, 5], [14, 3, 4, 1], [12, 6, 8, 9], [16, 7,10,11] ]
 */
class Solution旋转图像 {

  public void rotate(int[][] matrix) {
    int l=matrix.length/2;
    int len=matrix.length-1;
    for(int i=0;i<l;i++){
      for(int j=i;j<len-i;j++){
        int temp=matrix[i][j];

        int t= matrix[j][len-i];
        matrix[j][len-i]=temp;
        temp=t;

        t= matrix[len-j][len-i];
        matrix[len-j][len-i]=temp;
        temp=t;

        t=matrix[len-j][i];
        matrix[len-j][i]=temp;
        temp=t;
        matrix[i][j]=temp;
      }
    }


  }


  public static void main(String[] args) {
    Solution旋转图像 solution = new Solution旋转图像();

    int[][] i = {{5, 1, 9,11},
        {2, 4, 8,10},
        {13, 3, 6, 7},
        {15,14,12,16}
    };

    solution.rotate(i);
    System.out.println(i);

  }
}

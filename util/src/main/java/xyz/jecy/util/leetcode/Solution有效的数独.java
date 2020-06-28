package xyz.jecy.util.leetcode;

/**
 * 1判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。 数字 1-9 在每一列只能出现一次。 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *
 * 上图是一个部分填充的有效的数独。
 *
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 示例 1:
 *
 * 输入: [ ['5','3','.','.','7','.','.','.','.'], ['6','.','.','1','9','5','.','.','.'],
 * ['.','9','8','.','.','.','.','6','.'], ['8','.','.','.','6','.','.','.','3'],
 * ['4','.','.','8','.','3','.','.','1'], ['7','.','.','.','2','.','.','.','6'],
 * ['.','6','.','.','.','.','2','8','.'], ['.','.','.','4','1','9','.','.','5'],
 * ['.','.','.','.','8','.','.','7','9'] ] 输出: true 示例 2:
 *
 * 输入: [ ['8','3','.','.','7','.','.','.','.'], ['6','.','.','1','9','5','.','.','.'],
 * ['.','9','8','.','.','.','.','6','.'], ['8','.','.','.','6','.','.','.','3'],
 * ['4','.','.','8','.','3','.','.','1'], ['7','.','.','.','2','.','.','.','6'],
 * ['.','6','.','.','.','.','2','8','.'], ['.','.','.','4','1','9','.','.','5'],
 * ['.','.','.','.','8','.','.','7','9'] ] 输出: false 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 */
class Solution有效的数独 {

  public boolean isValidSudoku1(char[][] board) {


    boolean[][] sumi = new boolean[9][9];
    boolean[][] sumj = new boolean[9][9];
    boolean[][] sumk = new boolean[9][9];

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        int n = board[i][j] - '1';
        int k = i / 3 * 3 + j / 3;
        if (board[i][j] != '.') {
          if (sumi[i][n]) {
            return false;
          }
          if (sumj[j][n]) {
            return false;
          }
          if (sumk[k][n]) {
            return false;
          }
          sumi[i][n] = true;
          sumj[j][n] = true;
          sumk[k][n] = true;
        }
      }


    }

    return true;
  }

  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          continue;
        }
        for (int k = 8; k > j; k--) {
          if (board[i][j] == board[i][k]) {
            return false;
          }
        }
        for (int k = 8; k > i; k--) {
          if (board[i][j] == board[k][j]) {
            return false;
          }
        }
        for (int k = i + 1; k % 3 != 0; k++) {
          for (int h = j / 3 * 3; h < j / 3 * 3 + 3; h++) {
            if (board[i][j] == board[k][h]) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  private int toInt(char c) {
    System.out.println(Integer.parseInt(String.valueOf(c)));
    return Integer.parseInt(String.valueOf(c));

  }


  public static void main(String[] args) {
    Solution有效的数独 solution = new Solution有效的数独();

    char[][] i = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

    boolean ss = solution.isValidSudoku(i);
    System.out.println(ss);

  }
}

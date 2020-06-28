package xyz.jecy.util.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 297. 二叉树的序列化与反序列化 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例:
 *
 * 你可以将以下二叉树：
 *
 * 1 / \ 2   3 / \ 4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]" 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode
 * 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 */
public class Solution297二叉树的序列化与反序列化 {

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      return serialize(root, "");
    }


    public String serialize(TreeNode root, String str) {
      if (root == null) {
        str += "null" + ",";
      } else {
        str += root.val + ",";
        str = serialize(root.left, str);
        str = serialize(root.right, str);
      }
      return str;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      data.indexOf("a");
      data.lastIndexOf("a");
      String[] data_array = data.split(",");
      List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
      return deserialize(data_list);
    }

    public TreeNode deserialize(List<String> data) {

      if (data.get(0).equals("null")) {
        data.remove(0);
        return null;

      }


      TreeNode root = new TreeNode(Integer.parseInt(data.get(0)));
      data.remove(0);
      root.left = deserialize(data);
      root.right = deserialize(data);

      return root;
    }
  }

  public static void main(String[] args) {
    Solution297二叉树的序列化与反序列化 solution = new Solution297二叉树的序列化与反序列化();
    Codec codec = new Codec();
    TreeNode root = new TreeNode(1);
    codec.deserialize(codec.serialize(root));

  }
}

package xyz.jecy.util.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class Solution102二叉树的层序遍历 {

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


  int[] preorder;
  Map<Integer,Integer> map;
  private int[] preorder1;
  private Map<Integer, Integer> hash;

  public TreeNode buildTree1(int[] preorder, int[] inorder) {
    int preLen = preorder.length;
    int inLen = inorder.length;
    if (preLen != inLen) {
      throw new RuntimeException("Incorrect input data.");
    }
    this.preorder = preorder;
    this.hash = new HashMap<>();
    for (int i = 0; i < inLen; i++) {
      hash.put(inorder[i], i);
    }

    return buildTree(0, preLen - 1, 0, inLen - 1);
  }


  private TreeNode buildTree(int preLeft, int preRight, int inLeft, int inRight) {
    // 因为是递归调用的方法，按照国际惯例，先写递归终止条件
    if (preLeft > preRight || inLeft > inRight) {
      return null;
    }
    // 先序遍历的起点元素很重要
    int pivot = preorder[preLeft];
    TreeNode root = new TreeNode(pivot);
    int pivotIndex = hash.get(pivot);
    root.left = buildTree(preLeft + 1, pivotIndex - inLeft + preLeft,
        inLeft, pivotIndex - 1);
    root.right = buildTree(pivotIndex - inLeft + preLeft + 1, preRight,
        pivotIndex + 1, inRight);
    return root;
  }
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    int p=preorder.length-1;
    int inLen=inorder.length-1;
    this.preorder = preorder;
    this.map = new HashMap<>();
    for (int i = 0; i < inLen; i++) {
      map.put(inorder[i], i);
    }
    return build(0,p,0,inLen);
  }

  private TreeNode build(int pl,int pr,int il,int ir){

    if(pl>pr||il>ir){
      return null;
    }
    int pivot=preorder[pl];
    TreeNode root=new TreeNode(preorder[pl]);
    int index=map.get(pivot);
    root.left=build(pl+1,index-il+pl, il,index-1);
    root.right=build(index-il+1+pl,pr,index+1,ir);
    return root;
  }




  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>>  list=new LinkedList<>();
    StringBuilder stringBuilder=new StringBuilder();
    String s="";
    int [] a=new int[3];
    int [] b=Arrays.copyOf(a,3);
   char c= s.charAt(0);
  int i= c-'0';
    Queue<TreeNode> q=new ArrayDeque<>();
    q.add(root);
    LinkedList<Integer> arr=new LinkedList<>();
    while(!q.isEmpty()){

      TreeNode t=q.poll();
      arr.add(t.val);
      sum=sum-t.val;
      if(t.left==null&&t.right==null){
        if(sum==0){
          list.add(arr);
        }else{
          arr.removeLast();
        }
      }
      if(t.left!=null){
        q.add(t.left);
      }
      if(t.right!=null){
        q.add(t.right);
      }

    }




    return list;
  }


  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> arr=new ArrayList<>();
    Queue<TreeNode> queue=new ArrayDeque<>();
    queue.add(root);
    StringBuilder stringBuilder=new StringBuilder();
    LinkedList<List<Integer>> arr1=new LinkedList<>();
    arr1.removeLast();
    Stack<String> s=new Stack<>();
    s.add("11");
    arr.add(List.of(root.val));
    arr1.addFirst(List.of(root.val));
    while (!queue.isEmpty()){
      int n=queue.size();
      List<Integer> list=new ArrayList<>();
      for (int i=0;i<n;i++){
        TreeNode treeNode=queue.poll();
        list.add(treeNode.val);
        if (treeNode.left!=null){
          queue.add(treeNode.left);
        }
        if (treeNode.right!=null){
          queue.add(treeNode.right);
        }
      }
      arr.add(list);
    }
    return arr;
  }

  public static void main(String[] args) {
    Solution102二叉树的层序遍历 solution = new Solution102二叉树的层序遍历();
//    Codec codec = new Codec();
//    TreeNode root = new TreeNode(1);
//    codec.deserialize(codec.serialize(root));

  }
}

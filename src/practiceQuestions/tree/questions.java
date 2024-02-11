package practiceQuestions.tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

public class questions {
    public static void main(String[] args){
//        TreeNode node = new TreeNode();
//        maxDepth(node, false);
//        isBalanced(node);
//        int[] max = new int[1];
//        maxDiameter(node, max);
        TreeNode bt = new TreeNode(1);
        bt.left = new TreeNode(2);
        bt.right = new TreeNode(3);
        bt.left.left = new TreeNode(4);
        bt.right.right = new TreeNode(5);
        System.out.println(zigzagLevelOrder(bt));
    }
    static int maxDepth(TreeNode root, boolean findBalanced) {
        if(root==null)return 0;
        int leftMax = maxDepth(root.left, findBalanced);
        int rightMax = maxDepth(root.right, findBalanced);
        if(findBalanced){
            if(leftMax == -1 || rightMax == -1)return -1;
            if(Math.abs(leftMax - rightMax) > 1)return -1;
        }
        return 1 + Math.max(leftMax, rightMax);

    }
    static boolean isBalanced(TreeNode root) {
        return maxDepth(root, true) != -1;
    }
    static int maxDiameter(TreeNode root, int[] max){
        if(root==null) return 0;
        int left = maxDiameter(root.left, max);
        int right = maxDiameter(root.right, max);
        max[0] = Math.max(max[0], left + right);
        return 1 + Math.max(left, right);
    }
    static int maxPathSum(TreeNode root, int[] max){
        if(root==null) return 0;
        int left = maxPathSum(root.left, max);
        int right = maxPathSum(root.right, max);
        max[0] = Math.max(max[0], left + right + root.val);
        return root.val + Math.max(left, right);
    }
    static boolean check(TreeNode p, TreeNode q){
        if(p.val != q.val)return false;
        return true;
    }
    static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    static List<List<Integer>> lot(TreeNode root, int i, List<List<Integer>> ans){
        if(root==null)return ans;
        if (i == ans.size()){
            ArrayList<Integer> lvlAns = new ArrayList<>();
            lvlAns.add(root.val);
            ans.add(lvlAns);
        }else{
            ans.get(i).add(root.val);
        }
        if(i%2==0){
            lot(root.right, i+1, ans);
            lot(root.left, i+1, ans);
        }else{
            lot(root.left, i+1, ans);
            lot(root.right, i+1, ans);
        }
        return ans;
    }
    static List<List<Integer>> zigzagLevelOrder(TreeNode root) { // wrong ans
        List<List<Integer>> arr = new ArrayList<>();
        return lot(root, 0, arr);
    }

         static void lBoundary(TreeNode root,ArrayList<Integer> list){
            if(root == null || root.left == null && root.right == null)return;
            if(root.left != null){
                list.add(root.val);
                lBoundary(root.left, list);
            }else{
                list.add(root.val);
                lBoundary(root.right, list);
            }
        }
         static void leaf(TreeNode root,ArrayList<Integer> list){
            if(root == null)return;
            if(root.left == null && root.right == null){
                list.add(root.val);
                return;
            }
            leaf(root.left, list);
            leaf(root.right, list);
        }
         static void rBoundary(TreeNode root,ArrayList<Integer> list){
            if(root == null || root.left == null && root.right == null)return;
            if(root.right != null)rBoundary(root.right, list);
            else rBoundary(root.left, list);
            list.add(root.val);

        }
         static List<Integer> traverseBoundary(TreeNode root){
            // Write your code here.
            ArrayList<Integer> list = new ArrayList<>();
            if(root.left != null)lBoundary(root,list);
            else list.add(root.val);
            leaf(root,list);
            rBoundary(root.right,list);
            return list;
        }

}

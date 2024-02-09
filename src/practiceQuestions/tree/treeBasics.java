package practiceQuestions.tree;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class BinaryTreeNode<T> {
    //coding ninjas
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}
class BinaryTree{
    BinaryTree left;
    BinaryTree right;
    int data;
    BinaryTree(int data){
        this.data = data;
    }
}
class TreeNode {
    // leet code
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class treeBasics {
    public static void main(String[] args){
//        BinaryTree bt = new BinaryTree(5);
//        bt.right = new BinaryTree(4);
//        bt.left = new BinaryTree(3);
//        System.out.println(bt.data);
        BinaryTreeNode<Integer> bt = new BinaryTreeNode<Integer>(1);
        bt.left = new BinaryTreeNode<Integer>(2);
        bt.right = new BinaryTreeNode<Integer>(3);
        bt.left.left = new BinaryTreeNode<Integer>(4);
        bt.left.right = new BinaryTreeNode<Integer>(5);
        bt.right.left = new BinaryTreeNode<Integer>(6);
        bt.right.right = new BinaryTreeNode<Integer>(7);
        System.out.println(bt.data);
        System.out.println(getLevelOrder(bt));
    }
    static void preOrderTraversal(BinaryTree bt){
        if(bt == null) return;
        System.out.print(bt.data);
        preOrderTraversal(bt.left);
        preOrderTraversal(bt.right);
    }
    static void postOrderTraversal(BinaryTree bt){
        if(bt == null)return;
        postOrderTraversal(bt.left);
        postOrderTraversal(bt.right);
        System.out.print(bt.data);
    }
    static void inOrderTraversal(BinaryTree bt){
        if(bt == null) return;
        inOrderTraversal(bt.left);
        System.out.print(bt.data);
        inOrderTraversal(bt.right);
    }
    static List<Integer> traverse(TreeNode root, ArrayList<Integer> ans, String type){
        if(root == null)return ans;
        if(Objects.equals(type, "preOrder")) {
            ans.add(root.val);
        }
        traverse(root.left, ans, type);
        if(Objects.equals(type, "inOrder")){
            ans.add(root.val);
        }
        traverse(root.right, ans, type);
        if(Objects.equals(type, "postOrder")){
            ans.add(root.val);
        }
        return ans;
    }
    static List<Integer> preOrderTraversal(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        return traverse(root, arr, "preOrder");
    }
    static List<Integer> postOrderTraversal(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        return traverse(root, arr, "postOrder");
    }
    static List<Integer> inOrderTraversal(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        return traverse(root, arr, "inOrder");
    }
    static ArrayList<Integer> traverse(BinaryTreeNode<Integer> root, ArrayList<Integer> ans, String type){
        if(root == null)return ans;
        if(Objects.equals(type, "preOrder")) {
            ans.add(root.data);
        }
        traverse(root.left, ans, type);
        if(Objects.equals(type, "inOrder")){
            ans.add(root.data);
        }
        traverse(root.right, ans, type);
        if(Objects.equals(type, "postOrder")){
            ans.add(root.data);
        }
        return ans;
    }
    static ArrayList<Integer> preorderTraversal(BinaryTreeNode<Integer> root) {
        ArrayList<Integer> arr = new ArrayList<>();
        return traverse(root, arr, "preOrder");
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
        lot(root.left, i+1, ans);
        lot(root.right, i+1, ans);

        return ans;
    }
    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<>();
        return lot(root, 0, arr);
    }

    static ArrayList<Integer> lot(BinaryTreeNode<Integer> root, ArrayList<Integer> ans){
        if(root==null)return ans;
        if(root.left != null) ans.add(root.left.data);
        if(root.right != null) ans.add(root.right.data);
        lot(root.left,  ans);
        lot(root.right, ans);
        return ans;
    }
    static ArrayList<Integer> getLevelOrder(BinaryTreeNode<Integer> root) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(root != null) arr.add(root.data);
        return lot(root,  arr);
    }
}

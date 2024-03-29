package practiceQuestions.tree;
import com.sun.source.tree.Tree;

import java.lang.reflect.Array;
import java.util.*;

class BinaryTreeNode<T> {
    //coding ninjas
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}
class Node {
    //coding ninjas
    int data;
    Node left;
    Node right;

    Node(int data) {
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
class TreeNodes<T>
{
    T data;
    TreeNodes<T> left;
    TreeNodes<T> right;

    TreeNodes(T data)
    {
        this.data = data;
        left = null;
        right = null;
    }
};
public class treeBasics {
    public static void main(String[] args){
//        BinaryTree bt = new BinaryTree(5);
//        bt.right = new BinaryTree(4);
//        bt.left = new BinaryTree(3);
//        System.out.println(bt.data);
//        BinaryTreeNode<Integer> bt = new BinaryTreeNode<Integer>(1);
//        bt.left = new BinaryTreeNode<Integer>(2);
//        bt.right = new BinaryTreeNode<Integer>(3);
//        bt.left.left = new BinaryTreeNode<Integer>(4);
//        bt.left.right = new BinaryTreeNode<Integer>(5);
//        bt.right.left = new BinaryTreeNode<Integer>(6);
//        bt.right.right = new BinaryTreeNode<Integer>(7);
        TreeNode bt = new TreeNode(1);
        bt.left = new TreeNode(2);
        bt.right = new TreeNode(3);
        bt.left.left = new TreeNode(4);
        bt.left.right = new TreeNode(5);
        bt.right.left = new TreeNode(6);
        bt.right.right = new TreeNode(7);
        System.out.println(rightSideView(bt));
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
    static Node addElementInBST(int data, Node root){
        if(root == null) {
            root = new Node(data);
            return root;
        }
        if(root.data <= data){
            root.left = addElementInBST(data, root.left);
        }else{
            root.right = addElementInBST(data, root.right);
        }
        return root;
    }
    static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            root = new TreeNode(val);
            return root;
        }
        if(root.val < val){
            root.left = insertIntoBST(root.left, val);
        }
        if(root.val > val){
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
    static int size(TreeNode node) {
        if(node == null) return 0;
        return size(node.left) + size(node.right) + 1;
    }
    static int maxInBT(TreeNode node) {
        if(node == null) return 0;
        return Math.max(node.val, Math.max(maxInBT(node.left), maxInBT(node.right)));
    }
    static int lvlOrderTraversal(TreeNode node, int level) { // call this in loop for full traversal
        if(node == null) return 0;
        if(level == 1) {
            System.out.println(node.val);
        }
        lvlOrderTraversal(node.left, level -1);
        lvlOrderTraversal(node.right, level -1);
        return node.val;
    }
    static void getRightSideView(TreeNode root, List<TreeNode> ans, int level){
        if (root == null)return;
        if(ans.size() == level)ans.add(root);
        getRightSideView(root.right, ans, level+1);
        getRightSideView(root.left, ans, level+1);
    }
    static List<Integer> rightSideView(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        getRightSideView(root, ans, 0);
        List<Integer> a = new ArrayList<>();
        for(int i = 0;i<ans.size();i++){
            a.add(ans.get(i).val);
        }
        return a;
    }
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)return null;
        if(root.val == p.val || root.val == q.val)return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null)return right;
        if(right == null)return left;
        return root;
    }
    static int minValue(TreeNode root){
        int minV = root.val;
        while(root.left != null){
            minV = root.left.val;
            root = root.left;
        }
        return minV;
    }
    static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)return null;
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null)return root.right;
            else if(root.right == null)return root.left;
            root.val = minValue(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    static boolean isBST(TreeNode root, int lb, int ub){
        if(root==null)return true;
        if(root.val < lb || root.val > ub)return false;
        return isBST(root.left, lb, root.val - 1) && isBST(root.right, root.val + 1, ub);
    }
    static boolean isValidBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

//    static int findCeil(TreeNode<Integer> node, int x) {
//        if(node == null)return 0;
//        int ans = node.val;
//        while(node != null){
//            if(node.val == x)return node.val;
//            if(node.left != null && node.left.val < ans && node.left.val > x) {
//                ans = node.left.val;
//                node = node.left;
//            }else{
//                ans = node.right.val;
//                node = node.right;
//            }
//        }
//        return ans;
//    }
    static boolean findTwoSum(TreeNode root, int sum, Set<Integer> set){
        if(root == null)return false;
        if(findTwoSum(root.left, sum-root.val, set))return true;
        set.add(root.val);
        return findTwoSum(root.right, sum, set);
    }

    static boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return findTwoSum(root, k, set);
    }
}

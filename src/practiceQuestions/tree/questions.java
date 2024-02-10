package practiceQuestions.tree;

public class questions {
    public static void main(String[] args){

    }
    static int maxDepth(TreeNode root) {
        if(root==null)return 0;
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return 1 + Math.max(leftMax, rightMax);
    }
}

package practiceQuestions.arrayQues;

import java.util.Stack;

public class equalStacks {
    public static void main(String[] args) {

    }
    static Stack<Integer> fillStack(int[] arr, Stack<Integer> s){
        int sum = arr[0];
        s.push(sum);
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            s.push(sum);
        }
        return s;
    }
    static int equalStack(int[] h1, int[] h2, int[] h3){
        int maxHeight = 0;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();

        fillStack(h1, s1);
        fillStack(h2, s2);
        fillStack(h3, s3);

        return maxHeight;
    }
}

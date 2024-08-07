package practiceQuestions.arrayQues;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        System.out.println(Arrays.toString(stockSpanMethod1(arr)));
        System.out.println(Arrays.toString(stockSpanMethod2(arr)));
    }
    static int[] stockSpanMethod1(int[] arr){
        int[] ans = new int[arr.length];
        ans[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int diff = 1;
            for (int j = i - 1; j >= 0; j--) {
                if(arr[j] < arr[i]) diff++;
                else break;
            }
            ans[i] = diff;
        }
        return ans;
    }
    static int[] stockSpanMethod2(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        stack.push(0);
        ans[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[stack.peek()] > arr[i]){
                stack.push(i);
                ans[i] = 1;
                continue;
            }
            while(!stack.isEmpty()){
                if(arr[stack.peek()] > arr[i]){
                    ans[i] = i - stack.peek();
                    break;
                }
                stack.pop();
            }
        }
        return ans;
    }
}

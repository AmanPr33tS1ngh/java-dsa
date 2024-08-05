package practiceQuestions.arrayQues;

import java.util.Stack;

public class minimumLoss {
    public static void main(String[] args) {
        int[] arr = {20, 15, 8, 2, 12};
        System.out.println(minimumLossMethod1(arr));
        System.out.println(minimumLossMethod2(arr));
    }
    static int minimumLossMethod1(int[] arr){
        int minLoss = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] - arr[j] < minLoss && arr[i] - arr[j] > 0) minLoss = arr[i] - arr[j];
            }
        }
        return minLoss;
    }
    static int minimumLossMethod2(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int minLoss = Integer.MAX_VALUE;
        stack.push(arr[0]);
        int i = 1;
        while(!stack.isEmpty() && i < arr.length) {
            if(stack.peek() > arr[i]){
                minLoss = stack.peek() - arr[i];
                stack.push(arr[i]);
                i++;
            }
            else {
                stack.pop();
            }
        }
        return minLoss;
    }
}

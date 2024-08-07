package practiceQuestions.arrayQues;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6};
        //                         , 5, 6, 4, 2, 4, 6,-1
        // 6, 5, 2
        System.out.println(Arrays.toString(nextGreaterElement(arr)));
        System.out.println(Arrays.toString(nextGreaterElementMethod2(arr)));
    }

    static int[] nextGreaterElementMethod2(int[] nums){
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(nums[i]);
                nums[i] = -1;
                continue;
            }
            if (stack.peek() > nums[i]) {
                int currVal = nums[i];
                nums[i] = stack.peek();
                stack.push(currVal);
                continue;
            }
            while(!stack.isEmpty()){
                if (stack.peek() > nums[i]) {
                    int currVal = nums[i];
                    nums[i] = stack.peek();
                    stack.push(currVal);
                    break;
                }
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(nums[i]);
                nums[i] = -1;
            }
        }
        return nums;
    }

    static int[] nextGreaterElement(int[] arr){
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int greaterThanCurrent = getGreaterThanCurrentElement(arr, i);
            ans[i] = greaterThanCurrent;
        }
        return ans;
    }
    static int getGreaterThanCurrentElement(int[] arr, int i){
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] > arr[i]) return arr[j];
        }
        return -1;
    }
}

package practiceQuestions.arrayQues;

import java.util.Arrays;

public class LeftRotate {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(leftRotateMethod1(arr, 2)));
        System.out.println(Arrays.toString(leftRotateMethod2(arr, 2)));
    }
    static int[] leftRotateMethod1(int[] nums, int k){
        int[] newArr = new int[nums.length];
        k %= nums.length;
        int j = 0;
        for (int i = k+1; i< nums.length;i++){
            newArr[j++] = nums[i];
        }
        for (int i = 0; i < k+1;i++){
            newArr[j++] = nums[i];
        }
        return newArr;
    }
    static int[] leftRotateMethod2(int[] nums, int k){
        k %= nums.length;
        rotate(nums, 0, nums.length-1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, nums.length-1);
        return nums;
    }
    static int[] rotate(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
}

package practiceQuestions.arrayQues;

import java.util.*;

public class TwoSum {
    public static void main(String[] args){
        int[] arr = {3,5,2,6,8};
        System.out.println(Arrays.toString(twoSumMethod1(arr, 14)));
        System.out.println(Arrays.toString(twoSumMethod2(arr, 14)));
    }
    static int[] twoSumMethod1(int[] arr, int target){
        Set<Integer> map = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int currElement = arr[i];
            int diff = target - currElement;
            if(map.contains(diff)) return new int[]{currElement, diff};
            map.add(arr[i]);
        }
        return new int[]{-1, -1};
    }
    static int[] twoSumMethod2(int[] arr, int target){
        Arrays.sort(arr);
        int start = 0, end = arr.length - 1;
        while(start < end) {
            int sum = arr[start] + arr[end];
            if (sum == target) return new int[]{arr[start], arr[end]};
            else if (sum < target) start++;
            else end--;
        }
        return new int[]{-1, -1};
    }
    static int[] twoSumReturnIndicesMethod1(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currElement = nums[i];
            int diff = target - currElement;
            if(map.containsKey(diff)) return new int[]{map.get(diff), i};
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
    static int[] twoSumReturnIndicesMethod2(int[] nums, int target){
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        while(start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) return new int[]{start, end};
            else if (sum < target) start++;
            else end--;
        }
        return new int[]{-1, -1};
    }
}

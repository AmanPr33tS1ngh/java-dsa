package practiceQuestions.arrayQues;

import java.util.Arrays;
import java.util.Objects;

public class binarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,7,9,10,12,15,19,20};
        int[] mountainArr = {1,3,5,6,7,9,10,8,4,3,1};
        int[] arr2 = {1,3,3,3,5,5,5,5,5,6,7,9,9,9,9,9,9,9,10,8,4,3,1};
        System.out.println(search(arr, 18, "bs"));
        System.out.println(search(arr, 18, "cn"));
        System.out.println(search(arr, 18, "fn"));
        System.out.println(findPeakInMountainArray(mountainArr));
        System.out.println(Arrays.toString(searchRange(arr2, 5)));
    }

    static int search(int[] arr, int target, String type){
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start) / 2;

        while(start <= end){
            if (arr[mid] < target){
                start = mid + 1;
                mid = start + (end - start) / 2;
            }
            else if (arr[mid] > target){
                end = mid - 1;
                mid = start + (end - start) / 2;
            }else{
                return mid;
            }
        }
        if (Objects.equals(type, "bs")) {// binary search
            return mid;
        }
        else if (Objects.equals(type, "cn")) {// celeing number
            return start;
        }
        return end; // floor number
    };
    static int findPeakInMountainArray(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int mid = start + (end-start)/2;
            if (nums[mid]>nums[mid+1]){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
    static int[] searchRange(int[] nums, int target){
        return new int[]{search(nums, target, true), search(nums, target, false)};
    }
    static int search(int[] arr, int target, boolean searchFirstOccurence){
        int ans = arr[0];
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end-start) / 2;
            if (arr[mid] < target){
                start = mid + 1;
            }else if(arr[mid] > target){
                end = mid - 1;
            }else{
                ans = mid;
                if(searchFirstOccurence){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}

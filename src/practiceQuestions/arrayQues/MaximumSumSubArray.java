package practiceQuestions.arrayQues;

public class MaximumSumSubArray {
    public static void main(String[] args) {
        // Kadane's algo
        int[] arr = {-2, -5, 6, -2, -3, 1, 5, -6};
        System.out.println(maximumSumSubArrayMethod1(arr));
    }
    static int maximumSumSubArrayMethod1(int[] nums){
        int maxSoFar = nums[0];
        int currMax = nums[0];
        for (int i: nums){
            currMax = Math.max(currMax, i + currMax);
            maxSoFar = Math.max(currMax, maxSoFar);
        }
        return maxSoFar;
    }
}

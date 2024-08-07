package practiceQuestions.arrayQues;

public class MaximumWater {
    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        //int[] arr = {2, 4, 5, 3, 1};

        //                |
        //            |   |
        //            |   |   |
        //        |   |   |   |
        //        |   |   |   |   |

        System.out.println(maximumWaterMethod1(arr));
        System.out.println(maximumWaterMethod2(arr));
    }
    static int maximumWaterMethod1(int[] height){
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                // length * breadth
                int length = Math.min(height[i], height[j]);
                int breadth = j - i;
                int area = length * breadth;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
    static int maximumWaterMethod2(int[] height){
        int maxArea = Integer.MIN_VALUE;
        int start = 0, end = height.length - 1;
        while (start < end) {
            int breadth = end - start;
            int length = Math.min(height[start], height[end]);
            int area = length * breadth;
            maxArea = Math.max(area, maxArea);
            if (height[start] > height[end]) {
                end--;
            }else {
                start++;
            }
        }
        return maxArea;
    }
}

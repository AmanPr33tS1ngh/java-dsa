package practiceQuestions.arrayQues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumbersSmallerThanCurrent {
    public static void main(String[] args) {
        int[] arr = {2,3,4,1,5,7,9,4,2,3};
        System.out.println(Arrays.toString(numSmallerThanCurrent(arr)));
        System.out.println(Arrays.toString(numSmallerThanCurrent2(arr)));
    }
    static int[] numSmallerThanCurrent(int[] arr){
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] < arr[i] && j != i) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }

    static int[] numSmallerThanCurrent2(int[] arr){
        int maxElement = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > maxElement) maxElement = arr[i];
        }
        int[] countArr = new int[maxElement + 1];
        // count each element
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]] = countArr[countArr[arr[i]]] + 1;
        }

        int accumulator = 0;
        for (int i = 0; i < countArr.length; i++) {
            accumulator += countArr[i];
            countArr[i] = accumulator;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = countArr[arr[i] - 1];
        }
        return arr;
    }
}

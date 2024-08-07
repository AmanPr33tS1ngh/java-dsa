package practiceQuestions.arrayQues;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] arr = {4, 3, 5,0, 0, };
        System.out.println(Arrays.toString(moveZeroes(arr)));
        int[] newArr = {0, 0, 4, 3, 5, };
        System.out.println(Arrays.toString(moveZeroes1(arr)));
    }
    static int[] moveZeroes(int[] arr){
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[j] = arr[i];
                j++;
            }
        }
        while (j < arr.length) {
            arr[j] = 0;
            j++;
        }
        return arr;
    }

    static int[] moveZeroes1(int[] arr){
        int i = 0;
        int j = arr.length - 1;
        while(i < j) {
            if(arr[i] != 0){
                i++;
            }
            if(arr[j] == 0){
                j--;
            }
            if(arr[i] == 0 && arr[j] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return arr;
    }
}

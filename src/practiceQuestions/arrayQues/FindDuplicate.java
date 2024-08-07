package practiceQuestions.arrayQues;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,3};
        System.out.println(findDup(arr));
        System.out.println(findDup2(arr));
        System.out.println(findDup3(arr));
    }
    static int findDup(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i] == arr[j] && i != j) return arr[i];
            }
        }
        return -1;
    }
    static int findDup2(int[] arr){
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1] == arr[i]) return arr[i];
        }
        return -1;
    }
    static int findDup3(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < arr.length; i++) {
            if (set.contains(arr[i])) return arr[i];
            set.add(arr[i]);
        }
        return -1;
    }
}

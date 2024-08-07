package practiceQuestions.arrayQues;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lostNum {
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 2, 4, 6, 6, 5};
        System.out.println(lostNumbers(arr));
    }
    static List<Integer> lostNumbers(int[] arr){
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int j : arr) {
            set.add(j);
        }
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(i+1)) list.add(i+1);
        }
        return list;
    }
}

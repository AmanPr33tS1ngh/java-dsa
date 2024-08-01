package practiceQuestions.arrayQues;
import java.util.*;

public class SingleNonRepeatingElement {
    public static void main(String[] args){
        int[] arr = {2,5,4,1,8, 0, 0, 1, 9,4,2,5, 8};
        System.out.println(filterNonRepeatingElementMethod1(arr));
        System.out.println(filterNonRepeatingElementMethod2(arr));
        System.out.println(filterNonRepeatingElementMethod3(arr));
    }
    static int filterNonRepeatingElementMethod1(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            boolean found = false;
            for (int j = 0; j < arr.length; j++){
                if (arr[i] == arr[j] && i != j) {
                    found = true;
                }
            }
            if (!found) {
                return arr[i];
            }
        }
        return -1;
    }

    static int filterNonRepeatingElementMethod2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer key: map.keySet()){
            if(map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

    static int filterNonRepeatingElementMethod3(int[] nums) {
        if (nums.length <= 1) return -1;

        int element = nums[0];
        for (int i = 1; i < nums.length; i++){
            element ^= nums[i];
        }
        return element;
    }
}

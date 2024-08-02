package practiceQuestions.arrayQues;

import java.util.*;

public class FindAllDuplicates {
    public static void main(String[] args) {

    }
    static List<Integer> findAllDuplicatesMethod1(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.getOrDefault(nums[i], 0) > 0) list.add(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return list;
    }
    static List<Integer> findAllDuplicatesMethod2(int[] nums){
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i] && !list.contains(nums[i])) list.add(nums[i]);
        }
        return list;
    }
    static List<Integer> findAllDuplicatesMethod3(int[] nums){
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i] && !list.contains(nums[i])) list.add(nums[i]);
        }
        return list;
    }
}

package practiceQuestions.arrayQues;

import java.util.*;

public class linearSearch {
    public static void main(String[] args){
//        createMultiDimArray();
//        arrayListFunc();
//        multiDimArrayList();
//        int a = 1;
//        int b = 4;
//        System.out.println(a^b);
//        int[] arr = {1,2,3, 9, 8, 6, 5, 4};
//        int[] arr3 = {1,2,3,4,5,6,7,8};
//        int[] arr1 = {1,2,4,3};
//        int[][] arr2D = {{1,2,3,4}, {6,7,8,9}};
//        int[] arr2 = {1,1,1,1,2,2,2,2,2,2,3,3,3,3,3,4,4,5,6,6,6,6,6,6,6,6,6,6,6,6,7,7};
//        int[] arr4 = {1,0,1,1,2,0,2,2,2,2,3,3,3,0,0,0,4,5,6,0,6,6,6,6,0,0,6,6,6,6,0,7};
//        int[] i = {1, 2, 3, 4, 5, 7, 8};
//        int[] j = {3, 4, 6, 7, 9};
        int[] arr5 = {1,2, 3, 4, 6, 7,8,9,10};
        int[] arr6 = {0,1,0,0,1,0,1,1,1,1,0,1,0,1,0,1,1,1,1,1,0,1,0};
        int[] arr7 = {3,2,4};

//        swapInArray(arr);
//        System.out.println(maxInArray(arr));
//        rotateArray(arr);
//        System.out.println(linearSearch(arr, 9));
//        System.out.println(linearSearchReturnIndex(arr, 2));
//        System.out.println(searchInRange(arr, 3, 0,2));
//        System.out.println(searchMinElement(arr));
//        System.out.println(Arrays.toString(searchIn2D(arr2D, 4)));
//        System.out.println(evenNumList(arr));
        // #striver
//        System.out.println(secondLargestElement(arr));
//        System.out.println(isArraySorted(arr1));
//        System.out.println(returnNumUniqueElements(arr2));
//        System.out.println(Arrays.toString(leftRotateArray(arr)));
//        System.out.println(Arrays.toString(leftRotateArrayTillN(arr, 3)));
//        System.out.println(Arrays.toString(optimalLeftRotateArrayTillN(arr3, 2)));
//        System.out.println(Arrays.toString(optimalRightRotateArrayTillN(arr3, 2)));
//        System.out.println(Arrays.toString(moveZeroesToEnd(arr4)));
//        System.out.println(Arrays.toString(intersection(i, j)));
//        System.out.println(unionOfTwoArrays(i, j));
//        System.out.println(intersectionOfTwoArrays(i, j));
//        System.out.println(missingNumberInArray(arr5));
//        System.out.println(maxConsecutiveOnesInArray(arr6));
        System.out.println(longestSubArrayWithSumK(arr5, 3));
        System.out.println(Arrays.toString(twoSumEqualsK(arr7, 6)));
    }

    static boolean linearSearch(int[] arr, int target){
        for (int i:arr){
            if (i==target){
                return true;
            }
        }
        return false;
    }

    static int linearSearchReturnIndex(int[] arr, int target){
        for (int i = 0;i<arr.length;i++){
            if (arr[i]==target){
                return i;
            }
        }
        return -1;
    }

    static void rotateArray(int[] arr){
        for (int i=0;i<arr.length/2;i++){
            arr = swap(arr, i, arr.length-i-1);
        }
        System.out.println(Arrays.toString(arr));
    }
    static int maxInArray(int[] arr){
        int max = arr[0];
        for (int i:arr){
            if (i > max){
                max = i;
            }
        }
        return max;
    }
    static void swapInArray(int[] arr){
        arr = swap(arr, 1,3);
        System.out.println(Arrays.toString(arr));
    }
    static int[] swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
    static void multiDimArrayList(){
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for (int i=0;i<3;i++){
            ArrayList<Integer> tempArr = new ArrayList<>();
            for (int j=0;j<2;j++){
                tempArr.add(sc.nextInt());
            }
            arr.add(tempArr);
        }
        System.out.println(arr);
        arr = removeItemFromMultiDimArrayList(2,1,arr);
        System.out.println(arr);
    }
    static ArrayList<ArrayList<Integer>> removeItemFromMultiDimArrayList(int i, int j, ArrayList<ArrayList<Integer>> arr){
        arr.get(i).remove(j);
        return arr;
    }
    static void arrayListFunc(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>(10);
        for (int i = 0;i<10;i++){
            arr.add(sc.nextInt());
        }
        printArrayList(arr);
        arr = removeItemFromArrayList(3, arr);
        printArrayList(arr);
    }
    static void printArrayList(ArrayList<Integer> arr){
            System.out.println(arr);
    }
    static ArrayList<Integer> removeItemFromArrayList(int index, ArrayList<Integer> arr){
        arr.remove(index);
        return arr;
    }
    static void createMultiDimArray(){
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[5][3];
        for (int i = 0; i < arr.length;i++){
            for (int j = 0;j < arr[i].length;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        printMultiDimArray(arr);
    }
    static void printMultiDimArray(int[][] arr){
        for (int i =0;i<arr.length;i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    static int searchInRange(int[] arr, int target, int start, int end){
        for (int i = start; i <= end; i++) {
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
    static int searchMinElement(int[] arr){
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min){
                min=arr[i];
            }
        }
        return min;
    }
    static int[] searchIn2D(int[][] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0;j < arr[i].length;j++){
                if(arr[i][j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
    static ArrayList<Integer> evenNumList(int[] arr){
        ArrayList<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0){
                arrList.add(arr[i]);
            }
        }
        return arrList;
    }
    static int secondLargestElement(int[] arr){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 0 ; i < arr.length ; i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
            if (arr[i] > secondLargest && arr[i] < largest){
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
    static boolean isArraySorted(int[] arr){
        boolean isAsc = false;
        if(arr[0] < arr[1]){
            isAsc = true;
        }
        for (int i = 0;i<arr.length-1;i++){
            if (isAsc && arr[i] > arr[i+1]){
                return false;
            }
            else if (!isAsc && arr[i] < arr[i + 1]){
                return false;
            }
        }
        return true;
    }
    static int returnNumUniqueElements(int[] arr){ // returns number of unique elements
        int i = 0;
        for(int j=0;j<arr.length;j++){
            if(arr[i] != arr[j]){
                arr[i+1] = arr[j];
                i++;
            }
        }
        return i + 1;
    }
    static int[] leftRotateArray(int[] arr){ // returns number of unique elements
        if(arr.length == 0){
            return new int[]{};
        }
        int temp = arr[0];
        int i = 0;
        for (i=0;i<=arr.length-2;i++){
            arr[i] = arr[i+1];
        }
        arr[i] = temp;
        return arr;
    }
    static int[] leftRotateArrayTillN(int[] arr, int n){ // uses extra space of O(n) n=num of elements to be left rotated. tc O(n+len)
        n = n % arr.length;
        int[] temp = new int[n];
        for (int i = 0;i < n;i++){
            temp[i] = arr[i];
        }
        for(int j = n;j<arr.length;j++){
            arr[j-n] = arr[j];
        }
        for (int j=arr.length-n;j<arr.length;j++){
            arr[j] = temp[j-(arr.length-n)];
        }
        return arr;
    }
    static int[] optimalLeftRotateArrayTillN(int[] arr, int n){ // uses extra space of O(1) tc O(2n)
        int arrLen = arr.length;
        n = n % arrLen;
        arr = reverse(arr, 0,n);
        arr = reverse(arr, n+1,arrLen-1);
        arr = reverse(arr, 0,arrLen-1);
        return arr;
    }
    static int[] optimalRightRotateArrayTillN(int[] arr, int n){
        int arrLen = arr.length;
        n = n % arrLen;
        arr = reverse(arr, 0,arrLen-1);
        arr = reverse(arr, 0,n-1);
        arr = reverse(arr, n,arrLen-1);
        return arr;
    }
    static int[] reverse(int[] arr, int start, int end){
        while (start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
    // 4,5,3,3,2,0,0,5,6,0
    static int[] moveZeroesToEnd(int[] arr){
        int j = 0;
        for(int i=0;i<=arr.length - 1;i++){
            if(arr[j] != 0){
                j++;
            }
            if (i>j && arr[j] == 0 && arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return arr;
    }


    static ArrayList<Integer> unionOfTwoArrays(int[] arr1, int[] arr2){
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        int currVal = Integer.MIN_VALUE;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i]<arr2[j] && currVal != arr1[i]){
                ans.add(arr1[i]);
                currVal = arr1[i];
                i++;
            }
            else if(arr1[i] == arr2[j] && currVal != arr1[i]){
                ans.add(arr1[i]);
                currVal = arr1[i];
                i++;
                j++;
            }else if(arr1[i]>arr2[j] && currVal != arr2[j]){
                ans.add(arr2[j]);
                currVal = arr2[j];
                j++;
            }else{
                i++;
                j++;
            }
        }
        while(i<arr1.length){
            ans.add(arr1[i]);
            i++;
        }
        while(j<arr2.length){
            ans.add(arr2[j]);
            j++;
        }
        return ans;
    }

    static ArrayList<Integer> intersectionOfTwoArrays(int[] arr1, int[] arr2){
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        int currVal = Integer.MIN_VALUE;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                i++;
            }
            else if(arr1[i] > arr2[j]){
                j++;
            }
            else if(arr1[i] == arr2[j] && currVal != arr1[i]){
                ans.add(arr1[i]);
                currVal = arr1[i];
                i++;
                j++;
            } else {
                i++;
                j++;
            }
        }
        return ans;
    }
    static int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        int currVal = Integer.MIN_VALUE;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                i++;
            }
            else if(nums1[i] > nums2[j]){
                j++;
            }
            else if(nums1[i] == nums2[j] && currVal != nums1[i]){
                ans.add(nums1[i]);
                currVal = nums1[i];
                i++;
                j++;
            } else {
                i++;
                j++;
            }
        }
        int[] newAns = new int[ans.size()];
        for(int m=0;m<ans.size();m++){
            newAns[m] = ans.get(m);
        }
        return newAns;
    }
    static int missingNumberInArray(int[] arr){ // 0 not in array if 0 is present remove +1 from arrLen
        int arrLen = arr.length;
        int totalSum = (arrLen * (arrLen + 1))/2;
        int sum = 0;
        for (int i =0;i<arrLen;i++){
            sum += arr[i];
        }
        return totalSum - sum;
    }
    static int maxConsecutiveOnesInArray(int[] arr){
        int i = 0, j = 0, ans = 0, bestSol = 0;
        while(i<arr.length && j<arr.length){
            if(arr[i] == 1 && arr[j]==1){
                j += 1;
                ans += 1;
                if(ans > bestSol){
                    bestSol = ans;
                }
            }else{
                j++;
                i = j;
                ans = 0;
            }
        }
        return bestSol;
    }
    static int longestSubArrayWithSumK(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int length = 0;
        for (int i=0;i<arr.length;i++){
            sum += arr[i];
            if(sum == k){
                length = i+1;
            }
            else if(map.containsKey(sum-k)){
                length = Math.max(length,i-map.get(sum-k));
            }
            map.put(sum, i);
        }
        return length;
    }
    static int[] twoSumEqualsK(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int end = arr.length - 1;
        for(int i:arr){
            map.put(i, start);
            start++;
        }
        start = 0;
        Arrays.sort(arr);
        while(start<end){
            int arrStart = arr[start];
            int arrEnd = arr[end];
            int sum = arrStart + arrEnd;
            if(sum==k){
                return new int[]{map.get(arrStart), map.get(arrEnd)};
            }else if(sum<k){
                start++;
            }else{
                end--;
            }
        }
        return new int[]{-1, -1};
    }
}

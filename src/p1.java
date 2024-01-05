import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p1 {
    public static void main(String[] args){
//        createMultiDimArray();
//        arrayListFunc();
//        multiDimArrayList();
        int[] arr = {1,2,3,4};
//        swapInArray(arr);
//        System.out.println(maxInArray(arr));
//        rotateArray(arr);
        System.out.println(linearSearch(arr, 9));
        System.out.println(linearSearchReturnIndex(arr, 2));
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
}

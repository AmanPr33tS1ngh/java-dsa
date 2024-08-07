package practiceQuestions.arrayQues;

public class insertPosition {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        System.out.println(searchPosition(arr, 2));
        System.out.println(searchPosition(arr, 1));
        System.out.println(searchPosition(arr, 4));
    }
    static int searchPosition(int[] arr, int element){
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == element) return mid;
            else if (arr[mid] > element) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }
}

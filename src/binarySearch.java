import java.util.Objects;

public class binarySearch {
    static int search(int[] arr, int target, String type){
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start) / 2;

        while(start <= end){
            if (arr[mid] < target){
                start = mid + 1;
                mid = start + (end - start) / 2;
            }
            else if (arr[mid] > target){
                end = mid - 1;
                mid = start + (end - start) / 2;
            }else{
                return mid;
            }
        }
        if (Objects.equals(type, "bs")) {// binary search
            return mid;
        }
        else if (Objects.equals(type, "cn")) {// celeing number
            return start;
        }
        return end; // floor number
    };
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,7,9,10,12,15,19,20};
        int ans = search(arr, 18, "bs");
        System.out.printf("ans %d", ans);

        int celeingNumber = search(arr, 18, "cn");
        int floorNumber = search(arr, 18, "fn");
        System.out.printf("ans %d", celeingNumber);
        System.out.printf("ans %d", floorNumber);

    }
}

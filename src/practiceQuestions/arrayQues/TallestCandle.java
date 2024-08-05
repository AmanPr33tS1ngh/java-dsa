package practiceQuestions.arrayQues;

public class TallestCandle {
    public static void main(String[] args) {
        int[] arr = {3,4,5,6,3,4,6,6};
        System.out.println(tallestCandle(arr));
    }
    static int tallestCandle(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int countMax = 0;
        for (int i = 0;i<arr.length;i++){
            if(arr[i] == max) {
                countMax++;
            }
        }
        return countMax;
    }
}

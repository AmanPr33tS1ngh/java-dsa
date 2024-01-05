import java.util.Arrays;
import java.util.Scanner;

public class main {
    static int factorial(int number, int value){
        if (number == 1){
            return value;
        };
        return factorial(number-1, number*value);
    }
    public static void main(String[] args) {
        //loops
//        int i = 0;
//        while(i < 10){
//            System.out.printf("i is %d\n", i);
//            i++;
//        }
//        do{
//            System.out.printf("i in do while is %d\n", i);
//            i++;
//        }while (i<20);
//        for (int j=0;j<10;j+=2){
//            System.out.printf("j is %d\n", j);
//        }
//        for (int k=0;k<10;k++){
//            if(k==8){
//                break;
//            }
//            else if(k%2==0){
//                continue;
//            }
//            System.out.printf("k is %d\n", k);
//        }
        // arrays
//        int[] array = {2,3,5};
//        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);
//        for (int i=0;i<arr.length;i++){
//            arr[i] = sc.nextInt();
//        };
//        System.out.println(Arrays.toString(arr));
//        for(int j:arr){
//            System.out.printf("for each loop, i -> %d\n", j);
//        }
        //multi dimensional array
//        int[][] multiDimArr = new int[3][5];
//        for(int i=0;i<multiDimArr.length;i++){
//            for (int j=0;j<multiDimArr[i].length;j++){
//                System.out.printf("Enter value at index %d, %d:", i, j);
//                multiDimArr[i][j] = sc.nextInt();
//            }
//        }
//        for(int i=0;i<multiDimArr.length;i++){
//            for (int j=0;j<multiDimArr.length;j++){
//                System.out.printf("val at index %d, %d is: %d\n", i,j,multiDimArr[i][j]);
//            }
//        }
        //recursion
        int num = factorial(3, 1);
        System.out.printf("number is: %d\n", num);
    }
}

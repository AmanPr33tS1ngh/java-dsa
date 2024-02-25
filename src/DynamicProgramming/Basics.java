package DynamicProgramming;

public class Basics {
    public static void main(String[] args) {

    }
    static int minCoins(int n, int[] arr, int[] dp){
        if(n==0)return 0;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(n-arr[i] >= 0){
                int subAns = 0;
                if(dp[n-arr[i]] != -1){
                    subAns = dp[n-arr[i]];
                }else{
                    subAns = minCoins(n-arr[i], arr, dp);
                }
                if(subAns != Integer.MAX_VALUE && subAns + 1 < ans){
                    ans = subAns + 1;
                }
            }
        }
        dp[n] = ans;
        return ans;

    }
}


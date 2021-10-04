public class ClimbStairs5 {

    public static int climbStairsDP(int n) {
        if(n ==1){
            return 1;
        }
        int[] dp = new int[n + 1];
         dp[1]=1;
         dp[2]=2;
         for(int i=3;i<dp.length;i++){
             dp[i]=dp[i-1]+dp[i-2];
         }

        return dp[n];
    }


    public static int climbStairsFb(int n) {
        if(n ==1){
            return 1;
        }
        int f=1;
        int s=2;
        for(int i=3;i<=n;i++){
           int t=f+s;
           f=s;
           s=t;
        }

        return s;
    }

    public static void main(String args[]){
        System.out.println(climbStairsDP(6));
    }
}

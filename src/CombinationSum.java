
class CombinationSum{

    // Returns true if there is a subset
    // of set[] with sum equal to given sum
    static boolean isSubsetSum(int set[],
                               int n, int sum)
    {

        boolean[][] dp=new boolean[n+1][sum+1];

        //Initialize
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0)
                    dp[i][j]=false;
                if(j==0) dp[i][j]=true;
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(set[i-1]<=j)
                    dp[i][j]=dp[i-1][j-set[i-1]] || dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][sum];

    }

    /* Driver code */
    public static void main(String args[])
    {
        int set[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 19;
        int n = set.length;
        if (isSubsetSum(set, n, sum) == true)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }
}
public class ComSum {
    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (i >= n) {
                    dp[i] += dp[i - n];
                }
            }
        }
        return dp[target];
    }

    public static void rotate(int[][] matrix) {
        if(matrix==null || matrix.length<=1) return;




        for(int i=0;i<matrix.length;i++){
            int head=0;
            int tail=matrix[0].length-1;
            while(head<=tail){
                int temp=matrix[i][tail];
                matrix[i][tail]=matrix[i][head];
                matrix[i][head]=temp;
                head++;
                tail--;
            }

        }


        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix.length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }



    }
    public static void main(String args[])
    {
        int[][] matrix=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        //System.out.println(combinationSum4(new int [] {1,2,3},4));
    }
    }

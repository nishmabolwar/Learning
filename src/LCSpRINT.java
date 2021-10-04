import sun.lwawt.macosx.CSystemTray;

public class LCSpRINT {
    public String longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i -1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
     String s="";

        int i = n;
        int j = m;
        while (i > 0 && j > 0)
        {
            // If current character in X[] and Y are same, then
            // current character is part of LCS
            if (text1.charAt(i-1) == text2.charAt(j-1))
            {
                // Put current character in result
               s=s+text1.charAt(i-1);

                // reduce values of i, j and index
                i--;
                j--;
            }

            // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (dp[i-1][j] > dp[i][j-1]) {
                s = s + text1.charAt(i - 1);
                i--;
            }
            else {
                s = s + text2.charAt(j - 1);
                j--;
            }
        }
        return s;
    }
    public static void main(String args[]) {
        LCSpRINT lcs=new LCSpRINT();
        System.out.println(lcs.longestCommonSubsequence("abcdaf" ,"acbcf"));
    }

}

import java.util.Arrays;
import java.util.List;

public class wordbreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        for(int i = n-1; i >= 0; i--)
        {
            for(String word: wordDict)
            {
                int m = word.length();
                if(i + m <= n && s.substring(i, i+m).equals(word)){
                    dp[i] = dp[i+m];
                    System.out.println(dp[i]);
                }
                if(dp[i])
                    break;
            }
        }

        return dp[0];
    }
    public static void main(String args[]) {
        wordbreak lcs=new wordbreak();
        String a[] = new String[]{"leet","code"};
       List<String> l= Arrays.asList(a);
        System.out.println(lcs.wordBreak("leetcode" , l));
    }
}

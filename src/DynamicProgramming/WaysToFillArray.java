package DynamicProgramming;

 /* n = 4 -> f(n)
 0___     -> f(n-1)
 1___ -> 10__ -> f(n-2)

 f(n) = f(n-1) + f(n-2)

  */
public class WaysToFillArray {

    // memoization
    public static int countWaysToFillArrayWithMemo(int n, int [] memo) {

        if(n<=1) {
            return n+1;
        }
        if(memo[n] != 0) {

            return memo[n];
        }

       return memo[n] = countWaysToFillArrayWithMemo(n-1, memo) + countWaysToFillArrayWithMemo(n-2, memo);
    }

    static void main() {
        int n = 5;
        int [] memo = new int[n+1];
        int count = countWaysToFillArrayWithMemo(n, memo);
        System.out.println("Memoization : Number of ways to fill an array of length " + n + " with 0s and 1s such that no two 1s are adjacent: " + count);

        //tabulation
        int [] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 2;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println("Tabulation: Number of ways to fill an array of length " + n + " with 0s and 1s such that no two 1s are adjacent: " + dp[n]);
    }
}

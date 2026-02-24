package DynamicProgramming;

/*
You are given an array a[0..n-1] where a[i] is the time required to supervise on day i.

Rules:
You must work at least 1 day in every consecutive 3 days.
Goal: Minimize total work time.
*/
public class Supw {
    static int[] memo = new int[100];

    public static int find(int n, int[] a, int[] memo) {
        if(n <= 2)
          return memo[n] = a[n];

        if(memo[n] != 0) {
            return memo[n];
        }

        return memo[n] = a[n] + Math.min(find(n - 1, a, memo), Math.min(find(n - 2, a, memo), find(n - 3, a, memo)));
    }

    static void main() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int[] a = {3, 2, 1, 1, 2, 3, 1,3, 2, 1};
        int n = a.length;
        int[] dp = new int[n];
        dp[0] = a[0];
        dp[1] = a[1];
        dp[2] = a[2];

        for (int i = 3; i < n; i++) {
            dp[i] = a[i] + Math.min(dp[i - 1], Math.min(dp[i - 2], dp[i - 3]));
        }
        int minTime = Math.min(dp[n - 1], Math.min(dp[n - 2], dp[n - 3]));
        System.out.println("Minimum total time: " + minTime);

        // using memoization
        find( n-1, a, memo);

        int minTimeMemo = Math.min(memo[n - 1], Math.min(memo[n - 2], memo[n - 3]));
        System.out.println("Minimum total time using memoization: " + minTimeMemo);
    }
}

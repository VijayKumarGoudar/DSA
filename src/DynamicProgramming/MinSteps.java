package DynamicProgramming;

/*
Given an integer N, you can:
subtract 1
divide by 2 (if divisible)
divide by 3 (if divisible)

Find the minimum steps to reach 1.
 */
public class MinSteps {

    static void main() {
        int n = 10;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;

        for(int i = 3; i<=n; i++) {
            int min = dp[i-1];
            if(i%3 == 0 && dp[i/3] < min) {
                min = dp[i/3];
            }
            if(i%2 == 0 && dp[i/2] < min) {
                min = dp[i/2];
            }
            dp[i] = 1 + min;
        }
        System.out.println("Tabulation: Minimum steps to reach 1 from " + n + " is: " + dp[n]);

        // memoization
        int[] memo = new int[n+1];
        int minSteps = findMinSteps(n, memo);
        System.out.println("Memoization: Minimum steps to reach 1 from " + n + " is: " + minSteps);
    }

    public static int findMinSteps(int n, int[] memo) {
        if(n == 1 || n == 0 ) {
            return 0;
        }
        if (n ==2 ) {
            return 1;
        }

        if(memo[n] != 0) {
            return memo[n];
        }

        int min = findMinSteps(n-1, memo);
        if(n%2 == 0) {
            int steps = findMinSteps(n/2, memo);
            if(steps < min)
                min = steps;
        }

        if(n%3 == 0) {
            int steps = findMinSteps(n/3, memo);
            if(steps < min)
                min = steps;
        }

        return memo[n] = 1 + min;
    }
}

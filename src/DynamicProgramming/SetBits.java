package DynamicProgramming;

/*
Count the number of set bits in an integer n.
n = 5
0 -> 0
1 -> 1
2 -> 10
3 -> 11
4 -> 100
5 -> 101
6 -> 110
7 -> 111
8 -> 1000
9 -> 1001

dp(n) = dp(n/2) + n%2
set bits of dp(n) ==  set bits of dp(n/2) + odd(1) or even(0)
 */
public class SetBits {

    public static int countSetBits(int n, int[] dp1) {
        if(n == 0 || n == 1) {
            dp1[n] = n;
            return n;
        }

        if(dp1[n] != 0) {
            return dp1[n];
        }

        dp1[n] = countSetBits(n/2, dp1) + (n % 2);
        return dp1[n];
    }

    static void main() {
        int n = 10;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        System.out.println("Using Tabulation:");
        for (int i = 0; i <= n; i++) {
            dp[i] = dp[i / 2] + (i % 2);
            System.out.println("Number of set bits in " + i + " is: " + dp[i]);
        }

        System.out.println("Using memoization:");
        int[] dp1 = new int[n + 1];
        for (int i = n; i >= 0; i--) {
            countSetBits(n, dp1);
            System.out.println("Number of set bits in " + i + " is: " + dp1[i]);
        }
    }
}

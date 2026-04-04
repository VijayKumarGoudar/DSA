package DynamicProgramming;

public class RodCutting {



    static void main() {
        int n = 8;
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int[] dp = new int[n + 1];
        dp[0] = 0;

        int max = 0;
        int i = 1;
        while ( i<=n) {

            for(int j = 1; j<=i ; j++) {
                int val = price[j-1] + dp[i-j];
                if(val>max) {
                    max = val;
                    dp[i] = max;
                }
            }
            i++;
        }

        System.out.println("Maximum profit for rod of length " + n + " is: " + dp[n]);
    }
}

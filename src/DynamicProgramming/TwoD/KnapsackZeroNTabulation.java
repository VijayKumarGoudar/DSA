package DynamicProgramming.TwoD;

public class KnapsackZeroNTabulation {

    static void main() {
        int [] weights = {2, 3, 4};
        int [] values = {4, 5, 6};
        int capacity = 6;

        int [][] dp = new int[weights.length + 1][capacity + 1];

        for(int i =0; i<= weights.length; i++) {
            for(int j =0; j<=capacity; j++) {
                if(i == 0 || j ==0)
                    dp[i][j] = 0;
                else {
                    if(j - weights[i-1] >= 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i][j - weights[i - 1]]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        System.out.println("Value in knapsack = " + dp[weights.length][capacity]);
    }
}

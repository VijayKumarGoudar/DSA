package DynamicProgramming.TwoD;

public class KnapsackTabulation {

    static void main() {
        int [] weights = {1, 2, 3, 2, 2};
        int [] values = {8, 4, 0, 5, 3};
        int capacity = 4;

        int [][] dp = new int[weights.length + 1][capacity + 1];

        for(int i =0; i<= weights.length; i++) {
            for(int j =0; j<=capacity; j++) {
                if(i == 0 || j ==0)
                    dp[i][j] = 0;
                else {
                   if(j - weights[i-1] >= 0) {
                       dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                   } else {
                          dp[i][j] = dp[i - 1][j];
                   }
                }
            }
        }
        System.out.println("Value in knapsack = " + dp[weights.length][capacity]);
    }
}

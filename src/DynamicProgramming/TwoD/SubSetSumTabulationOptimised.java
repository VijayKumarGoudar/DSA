package DynamicProgramming.TwoD;

public class SubSetSumTabulationOptimised {


    static void main() {
        int sum = 9;
        int[] arr = {2, 7, 4, 5, 19};

        int[]dp = new int[sum + 1];

        dp[0] = 1;
        for (int i = 1; i <= arr.length ; i++) {
            for (int j = 0; j<=sum; j++) {
                if(j == 0 ) {
                    dp[j] = 1;
                } else {
                    if (j>=arr[i-1] && dp[j-arr[i-1]] == 1) {
                        dp[j] = 1;
                    }
                }
            }
        }

        if(dp[sum] == 1) {
            System.out.println("There is a subset with the given sum.");
        } else {
            System.out.println("There is no subset with the given sum.");
        }
    }

}


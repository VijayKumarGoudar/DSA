package DynamicProgramming.TwoD;

public class SubSetSumTabulation {


    static void main() {
        int sum = 31;
        int[] arr = {2, 7, 4, 5, 19};

        int[][] dp = new int[arr.length + 1][sum + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= arr.length ; i++) {
            for (int j = 0; j<=sum; j++) {
                if(j == 0 ) {
                    dp[i][j] = 1;
                } else {
                    if(dp[i-1][j] == 1) {
                        dp[i][j] = 1;
                    } else if (j>=arr[i-1] && dp[i-1][j-arr[i-1]] == 1) {
                        dp[i][j] = 1;
                    }
                }
            }
        }

        if(dp[arr.length][sum] == 1) {
            System.out.println("There is a subset with the given sum.");
        } else {
            System.out.println("There is no subset with the given sum.");
        }
    }

}


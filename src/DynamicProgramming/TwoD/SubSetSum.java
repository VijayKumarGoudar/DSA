package DynamicProgramming.TwoD;

public class SubSetSum {

    static int[][] memo = new int[100][1000];

    public static int isSubSetSum(int[] a, int i,  int sum) {

        if( memo[i][sum] != 0) {
            return memo[i][sum];
        }

        if(sum == 0)
            return 1;

        if(i == a.length )
            return -1;

        int include = 0;
        if(sum >= a[i]) {
            include = isSubSetSum(a, i + 1, sum - a[i]);
        }
        int exclude = isSubSetSum(a, i + 1, sum);
        if(include == 1 || exclude == 1) {
            memo[i][sum] = 1;
        }

        return include == 1 || exclude == 1 ? 1 : 0;
    }


    static void main() {
        int sum = 105;
        int[] arr = {2, 8, 4, 99, 19};

        int isSubSetSum = isSubSetSum(arr, 0, sum);
        if(isSubSetSum == 1) {
            System.out.println("There is a subset with the given sum.");
        } else {
            System.out.println("There is no subset with the given sum.");
        }
    }
}

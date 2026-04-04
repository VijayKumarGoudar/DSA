package DynamicProgramming.TwoD;

public class SubSetSumRepeating {
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
            include =  isSubSetSum(a, i, sum - a[i]);
        }

        int exclude = isSubSetSum(a, i + 1, sum);
        if(include == 1 || exclude == 1) {
            memo[i][sum] = 1;
        }

        return include == 1 || exclude == 1 ? 1 : 0;
    }


    static void main() {
        int sum = 298;
        int[] arr = {21, 25, 7, 99, 19};

        int isSubSetSum = isSubSetSum(arr, 0, sum);
        if(isSubSetSum == 1) {
            System.out.println("There is a subset with the given sum.");
        } else {
            System.out.println("There is no subset with the given sum.");
        }
    }
}

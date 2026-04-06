package DynamicProgramming.TwoD;

public class KnapsackZeroN {

    static int [][] memo = new int[100][1000];
    public static int knapsack(int capacity, int[] weights, int[] values, int i) {

        if(memo[i][capacity] != 0) {
            return memo[i][capacity];
        }

        if(i == weights.length || capacity == 0) {
            return 0;
        }

        //include the item
        int include = 0;
        if(weights[i] <= capacity) {
            include = knapsack(capacity - weights[i], weights, values, i) + values[i];
        }
        //exclude the item
        int exclude = knapsack(capacity, weights, values, i+1);

        return memo[i][capacity] = Math.max(include, exclude);
    }

    static void main() {
        int [] weights = {2, 3, 4};
        int [] values = {4, 5, 6};
        int capacity = 6;

        int value = knapsack(capacity, weights, values, 0);
        System.out.println("Value in knapsack = " + value);
    }
}

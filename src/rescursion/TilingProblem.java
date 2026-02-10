package rescursion;

/*You are given a 4 × N board and tiles of size 4 × 1.
Each tile covers exactly 4 consecutive cells.

Task:
Find the number of ways to completely tile the 4×N board using these 4×1 tiles.*/
public class TilingProblem {

    public static int countWays(int n) {

        if(n<=3) {
            return 1;
        }

        return countWays(n-1) + countWays(n-4);
    }

    static void main() {
        int n = 8;
        int ways = countWays(n);
        System.out.println("Number of ways to tile a 4x" + n + " board: " + ways);
    }
}

package Backtracking;

public class NQueensCount {

    static int count = 0;

    public static boolean solveNQueens(int[][] b, int i) {
        if (b.length == i) {
            // print the board and count ways
            count++;
            for (int k = 0; k < b.length; k++) {
                for(int l = 0; l < b.length; l++) {
                    System.out.print(b[k][l] + " ");
                }
                System.out.println();
            }

            System.out.println();
            return true;
        }

        for(int j = 0; j<b.length; j++) {
            if(check(b, i, j)) {
                b[i][j] = 1;
                solveNQueens(b, i + 1);
            }
            b[i][j] = 0;
        }
        return false;
    }

    public static boolean check(int[][] b, int i, int j) {
        if(i==0) {
            return true;
        }
        boolean verticallySafe = checkVertical(b, i, j);
        boolean leftDiagonallySafe = checkDiagonalLeft(b, i, j);
        boolean rightDiagonallySafe = checkDiagonalRight(b, i, j);
        return verticallySafe && leftDiagonallySafe && rightDiagonallySafe;
    }

    public static boolean checkVertical(int[][] b, int i, int j) {
        for(int k = 0; k < i; k++) {
            if(b[k][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDiagonalLeft(int[][] b, int i, int j) {
        int x = i;
        int y =j;
        while(x >= 0 && y >= 0) {
            if(b[x][y] == 1) {
                return false;
            }
            x--;
            y--;
        }
        return true;
    }

    public static boolean checkDiagonalRight(int[][] b, int i, int j) {
        int x = i;
        int y = j;

        while(x >= 0 && y < b.length) {
            if(b[x][y] == 1) {
                return false;
            }
            x--;
            y++;
        }
        return true;
    }

    static void main() {
        int n = 8;
        int[][] board = new int[n][n];
        solveNQueens(board, 0);
        System.out.println("Total number of solutions: " + count);
    }
}

package Backtracking;

public class Sudoku {

    public static boolean solveSudoku(int[][] board, int i, int j) {

        if(i == board.length) {
            return true;
        }

        if(j == board[0].length) {
            return solveSudoku(board, i + 1, 0);
        }

        if(board[i][j] != 0) {
            return solveSudoku(board, i, j + 1);
        }

        for (int n = 1; n <=9; n++) {
            if(isSafe(board, i, j, n)) {
                board[i][j] = n;
                boolean solved = solveSudoku(board, i, j + 1);
                if(solved) {
                    return true;
                }
            }

        }
        board[i][j] = 0;
        return false;
    }

    public static boolean isSafe(int[][] board, int i, int j, int n) {
        for(int k = 0; k<board.length; k++) {
            if(board[i][k] == n || board[k][j] == n) {
                return false;
            }
        }

        int x = (i/3)*3;
        int y = (j/3)*3;

        for (int p = x; p < x + 3; p++) {
            for(int q = y; q < y + 3; q++) {
                if(board[p][q] == n) {
                    return false;
                }
            }
        }
        return true;
    }

    static void main() {
        int[][] board = {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
        };

        boolean isSolved = solveSudoku(board, 0, 0);
        if(isSolved) {
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
       } else {
            System.out.println("No solution exists");
        }
    }
}

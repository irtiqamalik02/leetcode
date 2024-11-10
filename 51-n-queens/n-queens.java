import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return solveNQueensByBacktracking(0, board);
    }

    List<List<String>> solveNQueensByBacktracking(int row, boolean[][] board) {
        // Base case: If we've placed queens in all rows, store the board configuration
        if (row == board.length) {
            List<String> ans = new ArrayList<>();
            for (boolean[] arr : board) {
                StringBuilder sb = new StringBuilder();
                for (boolean b : arr) {
                    sb.append(b ? "Q" : ".");
                }
                ans.add(sb.toString());
            }
            List<List<String>> singleSolution = new ArrayList<>();
            singleSolution.add(ans);
            return singleSolution;
        }

        List<List<String>> result = new ArrayList<>();
        // Try placing a queen in each column of the current row
        for (int c = 0; c < board[0].length; c++) {
            if (isSafe(board, row, c)) {
                // Place queen and move to the next row
                board[row][c] = true;
                result.addAll(solveNQueensByBacktracking(row + 1, board));
                board[row][c] = false; // Backtrack: remove the queen
            }
        }
        return result;
    }

    private boolean isSafe(boolean[][] board, int r, int c) {
        // Check column for any queen placements
        for (int i = 0; i < r; i++) {
            if (board[i][c]) {
                return false;
            }
        }

        // Check left diagonal for any queen placements
        for (int i = 1; r - i >= 0 && c - i >= 0; i++) {
            if (board[r - i][c - i]) {
                return false;
            }
        }

        // Check right diagonal for any queen placements
        for (int i = 1; r - i >= 0 && c + i < board.length; i++) {
            if (board[r - i][c + i]) {
                return false;
            }
        }

        return true; // No conflicts
    }
}

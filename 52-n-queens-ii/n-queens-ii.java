class Solution {
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return totalNQueensUsingBacktracking(0, board);
    }

    public int totalNQueensUsingBacktracking(int row, boolean[][] board) {
        int count = 0;
        if(row == board.length){
            return 1;
        }

        for(int c=0; c< board[0].length; c++){
            if(isSafe(row,c,board)){
                board[row][c] = true;
                count += totalNQueensUsingBacktracking(row+1, board);
                board[row][c] = false;
            }
        }
        return count;
    }

    public boolean isSafe(int row, int col, boolean[][] board) {
        // check for col
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // check for right diagonal

        for (int i = 1; row - i >= 0 && col + i < board.length; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }

        // check for left diagonal
        for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isSudoku(board, 0, 0);
    }

    boolean isSudoku(char[][] board, int r, int c) {
        if (r == board.length) {
            return true;
        }

        if (c > board[0].length - 1) {
            return isSudoku(board, r + 1, 0);
        }

        if (board[r][c] == '.') { // skip cell
            return isSudoku(board, r, c + 1);
        }

        if (board[r][c] != '.') {
            // extract number and verify;
            // if okay fine otherwsie retunr false;
            // int num = board[r][c] - '0';
            if (isCorrect(board, r, c)) {
                return isSudoku(board, r, c + 1);
            } else {
                return false;
            }

        }

        return true;

    }

    boolean isCorrect(char[][] board, int r, int c) {
        char num = board[r][c];

        // Check row
        for (int i = 0; i < board.length; i++) {
            if (i != c && board[r][i] == num) { // exclude current cell
                return false;
            }
        }

        // Check column
        for (int i = 0; i < board.length; i++) {
            if (i != r && board[i][c] == num) { // exclude current cell
                return false;
            }
        }

        // Check 3x3 subgrid
        int sqrt = (int) Math.sqrt(board.length);
        int startRow = r - r % sqrt;
        int startCol = c - c % sqrt;

        for (int i = startRow; i < startRow + sqrt; i++) {
            for (int j = startCol; j < startCol + sqrt; j++) {
                if ((i != r || j != c) && board[i][j] == num) { // exclude current cell
                    return false;
                }
            }
        }

        return true;
    }
}
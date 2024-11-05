class Solution {
    public void solveSudoku(char[][] board) {
   
        sudoku(board,0,0);
    }

    private boolean sudoku(char[][] board, int r, int c) {
        
        // Base case: if we've passed the last row, the board is solved.
        if (r == 9) {
            System.out.println(Arrays.deepToString(board));
            return true;
        }

        // If we reach the end of a row, move to the next row.
        if (c == 9) {
            return sudoku(board, r + 1, 0);
        }

        // If the cell is already filled, skip it.
        if (board[r][c] != '.') {
            return sudoku(board, r, c + 1);
        }
        
        for(int i = 1; i <= 9; i++){
            char num = (char)(i + '0');
            if(isSafe(board,r,c,num)){
                board[r][c] = num;
                if(sudoku(board,r,c+1)){
                    return true;
                }else{
                  board[r][c] = '.';
                }
               
            }

        }
        return false;
    }

    private boolean isSafe(char[][] board, int r, int c, char ch) {
        
        //should not be present in same row 
        for(int i = 0; i<9 ;i++){
            if(board[i][c] == ch){
                return false;
            }}
        
        
        //should not be present in same col
        for(int i = 0; i<9 ;i++){
                if(board[r][i] == ch){
                return false;
                }
            }
        
        // check for the 3 x 3 square 
        int sqrt =(int) Math.sqrt(board.length);
        int startRow = r - r % sqrt;
        int startCol = c - c % sqrt;

        for(int i = startRow; i< startRow + sqrt; i++){
            for (int j = startCol; j < startCol + sqrt ; j++){
                if(board[i][j] == ch){
                    return false;
                }
            }
        }

        return true;
    }
      
    
    // row - row % 3 => starting cell of the 
    // col - col % 3 => starting cell of the 
}

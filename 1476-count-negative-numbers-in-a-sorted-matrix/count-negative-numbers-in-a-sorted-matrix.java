class Solution {
    public int countNegatives(int[][] grid) {
        // do BS in decreasing matrix 
        int rows = grid.length;
        
        int row = 0;
        int col = grid[0].length-1;

        int count =0;
        while(col >= 0 && row < rows){
            
            //try reducing search space
            if(grid[row][col]< 0){
                //take count of col as it is decresing row and col wise and remove that from search space
                count += rows-row;
                col--;

            }
            else{
                //num is positive so all prev will be +ve only, eliminate those
                row++;
            }
            
        } 
        return count;
    }
}
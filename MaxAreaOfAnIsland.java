import java.util.Arrays;

class Solution {

    private int maxVal = 0;
    private int currentVal =0;
    private int rows =0, cols= 0 ;
    private int filled[][];
    public int maxAreaOfIsland(int[][] grid) {

        rows = grid.length;
        cols = grid[0].length;
        filled= new int[rows][cols];
        // Arrays.fill(filled, 0);
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                filled[i][j] =0;
            }
        }

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {

                if(filled[i][j] == 1){continue;}

                int value = checkPixel(grid, i,j);
                if(value>maxVal) { maxVal = value; }
                currentVal = 0;
            }
        }

        return maxVal;
    }

    private boolean checkEdge(int i, int j){

        if (i<0 || i==rows || j<0 || j==cols){
            return true;
        }else{
            return false;
        }
    }

    private int checkPixel(int[][] grid, int i, int j){

        if(filled[i][j] == 1){
            return 0;
        }

        if(checkEdge(i,j)){
            return 0;
        }

        if( grid[i][j]==1){
            filled[i][j]=1;
            return currentVal + 1 + checkPixel(grid,i,j+1) + checkPixel(grid,i,j-1)+ checkPixel(grid,i+1,j)+ checkPixel(grid,i-1,j);
        }else if( grid[i][j]==0){
            filled[i][j]=1;
            return 0;
        }

        return 0;

    }

}
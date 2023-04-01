class Solution {
    public int minPathSum(int[][] grid) {
        int[][] min = new int[grid.length][grid[0].length];
        int rows = grid.length;
        int columns = grid[0].length;
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < columns; j++) {
                if (i == 0 && j != 0) {
                    min[i][j] = min[i][j-1] + grid[i][j];
                    continue;
                }
                else if (i == 0 && j == 0) {
                    min[i][j] = grid[i][j];
                    continue;
                }
                else if (i != 0 && j == 0) {
                    min[i][j] = min[i-1][j] + grid[i][j];
                    continue;
                }
                int min1 = (valid(i, j-1, rows, columns)) ? min[i][j-1] : 0;
                int min2 = (valid(i-1, j, rows, columns)) ? min[i-1][j] : 0;
                min[i][j] = Math.min(min1, min2) + grid[i][j];
            }
        }
        return min[rows-1][columns-1];
    }
    
    private static boolean valid(int i, int j, int rows, int columns) {
        if (i >= rows || i < 0 || j >= columns || j < 0)    return false;
        return true;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int counter = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] arr = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    counter += 1;
                    guide(i, j, counter, grid, arr, rows, columns);
                }        
            }
        }
        int max = 0;
        for (int[] i : arr) {
            for (int  j : i) {
                max = Math.max(max, j);
            }
        }
        return max;
    }
    
    private static void guide(int i, int j, int counter, char[][] grid, int[][] arr, int rows, int columns) {
        grid[i][j] = '#';
        arr[i][j] = counter;
        if (valid(i-1, j, rows, columns) && grid[i-1][j] == '1') {
            guide(i-1, j, counter, grid, arr, rows, columns);
        }
        if (valid(i+1,j, rows, columns) && grid[i+1][j] == '1') {
            guide(i+1, j, counter, grid, arr, rows, columns);
        }
        if (valid(i, j-1, rows, columns) && grid[i][j-1] == '1') {
            guide(i, j-1, counter, grid, arr, rows, columns);
        }
        if (valid(i, j+1, rows, columns) && grid[i][j+1] == '1') {
            guide(i, j+1, counter, grid, arr, rows, columns);
        }
    }
    
    private static boolean valid(int x, int y,  int rows, int columns) {
        if (x < 0 || x >= rows || y < 0 || y >= columns) return false;
        return true;
    }
}
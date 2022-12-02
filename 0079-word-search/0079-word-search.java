class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        boolean[][] visited = new boolean[rows][columns];
        for (boolean[] arr : visited) {
            Arrays.fill(arr, false);
        }
        boolean found = false;
        for (int i = 0; i < rows && !found; i++) {
            for (int j = 0; j < columns && !found; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    found = check(board, visited, rows, columns, i, j, 1, word);
                    visited[i][j] = false;
                }
            }
        }
        return found;
    }
    private static boolean check(char[][] arr, boolean[][] visited, int rows, int columns, int currentRow, int currentColumn, int index, String word ) {
        if (index == word.length()) {
            return true;
        }
        boolean found = false;
        if (valid(currentRow, currentColumn + 1, rows, columns) && !visited[currentRow][currentColumn + 1] && arr[currentRow][currentColumn + 1] == word.charAt(index)) {
            visited[currentRow][currentColumn + 1] = true;
            found = check(arr, visited, rows, columns, currentRow, currentColumn + 1, index + 1, word);
            visited[currentRow][currentColumn + 1] = false;
        }
        if (!found && valid(currentRow + 1, currentColumn, rows, columns) && !visited[currentRow + 1][currentColumn] && arr[currentRow + 1][currentColumn] == word.charAt(index)) {
            visited[currentRow + 1][currentColumn] = true;
            found = check(arr, visited, rows, columns, currentRow + 1, currentColumn, index + 1, word);
            visited[currentRow + 1][currentColumn] = false;
        }
        if (!found && valid(currentRow - 1, currentColumn, rows, columns) && !visited[currentRow - 1][currentColumn] && arr[currentRow - 1][currentColumn] == word.charAt(index)) {
            visited[currentRow - 1][currentColumn] = true;
            found = check(arr, visited, rows, columns, currentRow - 1, currentColumn, index + 1, word);
            visited[currentRow - 1][currentColumn] = false;
        }
        if (!found && valid(currentRow, currentColumn - 1, rows, columns) && !visited[currentRow][currentColumn - 1] && arr[currentRow][currentColumn - 1] == word.charAt(index)) {
            visited[currentRow][currentColumn - 1] = true;
            found = check(arr, visited, rows, columns, currentRow, currentColumn - 1, index + 1, word);
            visited[currentRow][currentColumn - 1] = false;
        }
        return found;
    }
    private static boolean valid(int currentRow, int currentColumn, int rows, int column) {
        if (currentRow < 0 || currentRow >= rows)   return false;
        if (currentColumn < 0 || currentColumn >= column)   return false;
        return true;
    }
}
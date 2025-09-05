class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }
    
    private boolean backtrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            
                            if (backtrack(board)) {
                                return true;
                            }
                            
                            board[i][j] = '.'; // 回溯
                        }
                    }
                    return false; // 沒有數字可以填，返回 false
                }
            }
        }
        return true; // 全部填完了
    }
    
    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int k = 0; k < 9; k++) {
            if (board[row][k] == c) return false; // 檢查 row
            if (board[k][col] == c) return false; // 檢查 col
            int boxRow = (row / 3) * 3 + k / 3;
            int boxCol = (col / 3) * 3 + k % 3;
            if (board[boxRow][boxCol] == c) return false; // 檢查 box
        }
        return true;
    }
}

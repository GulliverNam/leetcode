class Solution {
    
    boolean[][] columnCheck = new boolean[9][11];
    boolean[][] rowCheck = new boolean[9][11];
    boolean[][] squareCheck = new boolean[9][11];
    
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    if(columnCheck[i][num]){
                        return false;
                    }
                    columnCheck[i][num] = true;
                    if(rowCheck[j][num]){
                        return false;
                    }
                    rowCheck[j][num] = true;
                    if(squareCheck[i/3*3+j/3][num]){
                        return false;
                    }
                    squareCheck[i/3*3+j/3][num] = true;
                }
                
            }
        }
        return true;
    }
    
}
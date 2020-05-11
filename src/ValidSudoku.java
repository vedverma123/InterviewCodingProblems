public class ValidSudoku {
   public boolean isValidSudoku(char[][] board) {
      for(int i =0; i < 9; i ++){
         for (int j =0; j < 9; j ++){
            if(board[i][j] != '.'){
               if(checkIfDuplicate(board, i, j)){
                  return false;
               }
            }
         }
      }
      return true;
   }

   public boolean checkIfDuplicate(char[][] board , int i, int j){

      for(int k =i; k <= i; k ++){
         for (int l =0; l < 9; l ++){
            if(j != l && board[k][l] != '.' && board[i][j] == board[k][l])
               return true;
         }
      }
      for(int k = 0; k <9 ; k ++){
         for (int l = 0; l <= j; l++){
            if(i != k && board[k][l] != '.' && board[i][j] == board[k][l])
               return true;
         }
      }
      return false;
   }

   public static void main(String[] args) {
      ValidSudoku obj = new ValidSudoku();
      char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
      System.out.println(obj.isValidSudoku(board));

   }
}

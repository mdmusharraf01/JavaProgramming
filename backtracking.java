/*public class backtracking {
    /*public static void main(String[] args) {
        int sudoku[][] =  {
            {5, 3, 0,  0, 7, 0,  0, 0, 0},
            {6, 0, 0,  1, 9, 5,  0, 0, 0},
            {0, 9, 8,  0, 0, 0,  0, 6, 0},

            {8, 0, 0,  0, 6, 0,  0, 0, 3},
            {4, 0, 0,  8, 0, 3,  0, 0, 1},
            {7, 0, 0,  0, 2, 0,  0, 0, 6},

            {0, 6, 0,  0, 0, 0,  2, 8, 0},
            {0, 0, 0,  4, 1, 9,  0, 0, 5},
            {0, 0, 0,  0, 8, 0,  0, 7, 9}
        };
        if(sudokuSolver(sudoku, 0, 0)){
            System.out.println("solution exist");
            printSudoku(sudoku);
        }else{
            System.out.println("doesnt exist");
        }*/
        /*int n = 3 , m = 3;//grid ways
        System.out.println(gridWays(0, 0, n, m));*/
        /*int n = 4;//nQueens
        char board[][] = new char[n][n];
        //initialize
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = 'x';
            }
        }
        if(nQueens(board, 0)){
            System.out.println("solution is possible");
            printBoard(board);
        }else{
            System.out.println("solution is not possible");
        }
    }*/
    /*public static void printArr(int arr[]){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void changeArray(int arr[], int i, int val){
        if(i == arr.length){
            printArr(arr);
            return;
        }
        arr[i]= val;
        changeArray(arr, i+1, val+1);
        arr[i]= arr[i]-2;
    }
    public static void findSubsets(String str, String ans , int i){
        if(i == str.length()){
            System.out.println(ans);
            return;
        }
        findSubsets(str, ans + str.charAt(i), i+1);
        findSubsets(str, ans, i+1);
    }*/
    /*public static void findPermutation(String str , String ans){
        //base case 
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        //recursion
        for(int i=0; i<str.length(); i++){
            char curr = str.charAt(i);
            //abcde => ab + de = abde
            String Newstr = str.substring(0,i) + str.substring(i+1);
            findPermutation(Newstr, ans+curr);
        }
    }*/
    /*public static boolean isSafe(char board[][], int row , int col){
        //vertical up 
        for(int i = row-1; i>=0; i--){
            if(board[i][col]=='q'){
                return false;
            }
        }
        //daignol left up
        for(int i = row-1 , j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j]=='q'){
                return false;
            }
        }
        //daignol right up
        for(int i=row-1, j = col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j]=='q'){
                return false;
            }
        }
        return true;
    }*/
    /*public static void nQueens(char board[][], int row){
        //base case 
        if(row == board.length){
            //printBoard(board);
            count ++;
            return;
        }
        //column loop 
        for(int j=0; j<board.length; j++){
            if(isSafe(board , row, j)){
                board[row][j] = 'q' ;
            nQueens(board, row+1);//function call
            board[row][j] = 'x';//backtracing step
            }
        }
    }*/
    /*public static boolean  nQueens(char board[][], int row){
        //base case 
        if(row == board.length){
            //printBoard(board);
            count ++;
            return true;
        }
        //column loop 
        for(int j=0; j<board.length; j++){
            if(isSafe(board , row, j)){
                board[row][j] = 'q' ;
            if(nQueens(board, row+1)){
                return true;
            }//function call
            board[row][j] = 'x';//backtracing step
            }
        }
        return false;
    }*/
    /*static int count = 0;
    public static void printBoard(char board[][]){
        System.out.println("--------chessboard--------");
        for(int i = 0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }*/
    /*public static int gridWays(int i, int j, int n, int m){
        //base case
        if(i == n-1 && j == m-1){
            return 1;
        }else if(i == n || j == m){
            return 0;
        }
        //kaam
        int w1 = gridWays(i+1, j, n, m);
        int w2 = gridWays(i, j+1, n, m);
        return w1 + w2;
    }
    public static boolean isSafe(int sudoku[][], int row, int col, int digit){
        //row 
        for(int i=0; i<9; i++){
            if(sudoku[i][col] == digit){
                return false;
            }
        }
        //column
        for(int j=0; j<9; j++){
            if(sudoku[row][j] == digit){
                return false;
            }
        }
        //subgrid
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        //3*3
        for(int i=sr; i<sr+3; i++){
            for(int j=sc; j<sc+3; j++){
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean sudokuSolver(int sudoku[][], int row , int col){
        //base case
        if(row == 9 ){
            return true;
        }
        //recursion
        int nextRow = row , nextCol = col+1;
        if(col+1 == 9){
            nextRow = row+1;
            nextCol = 0;
        }
        //kaam
        if(sudoku[row][col] != 0 ){
            return sudokuSolver(sudoku, nextRow, nextCol);
        }
        for(int digit = 1; digit<=9; digit++){
            if(isSafe(sudoku, row, col, digit)){
                sudoku[row][col] = digit;
                if(sudokuSolver(sudoku, nextRow, nextCol)){
                    return true; 
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }
    public static void printSudoku(int sudoku[][]){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.println(sudoku[i][j] + " ");
            } 
        }
    }
}*/
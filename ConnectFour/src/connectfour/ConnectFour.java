/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import static java.lang.Math.random;

/**
 *
 * @author Justin
 */
public class ConnectFour {

    public static char[][] createBoard(char vStartChar){
        char[][] gameBoard = new char[6][7];
        
        if ((vStartChar == 'y') || (vStartChar == 'r') || (vStartChar == 'b')){
            for (int i = 0; i < gameBoard.length; i++){
                for (int j = 0; j < gameBoard[i].length; j++){
                    gameBoard[i][j] = vStartChar;
                }
            }
        } else {
            System.out.println("Invalid value passed to createBoard.");
        }
        
        return gameBoard;
    }
    
    public static void printBoard(char[][] vGameBoard){
        System.out.println("-----------------");
        for (char[] row: vGameBoard){
            System.out.print("| ");
            for(char value: row){
                System.out.print(value + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("-----------------");
    }
    
    public static int randInt(int minVal, int maxVal){
        double value = random();
        
        maxVal += 1;
        
        double returnVal = (value) * (maxVal - minVal);
        returnVal /= (1);
        returnVal += minVal;
        
        return (int)(returnVal);
    }
    
    public static void takeTurn(char vColor, char[][] gameBoard){
        if ((vColor == 'y') || (vColor == 'r')){
            boolean placed = false;
            int column = 0;

            while (!placed){
                column = randInt(0, 6);
                // System.out.println("Column: " + (column + 1));
                for (int row = gameBoard.length - 1; row > -1; row--){
                    if (gameBoard[row][column] == 'b'){
                        gameBoard[row][column] = vColor;
                        placed = true;
                        break;
                    }
                }
            }
        } else{
            System.out.println("Invalid Color passed to takeTurn");
        }
    }
    
    public static char playGame(char[][] vGameBoard){
        // Player 1 if true, Player 2 if false
        // boolean currentTurn = true;
        
        char currPlayer = 'y';
        char winner = 't';
        int turns = 0;
        int maxTurns = vGameBoard.length * vGameBoard[0].length;
        boolean playerWon = false;
        
        while (turns < maxTurns && playerWon == false){
            takeTurn(currPlayer, vGameBoard);
            printBoard(vGameBoard);
            
            if (checkRows(currPlayer, vGameBoard) || checkCols(currPlayer, vGameBoard)){
                playerWon = true;
                return currPlayer;
            }
            
            if (currPlayer == 'y'){
                currPlayer = 'r';
            } else{
                currPlayer = 'y';
            }
            
            turns++;
        }
        return 't';
    }
    
    public static boolean checkRows(char vColor, char[][] vGameBoard){
        int count = 0;
        
        for (char[] row: vGameBoard){
            count = 0;
            for (char color: row){
                if (color == vColor){
                    count++;
                    if (count == 4){
                        return true;
                    }
                } else{
                    count = 0;
                }
            }
        }
        return false;
    }
    
    public static boolean checkCols(char vColor, char[][] vGameBoard){
        int count = 0;
        
        for (int column = 0; column < vGameBoard[0].length; column++){
            count = 0;
            for (int row = 0; row < vGameBoard.length; row++){
                if (vGameBoard[row][column] == vColor){
                    count++;
                    if (count == 4){
                        
                        return true;
                        
                    }
                } else{
                    count = 0;
                }
            }
        }
        return false;
    }
    
    public static boolean checkDiagnols(char vColor, char[][]vGameBoard){
        return true;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        char[][] gameBoard = createBoard('b');
        printBoard(gameBoard);
        System.out.println(playGame(gameBoard);
            
        
    }
    
}

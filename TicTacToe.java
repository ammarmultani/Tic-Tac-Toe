// Ammar Multani
// CS 2336.0U1
// Final Project

//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.util.Scanner;


//public class Board{
//    char[][] myArray = new char[3][3];
//
//}
//public class Cell{
//    public int row;
//    public int col;
//}
//
//public class Game{
//    
//    public void initiate();
//}

public class TicTacToe {
    
    public static void main(String[] args) {
        
        // multidimensional array given its size, a 3x3 matrix
        char[][] myArray = new char[3][3];
                
        // declaring the sign for the player
        char forPlayer1 = 'X';
        char forPlayer2 = 'O';
        
        // declaring the variables
        int firstPosition = 0, secondPosition = 0;
        int player = 1;
        int pos1 = 0, pos2 = 0;
        
        
        
        
        // for loop granting the number of turns and position
        for (int i = 0; i < 9; i++){
            int a = 0;
            
            // asks user to enter position
            Scanner input = new Scanner(System.in);
            while (a == 0) {
               System.out.println("Player " + player + " enter your first position: ");
               firstPosition = input.nextInt();
               
               if (firstPosition > 3) {
                    System.out.println("value of position 1 should be less than 3.");

                    a = 0;
               }
              
               else
                   a = 1;
            }
             
            a = 0;
            firstPosition = firstPosition - 1;
            
            // prints the position matrix (row, column)
            System.out.println("pos1 " + firstPosition);
            
            
            while (a == 0) {
               System.out.println("Player " + player + " enter your second position: ");
               secondPosition = input.nextInt();
               
                if (secondPosition > 3) {
                    System.out.println("value of position 2 should be less than 3.");

                    a = 0;                    
               }
                
                else
                    a = 1;
            }
             
            secondPosition = secondPosition - 1;
        
       
            System.out.println("pos2 " + secondPosition);
            
            
            if(myArray[firstPosition][secondPosition] == 'X' || myArray[firstPosition][secondPosition] == 'O'){
                --i;
                System.out.println("already selected!!");
                continue;
            }
            
            
            if (player == 1) {
                myArray[firstPosition][secondPosition] = forPlayer1;
            }
            
            else    
                myArray[firstPosition][secondPosition] = forPlayer2;
        
            if (player == 1)
                player = 2;

            else
                player = 1;
        
            
            
            //check if winner
            boolean isWinner = (new TicTacToe()).checkIfWinner(myArray);
            if(isWinner){
                System.out.println("We found a winner: player"+player);
                System.exit(0);
            }
            
            //  check if draw
            boolean isDraw = !isWinner && i >= 8;
            if(isDraw){
                System.out.println("Its a draw match!!");
                System.exit(0);
            }
            
            //print board
            (new TicTacToe()).displayBoard(myArray);
            
        }
        
      

    }
    
    public void changeBoard(char player, int row, int column) {
        
        //table[row][column] = player;

    }

    
    
    public void displayBoard(char[][] table) {

        System.out.println("  0  " + table[0][0] + "|" + table[0][1] + "|" + table[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  1  " + table[1][0] + "|" + table[1][1] + "|" + table[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + table[2][0] + "|" + table[2][1] + "|" + table[2][2]);
        System.out.println("     0 1 2 ");    
    
}
    
    
    public boolean checkIfWinner(char[][] table) {
        
        int xCount = 0;
        int oCount = 0;
        
     
        
        if (table[0][0] == table[1][0] && table[1][0] == table[2][0] && (table[0][0] == 'X' || table[0][0] == 'O')) {
            return true;
        } else if (table[0][1] == table[1][1] && table[1][1] == table[2][1] && (table[0][1] == 'X' || table[0][1] == 'O')) {
            return true;
        } else if (table[0][2] == table[1][2] && table[1][2] == table[2][2] && (table[0][2] == 'X' || table[0][2] == 'O')) {
            return true;
        } else if (table[0][0] == table[0][1] && table[0][1] == table[0][2] && (table[0][0] == 'X' || table[0][0] == 'O')) {
            return true;
        } else if (table[1][0] == table[1][1] && table[1][1] == table[1][2] && (table[1][0] == 'X' || table[1][0] == 'O')) {
            return true;
        } else if (table[2][0] == table[2][1] && table[2][1] == table[2][2] && (table[2][0] == 'X' || table[2][0] == 'O')) {
            return true;
        } else if (table[0][0] == table[1][1] && table[1][1] == table[2][2] && (table[0][0] == 'X' || table[0][0] == 'O')) {
            return true;
        } else if (table[2][0] == table[1][1] && table[1][1] == table[0][2] && (table[2][0] == 'X' || table[2][0] == 'O')) {
            return true;
        } else {
            return false;
        }
    }


    public boolean checkIfTie(char[][] table) {
        for (int i = 0; i < 3; i++) {
            for (int p = 0; p < 3; p++) {
                if (table[i][p] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }


}

    

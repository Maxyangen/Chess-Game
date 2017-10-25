import java.lang.Math;
import java.util.*;
public class RandomChess
{
    int[] TotalChess = new int[32];
    int[] BlackChess= new int[16];
    int[] RedChess = new int[16];
    int[][] BoardChess =new int[4][8];
    int[][] ChessWeight = new int[4][8];
    private boolean[] BlackCheck = new boolean[16];
    private boolean[] RedCheck = new boolean[16];
    private int r1 , r2;
    private int i , j;
    
    public RandomChess() {
        TotalChess();
        RandomChess();
       
    }
    public void TotalChess(){
        for(i = 0; i < 32; i++)
            TotalChess[i] = i;
    }
    public void RandomChess(){   //給棋子位子阿沒很大阿　晚安
        for(i = 0; i < 60 ; i++)
            {
            r1 = (int)(new Random().nextInt(32));
            r2 = (int)(new Random().nextInt(32));
             int tmp = TotalChess[r1];  
             TotalChess[r1] = TotalChess[r2];  
             TotalChess[r2] = tmp; 
            
            }
        /*for(i=0;i<32;i++)
            System.out.println(TotalChess[i]);*/
    }
    public int[][] InBoard(){
        int x = 0;
        for (i = 0; i < 4; i++)
            for ( j = 0; j < 8; j++)
                BoardChess[i][j] = TotalChess[x++];
        return BoardChess;   
    }
    public int[][] weight(){
        for (i = 0; i < 4; i++)
            for ( j = 0; j < 8; j++){
                if(BoardChess[i][j] == 0 || BoardChess[i][j] == 16)
                    ChessWeight[i][j] = 0;
                else if(BoardChess[i][j] == 1 || BoardChess[i][j] == 2 ||BoardChess[i][j] == 17 ||BoardChess[i][j] == 18)
                    ChessWeight[i][j] = 1;
                else if(BoardChess[i][j] == 3 || BoardChess[i][j] == 4 ||BoardChess[i][j] == 19 ||BoardChess[i][j] == 20)
                    ChessWeight[i][j] = 2;
                else if(BoardChess[i][j] == 5 || BoardChess[i][j] == 6 ||BoardChess[i][j] == 21 ||BoardChess[i][j] == 22)
                    ChessWeight[i][j] = 3;
                else if(BoardChess[i][j] == 7 || BoardChess[i][j] == 8 ||BoardChess[i][j] == 23 ||BoardChess[i][j] == 24)
                    ChessWeight[i][j] = 4;
                else if(BoardChess[i][j] == 9 || BoardChess[i][j] == 10 ||BoardChess[i][j] == 25 ||BoardChess[i][j] == 26)
                    ChessWeight[i][j] = 5;
                else if(BoardChess[i][j] >= 11 && BoardChess[i][j] < 16 || BoardChess[i][j] >= 27 && BoardChess[i][j] <32)
                    ChessWeight[i][j] = 6;
            }
        return ChessWeight;
        
    }
  
   
}

public class Crash extends ActionDecorator
{
 
  private int[][] bd = new int[4][8];
  private int[][] bdw = new int[4][8];
  private int i , j , chessx , chessy ;
  private boolean canmove , can ;
  public Crash (ChessAction chessac){
      super(chessac);
    }
  public boolean canMove(Chess chess , int movex ,int movey){
      bd = chessboard.getBoard();
      bdw = chessboard.getWeight();
      chessx = chess.getChessX();
      chessy = chess.getChessY();
      
     if ( chessx == movex  || chessy == movey ){
        if(chessy > movey){
            for ( i = chessy ; i > movey; i--)
                if(bd[chessx][i] != 33)
                    canmove = false;
           canmove = true;
        }
        else if (chessy < movey){
            for ( i = chessy ; i < movey; i++)
                if(bd[chessx][i] !=33)
                    canmove = false;
           canmove =true; 
        }
        else if (chessx > movex){
            for ( i = chessx ; i > movex; i--)
                if(bd[i][chessy] != 33)
                    canmove = false;
            canmove = true;
        }
        else if (chessx < movex){
            for ( i = chessx ; i < movex; i++)
                if(bd[i][chessy] != 33)
                    canmove = false;
            canmove = true;
        }
    }
     else
        canmove = false;
        
     if(canmove == true){
        if(bd[chessx][chessy] < 16 && bd[movex][movey] <16)    //同色
            can = false;
        else if( (bd[chessx][chessy] > 15 && bd[chessx][chessy] <32) && (bd[movex][movey] >15 && bd[movex][movey] <32) ) //同色
            can = false;
        else if( bd[chessx][chessy] <16 && ( bd[movex][movey] >15 &&bd[movex][movey]<32 ) ){ //異色   能不能吃
            if( bdw[chessx][chessy] <= bdw[movex][movey] )
                can = true;
        }
       else if( ( bd[chessx][chessy] >15 &&  bd[chessx][chessy]<32 ) && bd[movex][movey] <16  ){ //異色   能不能吃
            if( bdw[chessx][chessy] <= bdw[movex][movey] )
                can = true;
            else
                can = false;
        }        
     }
     else can = false;
      return can ;
  }
      
}


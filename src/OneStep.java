public class OneStep extends ChessAction
{
  //private ChessBoard chessboard = ChessBoard.getChessBoard();
  private int[][] bd = new int[4][8];
  private int[][] bdw = new int[4][8];
  private int i , j , chessx , chessy;
  private boolean canmove,can;
  public OneStep(){
     // System.out.println("test");
  }
  public boolean canMove(Chess chess , int movex ,int movey){
      bd = chessboard.getBoard(); //真猛
      bdw = chessboard.getWeight();
      //差一點點
      chessx = chess.getChessX();
      chessy = chess.getChessY();
     /*for (int i = 0 ; i<4; i ++){
        for (int j = 0 ; j < 8; j++)
            System.out.print(bdw[i][j] + " ");
        System.out.println();
      }*/
      System.out.print(chessboard.getChessweight(chessx,chessy));
      System.out.print(chessboard.getChessweight(movex,movey));
       if (Math.abs(chessx - movex) <= 1 && Math.abs(chessy - movey) <= 1) //看是不是在上下左右1格
        canmove = true;
        else 
        canmove = false;
      if (canmove == true){ //是1格   
        if(bd[chessx][chessy] < 16 && bd[movex][movey] <16)    //同色
            can = false;
        else if( (bd[chessx][chessy] > 15 && bd[chessx][chessy] <32) && (bd[movex][movey] >15 && bd[movex][movey] <32) ) //同色
            can = false;
        else if(bd[chessx][chessy] <16 && ( bd[movex][movey] >15 &&bd[movex][movey]<32 ) ){ //異色   能不能吃
            if(chessboard.getChessweight(chessx,chessy) <= chessboard.getChessweight(movex,movey)) 
                can = true;
            else
                can = false;
        }
        else if( ( bd[chessx][chessy]>15 &&  bd[chessx][chessy]<32 ) && bd[movex][movey] <16  ){ //異色   能不能吃
            if(chessboard.getChessweight(chessx,chessy) <= chessboard.getChessweight(movex,movey) )
                can = true;
            else
                can = false;
        
        }    
        
      }
      else can = false;
      
      return can;  //異色能不能吃
  }
}

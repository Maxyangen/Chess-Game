import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ChessBoard{
    private static ChessBoard instance ;
    private Chess[][] chesses = new Chess[4][8];
    private Chess focussedChess;
    private Dimension focussedDimension;
    private ChessAction chess;
    private ImageIcon img;
    private PlayerEnum player;
    private int who=0,sum=0,eat=0,tot = 0;
    private int i , j ;
    private static int count = 0;
    private boolean check,which,Eat,canmove = false;
    private int[][] board = new int[4][8];
    private int[][] weight = new int[4][8];
    private ImageIcon[] chessIcon = new ImageIcon[32];
    private ImageIcon[] chessChoiceIcon = new ImageIcon[32];
    RandomChess rd = new RandomChess();

    private ChessBoard(){  
        //instance = new ChessBoard();
        System.out.println("ChessBoardFuck");
        board = rd.InBoard(); 
        weight = rd.weight();
        
        setChess(new StdChessFactory());
    }
    
    public static ChessBoard getChessBoard(){
        //System.out.println("test");
        if (instance == null){
            instance = new ChessBoard();
        }
        return instance;
    }
    
    public void setChess(ChessFactory cf){
        //ChessFactory bbpp = new StdChessFactory();
        for( i = 0;i < 4;i++){
            for ( j = 0;j < 8;j++){
                if(board[i][j] < 16){
                    setChessFactory(cf,PlayerEnum.PLAYER1,i,j,weight[i][j]);
                    
                }
                else if(board[i][j]>15 && board[i][j] < 32){
                    setChessFactory(cf,PlayerEnum.PLAYER2,i,j,weight[i][j]);
                }
            }
        }
    }
    
    public ImageIcon getChessImage(int x , int y){
        if(chesses[x][y] == null)
            return null;
        img = chesses[x][y].getImage();
        return img;
    }
   private void setChessFactory(ChessFactory cf,PlayerEnum player,int i,int j,int weight){
        switch (weight){
                    case 0:    
                        chesses[i][j] =  cf.getKing(player , i , j);
                        break;
                    case 1:
                        chesses[i][j] =  cf.getGuards(player , i , j);
                        break;
                    case 2:
                        chesses[i][j] =  cf.getBishop(player , i , j);
                        break;
                    case 3:
                        chesses[i][j] =  cf.getChariot(player , i , j);
                        break;
                    case 4:
                        chesses[i][j] =  cf.getHorse(player , i , j);
                        break;  
                    case 5:
                        chesses[i][j] =  cf.getGun( player, i , j);
                        break;
                    case 6:
                        chesses[i][j] =   cf.getSoldier(player , i , j);
                        break;
                    }
        
    }
    public void setBoardRound(PlayerEnum player){
        this.player = player;
    }
    public PlayerEnum getBoardRound(){
        return player;
    }
    public boolean getBoardCheck(int x , int y){
        check = chesses[x][y].getCheck();
        return check;
    }
    public void setBoardCheck(int x , int y){
        chesses[x][y].setCheck(true);
    }
    public void restFocaus(){
        for ( i = 0 ; i < 4; i++)
                for ( j = 0 ;j < 8;j++)
                    if(chesses[i][j] != null)
                        chesses[i][j].setChessFocaus(false);
    }
    public int getChessweight(int x , int y){
        return chesses[x][y].getChessWeight();
    }
    public int[][] getBoard(){ //棋子
        return board;
    }
   public int[][] getWeight(){ //權重
        return weight;
    }
    public int getX(int x , int y){
        return chesses[x][y].getChessX();
    }
    public int getY(int x , int y){
        return chesses[x][y].getChessY();
    }
    public void ShowImage(){
        int x = 0;
        for ( i = 0 ; i < 32 ; i++ ){
            if(i>0 &&i<11){
                chessIcon[i] = new ImageIcon("chesspic//"+(i+1)/2+".png");
                chessChoiceIcon[(i+1)/2] = new ImageIcon("chesspic//0"+(i+1)/2+".png");
            }
            if(i>10 && i<16){
                chessIcon[i] = new ImageIcon("chesspic//"+6+".png");
                chessChoiceIcon[6] = new ImageIcon("chesspic//0"+6+".png");
            }
            if(i>16 &&i<27){
                chessIcon[i] = new ImageIcon("chesspic//"+(i-1)/2+".png");
                chessChoiceIcon[(i-1)/2] = new ImageIcon("chesspic//0"+(i-1)/2+".png");

            }
            if(i>26 && i<32){
                chessIcon[i] = new ImageIcon("chesspic//"+13+".png");
                chessChoiceIcon[13] = new ImageIcon("chesspic//0"+13+".png");
            }
            if(i==0 || i==16){
                chessIcon[i] = new ImageIcon("chesspic//"+i%9+".png");   
                chessChoiceIcon[i%9] = new ImageIcon("chesspic//0"+i%9+".png");
            }

           
        }
   }
   public void touchChess(int x , int y){
      
        if ( chesses[x][y] == null && (sum%2 == 0) && which == false){
          if (  ( Math.abs( x - (int)focussedDimension.getWidth()) + Math.abs(y - (int)focussedDimension.getHeight()) ) < 2){
              if(chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()].getChessFocaus() == true){
                  chesses[x][y] = chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()];
                  chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()] = null ;
                  
                   sum++;
                   restFocaus();
                }
            }
           else
           restFocaus();
        }
        else if ( chesses[x][y] == null && (sum%2 == 1) && which == true ){
          if (  ( Math.abs( x - (int)focussedDimension.getWidth()) + Math.abs(y - (int)focussedDimension.getHeight()) ) < 2){
              if(chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()].getChessFocaus() == true){
                  chesses[x][y] = chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()];
                  chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()] = null ;
                  
                   sum++;
                   restFocaus();
                }
            }
           else
           restFocaus();
        }
        else if (chesses[x][y] == null ){
            restFocaus();
        }
        else if(!chesses[x][y].getCheck()){ //還沒翻的
            chesses[x][y].setCheck(true);
            sum++;
            eat = 0;
            restFocaus();  
        }
        else if(chesses[x][y].getRound() == PlayerEnum.PLAYER1 && (sum%2 == 0) ){  //以翻若是玩家一的旗子
            if( chesses[x][y].getChessFocaus() == true && (int)focussedDimension.getWidth() == x &&  (int)focussedDimension.getHeight() == y  ){
                restFocaus();  
            }
            else
                {
                which = false;
                who = 1;
                focussedDimension = new Dimension(x,y);  //水哥
                restFocaus();
                chesses[x][y].setChessFocaus(true);
                }
            eat = 0;
        }
        else if(chesses[x][y].getRound() == PlayerEnum.PLAYER2 && (sum%2 == 1)  ){//以翻若是玩家二的旗子
          if(  chesses[x][y].getChessFocaus() == true && (int)focussedDimension.getWidth() == x &&  (int)focussedDimension.getHeight() == y ){
                restFocaus();  
            }
          else{
           which = true;
           who = 2;
           focussedDimension = new Dimension(x,y);  //水哥
           restFocaus();
           chesses[x][y].setChessFocaus(true);
          }
           eat = 0;
        }
        else if( eat == 0 && (chesses[x][y].getRound() == PlayerEnum.PLAYER2 && (sum%2 == 0) && which == false && chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()].getChessFocaus() == true )){  //上一個是Player1且他要吃Player2的棋子
          System.out.println(chesses[x][y].getChessWeight());
          System.out.println(chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()].getChessWeight());
         if (  ( Math.abs( x - (int)focussedDimension.getWidth()) + Math.abs(y - (int)focussedDimension.getHeight()) ) < 2) //看是不是在上下左右1格
                canmove = true;
         else if ( chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()].getChessWeight() == 5 ){
            if ( x == (int)focussedDimension.getWidth()  || y == (int)focussedDimension.getHeight() ){
              if(y >  (int)focussedDimension.getHeight()){
                  for ( i = (int)focussedDimension.getHeight() ; i > (int)focussedDimension.getHeight(); i--)
                    if(weight[x][i] != 8)
                        tot++;          
               }
                else if (y <  (int)focussedDimension.getHeight()){
                    for ( i = y ; i <  (int)focussedDimension.getHeight(); i++)
                        if(weight[x][i] != 8)
                        tot++;          
               }
               else if (x > (int)focussedDimension.getWidth()){
                   for ( i = x ; i > (int)focussedDimension.getWidth(); i--)
                    if(weight[x][i] != 8)
                        tot++;
                }
                else if (x < (int)focussedDimension.getWidth()){
                    for ( i = x ; i < (int)focussedDimension.getWidth(); i++)
                        if(weight[x][i] != 8)
                            tot++;
                }
        
              if (tot == 2){
                   canmove = true;
                }
              else 
                   canmove = false;
             }
            }
         else
            canmove = false;
          if(canmove == true){
               if(chesses[x][y].getChessWeight() == 6 && chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()].getChessWeight() == 0 ){
                  restFocaus();
              }
              else if(chesses[x][y].getChessWeight() == 0 && chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()].getChessWeight() == 6 ){
                  chesses[x][y] = chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()];
                  chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()] = null ;
                 
                  sum++;
                  eat = 1;
                  restFocaus();
              }
       
             
              else if(chesses[x][y].getChessWeight() >= chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()].getChessWeight()){
                  chesses[x][y] = chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()];
                  chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()] = null ;
                 
                  sum++;
                  eat = 1;
                  restFocaus();
                }
          }
          else{
            restFocaus();
          }
        
        
           
               
        }
        else if(  eat == 0  && (chesses[x][y].getRound() == PlayerEnum.PLAYER1  && (sum%2 == 1) &&  which == true && chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()].getChessFocaus() == true) ){  //上一個是Player1且他要吃Player2的棋子
          System.out.println(chesses[x][y].getChessWeight());
          System.out.println(chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()].getChessWeight());
          if (  ( Math.abs( x - (int)focussedDimension.getWidth()) + Math.abs(y - (int)focussedDimension.getHeight()) ) < 2) //看是不是在上下左右1格
                canmove = true;
          else if ( chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()].getChessWeight() == 5 ){
            if ( x == (int)focussedDimension.getWidth()  || y == (int)focussedDimension.getHeight() ){
              if(y >  (int)focussedDimension.getHeight()){
                  for ( i = (int)focussedDimension.getHeight() ; i > (int)focussedDimension.getHeight(); i--)
                    if(weight[x][i] != 8)
                        tot++;          
               }
                else if (y <  (int)focussedDimension.getHeight()){
                    for ( i = y ; i <  (int)focussedDimension.getHeight(); i++)
                        if(weight[x][i] != 8)
                        tot++;          
               }
               else if (x > (int)focussedDimension.getWidth()){
                   for ( i = x ; i > (int)focussedDimension.getWidth(); i--)
                    if(weight[x][i] != 8)
                        tot++;
                }
                else if (x < (int)focussedDimension.getWidth()){
                    for ( i = x ; i < (int)focussedDimension.getWidth(); i++)
                        if(weight[x][i] != 8)
                            tot++;
                }
        
              if (tot == 2){
                   canmove = true;
                }
              else 
                   canmove = false;
             }
            }
         else
            canmove = false;
          if(canmove == true){
              if(chesses[x][y].getChessWeight() == 6 && chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()].getChessWeight() == 0 ){
                  restFocaus();
              }
              else if(chesses[x][y].getChessWeight() == 0 && chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()].getChessWeight() == 6 ){
                  chesses[x][y] = chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()];
                  chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()] = null ;
                  
                  sum++;
                  eat = 1;
                  restFocaus();
              }
               
              else if(chesses[x][y].getChessWeight() >= chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()].getChessWeight()){
                  chesses[x][y] = chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()];
                  chesses[(int)focussedDimension.getWidth()][(int)focussedDimension.getHeight()] = null ;
                  
                  sum++;
                  eat = 1;
                  restFocaus();
                }
          }
          else{
            restFocaus();
          }
           
               
        }
        
        
    }
}


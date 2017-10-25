import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
public class StdChessFactory implements ChessFactory
{
   private ImageIcon chessIcon ,cimg;
   private ChessAction action = new OneStep();
   public Chess getSoldier(PlayerEnum player , int x ,int y){
       if(player == PlayerEnum.PLAYER1){
       chessIcon = new ImageIcon("chesspic//"+6+".png");
       cimg = new ImageIcon("chesspic//0"+6+".png");
       }
       else{
       chessIcon = new ImageIcon("chesspic//"+13+".png");
       cimg = new ImageIcon("chesspic//0"+13+".png");
       }
       return new Chess(player , action , ChessEnum.SOLDIER ,chessIcon,cimg ,6 , x , y , false);
    }
   public Chess getHorse(PlayerEnum player , int x ,int y){
       if(player == PlayerEnum.PLAYER1){
       chessIcon = new ImageIcon("chesspic//"+4+".png");
       cimg = new ImageIcon("chesspic//0"+4+".png");
       }
       else{
       chessIcon = new ImageIcon("chesspic//"+11+".png");
       cimg = new ImageIcon("chesspic//0"+11+".png");}
       return new Chess(player , action , ChessEnum.HORSE ,chessIcon , cimg,4, x , y, false);
    }
   public Chess getGun(PlayerEnum player , int x ,int y){
        ChessAction action2 = new Flying(new OneStep());
       if(player == PlayerEnum.PLAYER1){
       chessIcon = new ImageIcon("chesspic//"+5+".png");
       cimg = new ImageIcon("chesspic//0"+5+".png");}
       else{
       chessIcon = new ImageIcon("chesspic//"+12+".png");
       cimg = new ImageIcon("chesspic//0"+12+".png");}
       return new Chess(player , action2 , ChessEnum.GUN ,chessIcon , cimg,5, x , y, false);
    }
   public Chess getBishop(PlayerEnum player , int x ,int y){
       if(player == PlayerEnum.PLAYER1){
       chessIcon = new ImageIcon("chesspic//"+2+".png");
       cimg = new ImageIcon("chesspic//0"+2+".png");}
       else{
       chessIcon = new ImageIcon("chesspic//"+9+".png");
       cimg = new ImageIcon("chesspic//0"+9+".png");}
       return new Chess(player , action , ChessEnum.BISHOP ,chessIcon , cimg,2, x , y, false);
       
    }
   public Chess getGuards(PlayerEnum player , int x ,int y){
       if(player == PlayerEnum.PLAYER1){
       chessIcon = new ImageIcon("chesspic//"+1+".png");
       cimg = new ImageIcon("chesspic//0"+1+".png");
       }
       else{
       chessIcon = new ImageIcon("chesspic//"+8+".png");
       cimg = new ImageIcon("chesspic//0"+8+".png");
       }
       return new Chess(player , action , ChessEnum.GUARDS ,chessIcon , cimg,1, x , y, false);
    }
   public Chess getKing(PlayerEnum player , int x ,int y){
       if(player == PlayerEnum.PLAYER1){
       chessIcon = new ImageIcon("chesspic//"+0+".png");
       cimg = new ImageIcon("chesspic//0"+0+".png");
       }
       else{
       chessIcon = new ImageIcon("chesspic//"+7+".png");
       cimg = new ImageIcon("chesspic//0"+7+".png");
       }
       return new Chess(player , action , ChessEnum.KING ,chessIcon , cimg,0, x , y, false);
    }
   public Chess getChariot(PlayerEnum player , int x ,int y){
       ChessAction action1 = new Crash(new OneStep());
       if(player == PlayerEnum.PLAYER1){
       chessIcon = new ImageIcon("chesspic//"+3+".png");
       cimg = new ImageIcon("chesspic//0"+3+".png");
       }
       else{
       chessIcon = new ImageIcon("chesspic//"+10+".png");
       cimg = new ImageIcon("chesspic//0"+10+".png");
       }
       return new Chess(player , action1 , ChessEnum.CHARIOT ,chessIcon , cimg,3, x , y, false);
    }
   
}

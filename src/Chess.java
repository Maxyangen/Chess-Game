import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
public class Chess
{
    private ChessEnum chesstype;
    private ImageIcon chessimg , cimg;
    private static ImageIcon noCheck =  new ImageIcon("chesspic//"+36+".png");
    private PlayerEnum player;
    private ChessAction chessaction;
    private boolean focaus;
    private int x ,  y ;
    private int weight ;
    private boolean check ;
    public Chess(PlayerEnum p , ChessAction action , ChessEnum chess , ImageIcon image ,ImageIcon cimage ,int weight ,int x ,int y,boolean focaus){
    player = p;
    chesstype = chess;
    chessaction = action;
    chessimg = image;
    cimg = cimage;
    this.weight = weight;
    this.x = x;
    this.y = y;
    check = false;
    focaus = false;
    }
    public void setChessAction(ChessAction action){
        chessaction = action;
    }
    public ChessAction getChessAction(){
        return chessaction;
    }
    public void setRound(PlayerEnum player){
        this.player = player;
    }
    public PlayerEnum getRound(){
        return player;
    }
    public void setChessFocaus(boolean focaus){
        this.focaus = focaus;
    }
    public boolean getChessFocaus(){
        return focaus;
    }
    public void setChessImg(ImageIcon img){
        chessimg = img;
    }
    public ImageIcon getImage(){
        if(!check)
            return noCheck;
        else if(focaus)
            return cimg;
        return chessimg;
    }
    public void setCheck(boolean check){
        this.check = check;
    }
    public boolean getCheck(){
        return check;
    }
    public void setChessX(int x){
        this.x = x;
    }
     public void setChessY(int y){
        this.y = y;
    }
    public int getChessX(){
        return x ;
    }
    public int getChessY(){
        return y;
    }
    public void setChessWeight(int weight){
        this.weight = weight;
    }
    public int getChessWeight(){
        return weight;
    }
    
    
    
}

import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.awt.image.BufferedImage;
public class View
{
    private ChessBoard chessboard ;//= ChessBoard.getChessBoard();
    private Chess chess;
    private JFrame parent;
    private JPanel p;
    private JButton[][] JB = new JButton[4][8];
    private int i , j , x , y;
    private ImageIcon chessIcon ;
    private int[][] ba =new int[4][8]; //棋子
    private int[][] b  = new int[4][8]; //全中
    /*ImageIcon[] chessIcon = new ImageIcon[32];
    ImageIcon[][] CI=new ImageIcon[4][8];*/
  
    public View(){
        chessboard = ChessBoard.getChessBoard();
        JButton();
    }
    public void rest(){
        for(i = 0;i < 4;i++){
                for (j = 0;j < 8;j++){
                    JB[i][j].setIcon(chessboard.getChessImage(i,j));
                }
       }
    }
    public void JButton(){
        parent = new JFrame("jb");
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        

        parent.setSize(900, 300); 
        parent.setLocationRelativeTo(null);  //顯示在中間
        parent.setVisible(true); 
        parent.repaint();
        parent.setResizable(false);
        
        Container cp=parent.getContentPane();
        
        cp.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //ba = chessboard.getBoard();
       ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton jbtemp = (JButton)e.getSource() ;
            for(i = 0;i < 4;i++){
                for (j = 0;j < 8;j++){
                    if (JB[i][j] == jbtemp){
                        if (JB[i][j] == jbtemp){
                            //JOptionPane.showMessageDialog(null , "案到了" + i +" " + j);
                            chessboard.touchChess(i,j);
                            break;
                            }   
                        }
                    }
               }
            rest();
           }
        };

        for(i = 0;i < 4;i++){
            for (j = 0;j < 8;j++){
                //chessIcon = new ImageIcon("chesspic//"+36+".png");
                 JB[i][j] = new JButton(chessboard.getChessImage(i,j));
                 
                }
            }
        for (i = 0  , y = 50; i < 4; i++ ,y+=50){
             for (j = 0 ,x = 30; j <8; j++ ,x+=100){
                 JB[i][j].setBounds( x , y ,100,50); 
                 JB[i][j].setPreferredSize(new Dimension(100,50));
                 JB[i][j].addActionListener(listener);
             }
        }
        for(i = 0;i < 4;i++){
            for (j = 0;j < 8;j++){
                cp.add( JB[i][j] );
               
            } 
        }
        
    }
   /* public void ShowImage(){
        int x = 0;
        for (int i = 0 ; i < 32 ; i++ ){
            if(i>0 &&i<11){
                chessIcon[i] = new ImageIcon("chesspic//"+(i+1)/2+".png");

            }
            if(i>10 && i<16){
                chessIcon[i] = new ImageIcon("chesspic//"+6+".png");
            }
            
            if(i>16 &&i<27){
                chessIcon[i] = new ImageIcon("chesspic//"+(i-1)/2+".png");

            }
            if(i>26 && i<32){
                chessIcon[i] = new ImageIcon("chesspic//"+13+".png");
            }
            if(i==0 || i==16){
                chessIcon[i] = new ImageIcon("chesspic//"+i%9+".png");                
            }

           
        }*/

  }
    
    
   /* public class MultiListener implements ActionListener {
    
        button1.addActionListener(this);
        button2.addActionListener(this);
 
        button2.addActionListener(new Eavesdropper(bottomTextArea));
    }
 
    public void actionPerformed(ActionEvent e) {
        topTextArea.append(e.getActionCommand() + newline);
    }*/

 

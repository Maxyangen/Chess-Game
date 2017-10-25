public abstract class ActionDecorator extends ChessAction
{
    protected ChessAction chessAction;
    //protected ChessBoard chessboard = ChessBoard.getChessBoard();
    private int x , y;
    public ActionDecorator(ChessAction chessac){
        chessAction = chessac;
    }
   
}

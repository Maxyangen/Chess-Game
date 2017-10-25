public abstract class ChessAction
{
    protected static ChessBoard chessboard = ChessBoard.getChessBoard(); //= ChessBoard.getChessBoard();
    
    public abstract boolean canMove(Chess chess , int movex ,int movey); //水哥特賣
}

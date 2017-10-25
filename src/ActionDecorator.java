public abstract class ActionDecorator extends ChessAction
{
    protected ChessAction chessAction;
    public ActionDecorator(ChessAction chessac){
        chessAction = chessac;
    }
   
}

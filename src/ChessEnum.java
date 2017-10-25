public enum ChessEnum
{
    KING("King" , 100 ) , GUARDS("Guards" , 50) , BISHOP("Bishop" , 40) , CHARIOT("Chariot" , 30) , HORSE("Horse" ,20) ,GUN("Gun" , 10) ,SOLDIER("Soldier" , 5);
    int weight;
    String chess;
    private ChessEnum(String chess , int weight){
        this.chess = chess;
        this.weight = weight;
    }
    public String getChess() {
        return chess;
    }
    public int getWeight(){
        return weight;
    }
}

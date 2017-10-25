public enum PlayerEnum
{
    PLAYER1("Player1") , PLAYER2("Player2") ,PLAYER3("Player3");
    private String name;
    //
    private PlayerEnum(String name){
        this.name = name;
    }
    //
    public String getPlayer() {
		return name;
	}
}


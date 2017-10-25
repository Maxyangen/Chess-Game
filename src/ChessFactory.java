public interface ChessFactory
{
   Chess getSoldier(PlayerEnum player , int x ,int y);
   Chess getHorse(PlayerEnum player , int x ,int y);
   Chess getBishop(PlayerEnum player , int x ,int y);
   Chess getGuards(PlayerEnum player , int x ,int y);
   Chess getKing(PlayerEnum player , int x ,int y);
   Chess getGun(PlayerEnum player, int x ,int y);
   Chess getChariot(PlayerEnum player, int x ,int y);
  
   
}


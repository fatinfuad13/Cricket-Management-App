
import java.util.ArrayList;

public class PlayerList {
    private static ArrayList<Player> players; // ensures only one copy of players 

    public static void setPlayers(ArrayList<Player> playerList)
    {
        players = playerList;
    }
    
    public static ArrayList<Player> getPlayers()
    {
       return players;
    }

    public static boolean containsPlayer(String name)
    {
        name = name.toLowerCase();
        for(int i=0;i<players.size();i++)
        {
           String s = players.get(i).getName().toLowerCase();
           if(name.equals(s))
                return true;
        }
 
        return false;
    }

}

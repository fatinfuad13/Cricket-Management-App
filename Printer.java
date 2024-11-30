import java.util.ArrayList;
public class Printer {
    
    public void printPlayers(ArrayList<Player> players)
    {
        for(int i=0;i<players.size();i++)
              System.out.println(players.get(i));
    }


}

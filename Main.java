import java.util.ArrayList;

public class Main{
   
    public static void main(String[] args){
     
        ArrayList<Player> players = FileOperations.loadPlayersFromFile(); // load players from input file
        PlayerList.setPlayers(players); // load players into database from file
        Menu.mainMenu(); // display main menu
        FileOperations.savePlayersToFile(players); // save changes back into file before exiting
    }
    
}
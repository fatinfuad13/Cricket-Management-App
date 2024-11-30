import java.util.ArrayList;

public class Main{
   
    public static void main(String[] args){
     
        ArrayList<Player> players = FileOperations.loadPlayersFromFile(); // load players from input file
        PlayerList.setPlayers(players); 
        Menu menu = new Menu();
        menu.mainMenu();
        FileOperations.savePlayersToFile(players); // save files before exiting
    }
    
}
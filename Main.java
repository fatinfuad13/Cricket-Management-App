import java.util.ArrayList;

public class Main{
   
    //ArrayList<Player> players = new ArrayList<>(FileOperations.loadPlayersFromFile());
    public static void main(String[] args){
     
        ArrayList<Player> players = FileOperations.loadPlayersFromFile();
        PlayerList.setPlayers(players); 
        Menu menu = new Menu();
        menu.mainMenu();
        FileOperations.savePlayersToFile(players);



    }
    
}

import java.util.ArrayList;
import java.util.Scanner;

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
   
    public static Player addPlayer()
    {
        String name, country, club, position;
        int age = 0, number = 0, weeklySalary = 0;
        double height = 0.0;
        Scanner scanner = new Scanner(System.in);

        //scanner.nextLine(); // clear any new line before it

        System.out.println("Enter name of the player: ");
        name = scanner.nextLine();
    
        System.out.println("Enter country of the player: ");
        country = scanner.nextLine();
    
        System.out.println("Enter club of the player: ");
        club = scanner.nextLine();
    
        System.out.println("Enter position of the player: ");
        position = scanner.nextLine();
    
        
        while (true) {
            try {
                System.out.println("Enter age of the player (in years): ");
                age = Integer.parseInt(scanner.nextLine());
                if (age <= 0) throw new NumberFormatException("Age must be positive.");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid positive integer for age.");
            }
        }
    
        while (true) {
            try {
                System.out.println("Enter height of the player (in cm): ");
                height = Double.parseDouble(scanner.nextLine());
                if (height <= 0) throw new NumberFormatException("Height must be positive.");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid positive number for height.");
            }
        }
    
        while (true) {
            try {
                System.out.println("Enter jersey number of the player: ");
                number = Integer.parseInt(scanner.nextLine());
                if (number < 0) throw new NumberFormatException("Number cannot be negative.");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid non-negative integer for jersey number.");
            }
        }
    
        while (true) {
            try {
                System.out.println("Enter weekly salary of the player (in USD): ");
                weeklySalary = Integer.parseInt(scanner.nextLine());
                if (weeklySalary < 0) throw new NumberFormatException("Salary cannot be negative.");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid non-negative integer for salary.");
            }
        }
    
        
        Player newPlayer = new Player(name, country, age, height, club, position, number, weeklySalary); // create the player
    
        
        if(PlayerList.containsPlayer(newPlayer.getName()))
        {
            System.out.println("Player of this name already present in database");
        }

        else 
        {
            players.add(newPlayer);
            System.out.println("Player added successfully");
        }

        return newPlayer;
    }


}

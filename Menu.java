
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Menu {
    
    ArrayList<Player> players = PlayerList.getPlayers(); // we assign here instead of making a copy
    Scanner scanner = new Scanner(System.in);
    Printer printer = new Printer();

    public void mainMenu()
    {
     int choice = -1;
     while(choice != 4)
     {
        System.out.println("Main Menu:\n(1) Search Players\n(2) Search Clubs\n(3) Add Player\n(4) Exit System");
        choice = scanner.nextInt();
        switch(choice)
        {
            case 1:
            playerSearchMenu();
            break;
            
            case 2:
            clubSearchMenu();
            break;

            case 3:
            addPlayerMenu();
            break;

            case 4:
            //
            break;

            default:
            System.out.println("Invalid option");
            break;
        }

     }


    }

    public void playerSearchMenu()
    {
      SearchPlayer search = new SearchPlayer();
      ArrayList<Player> searchResult = new ArrayList<>();
      HashMap<String,Integer> map = new HashMap<>();

      int choice = -1;
      while(choice != 6)
      {
         System.out.println("Player Searching Options:\n(1) By Player Name\n(2) By Club and Country\n(3) By Position\n(4) By Salary Range\n(5) Country-wise player count\n(6) Back to Main Menu");
         choice = scanner.nextInt();
         switch(choice)
         {
            case 1:
            searchResult = search.byName();
            if(searchResult.isEmpty())
                 System.out.println("No player found with this name.");
            else
                 printer.printPlayers(searchResult);     

            break;
            
            case 2:
            searchResult = search.byClubCountry();
            if(searchResult.isEmpty())
                System.out.println("No player found with this club and country.");
            else
                printer.printPlayers(searchResult);

            break;

            case 3:
            searchResult = search.byPosition();
            if(searchResult.isEmpty())
                System.out.println("No player found with this position.");
            else
                printer.printPlayers(searchResult);

            break;

            case 4:
            searchResult = search.bySalaryRange();
            if(searchResult.isEmpty())
               System.out.println("No player found with this salary range.");
            else
               printer.printPlayers(searchResult);
            break;

            case 5:
            map = search.countryWiseCount();
            map.forEach((key,value) -> System.out.println("Country: "+ key+"\nPlayers: " + value+"\n"));
            break;

            case 6:
            break;

            default:
            System.out.println("Invalid Option");
            break;
         }

      }


    }

    public void clubSearchMenu()
    {
        SearchClub search = new SearchClub();
        ArrayList<Player> searchResult = new ArrayList<>();
        
        
        int choice = -1;
        while(choice != 5)
        {
           System.out.println( "Club Searching Options:\n(1) Player(s) with the maximum salary of a club\n(2) Player(s) with the maximum age of a club\n(3) Player(s) with the maximum height of a club\n(4) Total yearly salary of a club\n(5) Back to Main Menu");
           choice = scanner.nextInt();
           switch(choice)
           {
            case 1:
            searchResult = search.byMaxSalary();
            if(searchResult.isEmpty())
                System.out.println("No club of such name exists.");
            else
                printer.printPlayers(searchResult);

            break;
            
            case 2:
            searchResult = search.byMaxAge();
            if(searchResult.isEmpty())
               System.out.println("No club of such name exists.");
            else
               printer.printPlayers(searchResult);

            break;

            case 3:
            searchResult = search.byMaxHeight();
            if(searchResult.isEmpty())
               System.out.println("No club of such name exists.");
            else
               printer.printPlayers(searchResult);

            break;

            case 4:
            long total = search.totalClubSalary();
            if(total == -1)
                System.out.println("No club of such name exists.");
            else
                System.out.println("Total yearly salary of the club is "+total);
            break;

            case 5:
            break;

            default:
            System.out.println("Invalid option");
            break;

           }



        }

    }

    public void addPlayerMenu()
    {
        String name, country, club, position;
        int age = 0, number = 0, weeklySalary = 0;
        double height = 0.0;
    
        scanner.nextLine(); // clear any new line before it

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
          
    }


    }






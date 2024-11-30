
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
         scanner.nextLine();

         switch(choice)
         {
            case 1:
            System.out.println("Enter name of the player:");
            String name = scanner.nextLine();
            searchResult = search.byName(name);
            if(searchResult.isEmpty())
                 System.out.println("No player found with this name.");
            else
                 printer.printPlayers(searchResult);     

            break;
            
            case 2:
            String club,country;
            System.out.println("Enter country of the player: ");
            country = scanner.nextLine();
            System.out.println("Enter club of the country: ");
            club = scanner.nextLine();
            searchResult = search.byClubCountry(club,country);
            if(searchResult.isEmpty())
                System.out.println("No player found with this club and country.");
            else
                printer.printPlayers(searchResult);

            break;

            case 3:
            System.out.println("Enter position of the player: ");
            String position = scanner.nextLine();
            searchResult = search.byPosition(position);
            if(searchResult.isEmpty())
                System.out.println("No player found with this position.");
            else
                printer.printPlayers(searchResult);

            break;

            case 4:
            int low,high;
            System.out.println("Enter the lower range of weekly salary: ");
            low = scanner.nextInt();

            System.out.println("Enter the higher range of weekly salary: ");
            high = scanner.nextInt();
            searchResult = search.bySalaryRange(low,high);
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
           scanner.nextLine();
           
           String clubName;

           switch(choice)
           {
            case 1:
            System.out.println("Enter name of the club: ");
            clubName = scanner.nextLine();
            searchResult = search.byMaxSalary(clubName);
            if(searchResult.isEmpty())
                System.out.println("No club of such name exists.");
            else
                printer.printPlayers(searchResult);

            break;
            
            case 2:
            System.out.println("Enter name of the club: ");
            clubName = scanner.nextLine();
            searchResult = search.byMaxAge(clubName);
            if(searchResult.isEmpty())
               System.out.println("No club of such name exists.");
            else
               printer.printPlayers(searchResult);

            break;

            case 3:
            System.out.println("Enter name of the club: ");
            clubName = scanner.nextLine();
            searchResult = search.byMaxHeight(clubName);
            if(searchResult.isEmpty())
               System.out.println("No club of such name exists.");
            else
               printer.printPlayers(searchResult);

            break;

            case 4:
            System.out.println("Enter name of the club: ");
            clubName = scanner.nextLine();
            long total = search.totalClubSalary(clubName);
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
        PlayerList.addPlayer(); 
    }


    }






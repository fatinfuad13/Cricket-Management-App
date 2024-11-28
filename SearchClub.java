import java.util.ArrayList;
import java.util.Scanner;

public class SearchClub {
    // MAKE SEARCH BY MAX ... MORE GENERALISED ?
    ArrayList<Player> players = new ArrayList<>(PlayerList.getPlayers()); // create a copy instead of assigning to avoid changing players array while searching
    Scanner scanner = new Scanner(System.in);

   public ArrayList<Player> createClub(String clubName) // makes a list where all players are from the club named "clubName"
   {
    clubName = clubName.toLowerCase(); // MAKE IT PRIVATE?

    ArrayList<Player> club = new ArrayList<>();
    for(int i=0;i<players.size();i++)
    {
        String s = players.get(i).getClub().toLowerCase();
       
        if(clubName.equals(s))
        {
            club.add(players.get(i));
        }
    }
    
     return club; // now we can work with a list that contains only a single club's players
   }

    
    public void byMaxSalary()
    {
      String clubName;
      System.out.println("Enter name of the club: ");
      clubName = scanner.nextLine();

      ArrayList<Player> club = createClub(clubName);
      if(club.isEmpty())
      {
        System.out.println("No such club found with this name");
      }
      
      else
      {
         int maxSalary = -1;
         for(int i=0;i<club.size();i++) // finding the max salary within the club
         {
            if(club.get(i).getWeeklySalary() > maxSalary)
                     maxSalary = club.get(i).getWeeklySalary();
         }

         for(int i=0;i<club.size();i++) // print the players with the max salary
         {
            if(club.get(i).getWeeklySalary() == maxSalary)
                  System.out.println(club.get(i));
         }

      }

    }

    public void totalClubSalary()
    {
        String clubName;
        System.out.println("Enter name of the club: ");
        clubName = scanner.nextLine();
         
        ArrayList<Player> club = createClub(clubName);
        if(club.isEmpty())
        {
            System.out.println("No such club found with this name");
        }
        
        else
        {
          long total = 0;
          for(int i=0;i<club.size();i++)
          {
            total += club.get(i).getWeeklySalary();
          }

          System.out.println("Total yearly salary of the club is: "+total*52);

        }

    }


    public void byMaxAge()
    {
      String clubName;
      System.out.println("Enter name of the club: ");
      clubName = scanner.nextLine();

      ArrayList<Player> club = createClub(clubName);
      if(club.isEmpty())
      {
        System.out.println("No such club found with this name");
      }
      
      else
      {
         int maxAge = -1;
         for(int i=0;i<club.size();i++) // finding the max age within the club
         {
            if(club.get(i).getAge()> maxAge)
                     maxAge = club.get(i).getAge();
         }

         for(int i=0;i<club.size();i++) // print the players with the max age
         {
            if(club.get(i).getAge() == maxAge)
                  System.out.println(club.get(i));
         }

      }

    }


    public void byMaxHeight()
    {
      String clubName;
      System.out.println("Enter name of the club: ");
      clubName = scanner.nextLine();

      ArrayList<Player> club = createClub(clubName);
      if(club.isEmpty())
      {
        System.out.println("No such club found with this name");
      }
      
      else
      {
         double maxHeight = -1;
         for(int i=0;i<club.size();i++) // finding the max height within the club
         {
            if(club.get(i).getHeight() > maxHeight)
                     maxHeight = club.get(i).getHeight();
         }

         for(int i=0;i<club.size();i++) // print the players with the max height
         {
            if(club.get(i).getHeight() == maxHeight)
                  System.out.println(club.get(i));
         }

      }

    }


}

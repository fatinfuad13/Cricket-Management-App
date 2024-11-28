import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SearchPlayer {

    ArrayList<Player> players =  new ArrayList<>(PlayerList.getPlayers());; // receive the playerList 
    Scanner scanner = new Scanner(System.in);

    public void byName() // searches for a player by name
    {
      
      System.out.println("Enter name of the player:");
      String name = scanner.nextLine();
      name = name.toLowerCase();

      boolean found = false;
      for(int i=0;i<players.size();i++)
      {
        
        String s = players.get(i).getName().toLowerCase();
        if(name.equals(s))
        {
            // print the player's details
            System.out.println(players.get(i));
            found = true;
            //break; // since database has no duplicates input
        }
      }
      
      if(!found)
      {
        System.out.println("No such player found with this name");
      }

    }
    
    public void byPosition()
    {
        System.out.println("Enter position of the player: ");
        String position = scanner.nextLine();

        boolean found = false;
        for(int i=0;i<players.size();i++)
        { 
          String s1 = position.toLowerCase();
          String s2 = players.get(i).getPosition().toLowerCase();
          if(s1.equals(s2))
          {
              // print the player's details
              System.out.println(players.get(i));
              found = true;
          }
        }
        
        if(!found)
        {
          System.out.println("No such player found with this position");
        }
  
    }

   public void byClubCountry()
   {
    String club,country;
    System.out.println("Enter country of the player: ");
    country = scanner.nextLine();
    System.out.println("Enter club of the country: ");
    club = scanner.nextLine();

    boolean found = false;

    if(club.equals("ANY"))
    {
        country = country.toLowerCase();
        for(int i=0;i<players.size();i++)
        {
            String s = players.get(i).getCountry().toLowerCase();
            if(country.equals(s))
            {
                System.out.println(players.get(i));
                found = true;
            }

        }
    }
    else
    {
      country = country.toLowerCase();
      club = club.toLowerCase();

      for(int i=0;i<players.size();i++)
      {
         String s1 = players.get(i).getCountry().toLowerCase();
         String s2 = players.get(i).getClub().toLowerCase();

         if(country.equals(s1) && club.equals(s2))
         {
            System.out.println(players.get(i));
            found = true;
         }

      }


    }

    if(!found)
    {
        System.out.println("“No such player found with this country and club");
    }

   }

   public void bySalaryRange()
   {
     int low,high;
     System.out.println("Enter the lower range of weekly salary: ");
     low = scanner.nextInt();

     System.out.println("Enter the higher range of weekly salary: ");
     high = scanner.nextInt();

     if(low > high)
     {
        System.out.println("Invalid range.");
     }

     boolean found = false;
     for(int i=0;i<players.size();i++)
     {
        int salary = players.get(i).getWeeklySalary();
        if(low <= salary && salary <= high)
        {
            System.out.println(players.get(i));
            found = true;
        }

     }

     if(!found)
     {
        System.out.println("No such player found with this weekly salary range");
     }

   }

   public void countryWiseCount()
   {
    HashMap<String,Integer> mp = new HashMap<>();
    // country -> count
    for(int i=0;i<players.size();i++)
    {
      String country = players.get(i).getCountry();
      if(mp.containsKey(country))
      {
        mp.put(country,mp.get(country)+1); // update the key to map it to value + 1
      }
      else
      {
        mp.put(country,1);
      }

    }
    
    
    mp.forEach((key,value) -> System.out.println("Country: "+ key+"\nPlayers: " + value+"\n")); 


   }





    
}

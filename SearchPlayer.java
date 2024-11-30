import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SearchPlayer {

    ArrayList<Player> players =  new ArrayList<>(PlayerList.getPlayers());; // receive the playerList 
    Scanner scanner = new Scanner(System.in);
    

    public ArrayList<Player> byName() // searches for a player by name
    {
      ArrayList<Player> searched = new ArrayList<>(); 
      System.out.println("Enter name of the player:");
      String name = scanner.nextLine();
      name = name.toLowerCase();

      //boolean found = false;
      for(int i=0;i<players.size();i++)
      {
        
        String s = players.get(i).getName().toLowerCase();
        if(name.equals(s))
        {
            searched.add(players.get(i));
        }
      }

          return searched;
    }
    
    public ArrayList<Player> byPosition()
    {
        ArrayList<Player> searched = new ArrayList<>();

        System.out.println("Enter position of the player: ");
        String position = scanner.nextLine();

        
        for(int i=0;i<players.size();i++)
        { 
          String s1 = position.toLowerCase();
          String s2 = players.get(i).getPosition().toLowerCase();
          if(s1.equals(s2))
          {
             searched.add(players.get(i));
          }
        }
        
        return searched;
    }

   public ArrayList<Player> byClubCountry()
   {
    ArrayList<Player> searched = new ArrayList<>();

    String club,country;
    System.out.println("Enter country of the player: ");
    country = scanner.nextLine();
    System.out.println("Enter club of the country: ");
    club = scanner.nextLine();

    if(club.equals("ANY"))
    {
        country = country.toLowerCase();
        for(int i=0;i<players.size();i++)
        {
            String s = players.get(i).getCountry().toLowerCase();
            if(country.equals(s))
            {
                searched.add(players.get(i));
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
            searched.add(players.get(i));
         }

      }


    }

     return searched;
   }

   public ArrayList<Player> bySalaryRange()
   {
     ArrayList<Player> searched = new ArrayList<>();

     int low,high;
     System.out.println("Enter the lower range of weekly salary: ");
     low = scanner.nextInt();

     System.out.println("Enter the higher range of weekly salary: ");
     high = scanner.nextInt();

     if(low > high)
     {
        System.out.println("Invalid range.");
     }

    
     for(int i=0;i<players.size();i++)
     {
        int salary = players.get(i).getWeeklySalary();
        if(low <= salary && salary <= high)
        {
            searched.add(players.get(i));
        }

     }

     return searched;
   }

   public HashMap<String,Integer> countryWiseCount()
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
      return mp;

   }





    
}

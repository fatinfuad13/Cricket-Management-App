import java.util.ArrayList;
import java.util.HashMap;


public class SearchPlayer {

    ArrayList<Player> players =  new ArrayList<>(PlayerList.getPlayers());; // receive the playerList 
   
    

    public ArrayList<Player> byName(String name) // searches for a player by name
    {
      ArrayList<Player> searched = new ArrayList<>(); 
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
    
    public ArrayList<Player> byPosition(String position)
    {
        ArrayList<Player> searched = new ArrayList<>();
        
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

   public ArrayList<Player> byClubCountry(String club,String country)
   {
    ArrayList<Player> searched = new ArrayList<>();

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

   public ArrayList<Player> bySalaryRange(int low,int high)
   {
     ArrayList<Player> searched = new ArrayList<>();

     if(low > high)
     {
       return searched;
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

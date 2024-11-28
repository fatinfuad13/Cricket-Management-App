public class Player {
    private String name,country,club,position;
    private int age,number,WeeklySalary;
    private double height;
    
    Player()
    {
        name = country = club = position = null;
        age = number = WeeklySalary = 0;
        height = 0;
    }

    Player(String name,String country,int age,double height,String club,String position,int number,int WeeklySalary)
    {
       this.name = name;
       this.country = country;
       this.club = club;
       this.position = position;
       this.age = age;
       this.number = number;
       this.WeeklySalary = WeeklySalary;
       this.height = height;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getClub() {
        return club;
    }

    public String getPosition() {
        return position;
    }

    public int getAge() {
        return age;
    }

    public int getNumber() {
        return number;
    }

    public int getWeeklySalary() {
        return WeeklySalary;
    }

    public double getHeight() {
        return height;
    }

     @Override
     public String toString()
    {
     
        if(number != 0) 
             return "Name: "+name+"\nCountry: "+country+"\nAge: "+age+"\nHeight: "+height+"\nClub: "+club+"\nPosition: "+position+"\nJersey Number: "+number+"\nWeekly Salary: "+WeeklySalary+"\n";
        else
        return "Name: "+name+"\nCountry: "+country+"\nAge: "+age+"\nHeight: "+height+"\nClub: "+club+"\nPosition: "+position+"\nWeekly Salary: "+WeeklySalary+"\n";
             
    }

   
}


public class RoachSimulation
{  
   public static void main(String[] args)
   {  
      RoachPopulation colony = new RoachPopulation(100);
      
      colony.breed();
      colony.spray(10);
      System.out.print(colony.getRoaches());
      System.out.println(" roaches");
      colony.breed();
      colony.spray(10);
      System.out.print(colony.getRoaches());
      System.out.println(" roaches");
      colony.breed();
      colony.spray(10);
      System.out.print(colony.getRoaches());
      System.out.println(" roaches");
      colony.breed();
      colony.spray(10);
      System.out.print(colony.getRoaches());
      System.out.println(" roaches");
   }
}


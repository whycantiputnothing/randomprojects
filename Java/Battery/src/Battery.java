public class Battery
{

      private double fullCharge;
      private double batteryCapacity;

public Battery(double capacity)
{

      batteryCapacity = capacity;
      fullCharge = capacity;

}
public void drain(double amount)
{
     batteryCapacity = batteryCapacity - amount;
}

public void charge()
{

     batteryCapacity = fullCharge;
}

public double getRemainingCapacity()
{
     return batteryCapacity;
}

}  

public class RoachPopulation {
	private double population;
	
	public RoachPopulation (double n){
		n = population;
	}
	public void breed (){
		population = 2 * population;
	}
	public void spray (double something){
		population = population * (something / 100); 
	}
	public double getRoaches(){
		return population;
	}
}

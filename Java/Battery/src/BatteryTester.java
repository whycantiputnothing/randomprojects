
public class BatteryTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Battery battery = new Battery(2500);
		battery.drain(500);
		System.out.println("current charge: " + battery.getRemainingCapacity());
		battery.charge();
		System.out.println("current charge: " + battery.getRemainingCapacity());
	}

}

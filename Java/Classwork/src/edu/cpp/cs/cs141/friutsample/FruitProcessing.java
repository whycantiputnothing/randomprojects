/**
 * 
 */
package edu.cpp.cs.cs141.friutsample;

/**
 * @author Brandon Nguyen
 *
 */
public class FruitProcessing {

	private static Fruit[] fruits = new Fruit[100];
	private static int containerCounter = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Apple[] apples = new Apple[10];
		Orange[] oranges = new Orange[7];
		Bannana[] bannanas = new Bannana[5];

		for (int i = 0; i < apples.length; i++) {
			apples[i] = new Apple();
		}

		for (int i = 0; i < oranges.length; i++) {
			oranges[i] = new Orange();
		}

		for (int i = 0; i < bannanas.length; i++) {
			bannanas[i] = new Bannana();
		}
		// ...

		dumpIntoFruitBasket(apples);
		dumpIntoFruitBasket(oranges);
		dumpIntoFruitBasket(bannanas);
		
		System.out.println(totalFruitCount());
		
		printFruitSourness();
		printFruitNames();
		
		Fruit crzy4ppl = new Apple();
		
		System.out.println("Crazy fruit name: " + crzy4ppl.fruitName());
		
	}

	private static void dumpIntoFruitBasket(Fruit[] newFruits) {
		for (Fruit f : newFruits) {
			fruits[containerCounter++] = f;
		}
	}

	private static int totalFruitCount() {
		return containerCounter;
	}

	private static void printFruitSourness() {
		for (int i = 0; i < containerCounter; i++) {
				System.out.println(fruits[i].isSour());
		}
	}
	
	private static void printFruitNames() {
		for (int i = 0; i < containerCounter; i++) {
			System.out.println(fruits[i].fruitName());
		}
	}
}

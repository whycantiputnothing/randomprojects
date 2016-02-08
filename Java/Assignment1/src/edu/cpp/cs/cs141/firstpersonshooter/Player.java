/**
 * 
 */
package edu.cpp.cs.cs141.firstpersonshooter;

/**
 * @author Brandon Nguyen
 *
 */
public class Player {

	/**
	 * name of the player
	 */
	private String name;

	/**
	 * the value of this field ranges from 0-100
	 */
	private int health;

	/**
	 * stores the XYZ position of the player
	 */
	private double positionX;
	private double positionY;
	private double positionZ;

	/**
	 * stores the XYZ velocity of the player
	 */
	private double velocityX;
	private double velocityY;
	private double velocityZ;

	/**
	 * a true/false on what stance the player is taking
	 */
	private boolean isCrouching;

	/**
	 * takes keyboard input to change the players velocity
	 */
	public static void move() {

	}

	/**
	 * set the name of the player
	 * @param n
	 */
	public static void setName(String n){
		
	}
	/**
	 * takes keyboard input to obtain an object from the environment the player
	 * does not already have
	 */
	public static void obtainObject() {

	}

	/**
	 * drops the object player is currently holding
	 */
	public static void dropObject() {

	}

	/**
	 * takes mouse input to look around the environment
	 */
	public static void look() {

	}

	/**
	 * takes keyboard input to change the stance of the player
	 */
	public static void crouch() {

	}

	/**
	 * player loses health if the position of a bullet is the same as the player
	 * and deletes the bullet if true
	 */
	public static void takeDamage() {

	}
	
	/**
	 * player dies if health goes to 0
	 */
	public static void death() {

	}
	/**
	 * returns value of health
	 * @return
	 */
	
	public int getHealth(){
		return 0;
	}

	public double getPositionX() {
		return 0;
	}

	public double getPositionY() {
		return 0;
	}

	public double getPositionZ() {
		return 0;
	}

	public double getVelocityX() {
		return 0;
	}

	public double getVelocityY() {
		return 0;
	}

	public double getVelocityZ() {
		return 0;
	}

	public boolean isCrouching() {
		return false;
	}


}

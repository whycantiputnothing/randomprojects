/**
 * 
 */
package edu.cpp.cs.cs141.firstpersonshooter;

/**
 * @author Brandon Nguyen
 *
 */
public class Wall {
	/**
	 * stores the XYZ position of the wall
	 */
	private double positionX;
	private double positionY;
	private double positionZ;

	/**
	 * stores the size of the wall
	 */
	private double Length;
	private double Width;
	private double Height;

	/**
	 * a player object cannot intersect with a wall
	 */
	public static void wall() {

	}

	/**
	 * if a bullet intersects with a wall the bullet is deleted
	 */
	public static void bulletHole() {

	}

	public double getPositionX() {
		return positionX;
	}

	public double getPositionY() {
		return positionY;
	}

	public double getPositionZ() {
		return positionZ;
	}

	public double getLength() {
		return Length;
	}

	public double getWidth() {
		return Width;
	}

	public double getHeight() {
		return Height;
	}
	
	
}

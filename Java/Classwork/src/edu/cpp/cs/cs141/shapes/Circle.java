/**
 * 
 */
package edu.cpp.cs.cs141.shapes;

/**
 * @author Brandon Nguyen
 *
 */
public class Circle implements Shape2D {

	private double radius;

	public Circle(int rad) {
		radius = rad;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.cpp.cs.cs141.shapes.Shape2D#getPerimeter()
	 */
	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2 * Shape2D.PI * radius;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.cpp.cs.cs141.shapes.Shape2D#getArea()
	 */
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Shape2D.PI * radius * radius;
	}

}

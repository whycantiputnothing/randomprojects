package edu.cpp.cs.cs141.addmatrices;

import java.util.Arrays;

public class MultiDimArray {

	public static void main(String[] args) {
		int[][] matrix = new int[3][];

		matrix[0] = new int[4];
		matrix[1] = new int[2];
		matrix[2] = new int[42];
		

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = 42;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}

		for (int[] a : matrix) {
			System.out.print("[");
			for (int x : a) {
				System.out.print(" " + x + ", ");
			}
			System.out.println("]");
		}
		
	}
}

import java.util.Arrays;

public class Solver {

	private double[][] matrix;
	private double[] scaleVector;
	private double[] result;
	
	public static void main(String[] args) {
		double[][] A = {
	            { 0, 1,  1, 4},
	            { 2, 4, -2, 2 },
	            { 0, 3, 15, 36 }
	        };
		Solver s = new Solver(A);
		s.scaledPartialPivot();
		for(double[] b: A) {
			System.out.println(Arrays.toString(b));			
		}
	}

	public Solver(double[][] matrix) {
		this.matrix = matrix;
		scaleVector = findScalingVector(matrix);
	}

	public void scaledPartialPivot() {
		int pivotIndex;
		double factor;
		double xVal;
		double[] result = new double[matrix.length];

		for (int i = 0; i < matrix.length; i++) {
			pivotIndex = findPivotRow(i);
			swapRows(pivotIndex, i);

			for (int j = i + 1; j < matrix.length; j++) {
				factor = matrix[j][i] / matrix[i][i];
				matrix[j][i] = 0;

				for (int k = i + 1; k <= matrix.length; k++) {
					matrix[j][k] = matrix[j][k] - (factor * matrix[i][k]);
				}
			}
		}

		try {
			for (int i = matrix.length - 1; i >= 0; i--) {
				xVal = matrix[i][matrix.length] / matrix[i][i];

				for (int j = 0; j < i; j++) {
					matrix[j][matrix.length] -= (xVal * matrix[j][i]);
				}
				result[i] = xVal;
			}
		} catch(ArithmeticException a) {
			
		}
		

		this.result = result;
	}

	public String getResult() {
		String resultString = "";

		for (int i = 0; i < result.length; i++) {
			resultString += result[i] + " ";
		}

		return resultString;
	}


	private double[] findScalingVector(double[][] matrix) {
		double[] scale = new double[matrix.length];

		for (int i = 0; i < matrix.length; i++) {
			double maxVal = findMaxVal(matrix[i]);
			scale[i] = maxVal;
		}

		return scale;

	}

	private double findMaxVal(double[] matrix) {
		double maxVal = 0;

		for (int i = 0; i < matrix.length - 1; i++) {
			if (Math.abs(matrix[i]) > Math.abs(maxVal)) {
				maxVal = Math.abs(matrix[i]);
			}
		}
		return maxVal;
	}

	private int findPivotRow(int col) {
		double maxVal = 0;
		int maxIndex = 0;
		int row = col;

		for (int i = row; i < matrix.length; i++) {

			if (maxVal < Math.abs(matrix[i][col] / scaleVector[i])) {
				maxVal = Math.abs(matrix[i][col] / scaleVector[i]);
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	private void swapRows(int r1, int r2) {
		double[] tempRow = matrix[r1];
		double tempVal = scaleVector[r1];

		matrix[r1] = matrix[r2];
		matrix[r2] = tempRow;

		scaleVector[r1] = scaleVector[r2];
		scaleVector[r2] = tempVal;

	}

}

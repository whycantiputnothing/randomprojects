
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GEWithPartialPivot {
	
    double[][] A;
    double[] b;
	double[] x;
	public void solve() {
        int n = b.length;

        for (int p = 0; p < n; p++) {

            // find pivot row and swap
            int max = p;
            for (int i = p + 1; i < n; i++) {
                if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
                    max = i;
                }
            }
            double[] temp = A[p]; 
            A[p] = A[max]; 
            A[max] = temp;
            double   t    = b[p]; 
            b[p] = b[max]; 
            b[max] = t;

            if (Math.abs(A[p][p]) <= 1e-10) {
                throw new ArithmeticException("Matrix is singular or nearly singular");
            }
            
            // pivot within A and b
            for (int i = p + 1; i < n; i++) {
                double alpha = A[i][p] / A[p][p];
                b[i] -= alpha * b[p];
                for (int j = p; j < n; j++) {
                    A[i][j] -= alpha * A[p][j];
                }
            }
        }

        // back substitution
        x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }
    }
	
	  public void getInput(){
	    	int n = 0;
	    	int counter = 0;
	    	String buffer = "";
	    	Scanner input = new Scanner(System.in);
	    	System.out.println("Enter number of variables");
    		n = input.nextInt();
    		input.nextLine();
    		A = new double[n][n];
    		b = new double[n];
	    	System.out.println("Type 1 for User defined or type 2 for file input");
	    	buffer = input.nextLine();
	    	if (buffer.equals("1")) {
	    		System.out.println("Enter input line by line. Enter STOP to end input");
	    		buffer = input.nextLine();
	    		while (!buffer.equals("STOP")) {
	    			String[] splited = buffer.split("\\s+");
	    			for (int i = 0; i < n + 1; i++) {
	    				if (i == n) {
	    					b[counter] = Double.parseDouble(splited[i]);
	    					break;
	    				}
	    				A[counter][i] = Double.parseDouble(splited[i]);
	    			}
	    			counter++;
	    			buffer = input.nextLine();
	    		}
	    	}
	    	else {
	    		System.out.println("enter the name of the file");
	    		File file = new File(input.nextLine());
	    		try {
					input = new Scanner(file);
					while(input.hasNextLine()) {
						buffer = input.nextLine();
						String[] splited = buffer.split("\\s+");
		    			for (int i = 0; i < n + 1; i++) {
		    				if (i == n) {
		    					b[counter] = Double.parseDouble(splited[i]);
		    					break;
		    				}
		    				A[counter][i] = Double.parseDouble(splited[i]);
		    			}
		    			counter++;
					}
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    	}
	    }
	  
	  public void printResult() {
		  for(int i = 0; i < x.length; i++) {
	        	System.out.println("X" + i + "=" + x[i]);
	        	
	        }
	  }
	  
	  public void randomGen(int n) {
		  Random r = new Random();
		  A = new double[n][n];
		  b = new double[n];
		  for(int i = 0; i < n; i++) {
			  for (int j = 0; j < n; j++) {
				  A[i][j] =  -1000 + (1000 - -1000) * r.nextDouble();
			  }
			  b[i] = -1000 + (1000 - -1000) * r.nextDouble();
		  }
	  }
	  
	  public void randomTest() {
		  randomGen(10);
	    	long startTime = System.nanoTime();
	    	solve();
	    	long endTime = System.nanoTime();
	    	System.out.println(endTime - startTime);
	    	
	    	randomGen(100);
	    	startTime = System.nanoTime();
	    	solve();
	    	endTime = System.nanoTime();
	    	System.out.println(endTime - startTime);
	    	
	    	randomGen(1000);
	    	startTime = System.nanoTime();
	    	solve();
	    	endTime = System.nanoTime();
	    	System.out.println(endTime - startTime);
	    	
	  }
	  
	  public void printArray() {
		  for(double[] a: A) {
			  System.out.println(Arrays.toString(a));
		  }
	  }



    public static void main(String[] args) {
    	GEWithPartialPivot g = new GEWithPartialPivot();
//    	g.randomTest();
    	g.getInput();
    	g.solve();
    	g.printResult();


    }
    
  

}
